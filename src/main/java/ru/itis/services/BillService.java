package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Bill;
import ru.itis.models.Payment;
import ru.itis.models.User;
import ru.itis.repositories.BillRepository;
import ru.itis.repositories.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public List<Bill> getAllBills(User user){
        List<Payment> payments = paymentRepository.findAllByPropertyOwner(user.getOwner());
        List<Bill> bills = new ArrayList<>();
        for (Payment payment: payments) {
            bills.add(payment.getBill());
        }
        return bills;
    }
}
