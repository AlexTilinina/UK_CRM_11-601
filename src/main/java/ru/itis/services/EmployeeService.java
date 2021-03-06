package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.EditProfileDto;
import ru.itis.dto.EmployeeRegistration;
import ru.itis.models.Employee;
import ru.itis.models.Position;
import ru.itis.models.Role;
import ru.itis.models.User;
import ru.itis.repositories.EmployeeRepository;
import ru.itis.repositories.PositionRepository;
import ru.itis.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void register(EmployeeRegistration employeeRegistration) {

        User user = User.builder()
                .firstName(employeeRegistration.getFirstName())
                .secondName(employeeRegistration.getSecondName())
                .lastName(employeeRegistration.getLastName())
                .email(employeeRegistration.getEmail())
                .role(Role.EMPLOYEE)
                .login(employeeRegistration.getLogin())
                .password(passwordEncoder.encode(employeeRegistration.getPassword()))
                .build();

        Employee employee = Employee.builder()
                .user(user)
                .claims(new HashSet<>())
                .build();

        Position position = getPosition(employeeRegistration.getPosition());
        setEmployee(position, employee);

        employee.setPosition(position);
        user.setEmployee(employee);

        employeeRepository.save(employee);
    }

    @Transactional
    protected Position getPosition(String name) {
        return positionRepository.findPositionByName(name);
    }

    private void setEmployee(Position position, Employee employee) {
        Set<Employee> employees = position.getEmployees();
        employees.add(employee);
        position.setEmployees(employees);
    }

    public void edit(EditProfileDto editProfileDto, Long id) {
        User user = userRepository.findById(id);
        Employee employee = user.getEmployee();
        user.setFirstName(editProfileDto.getFirstName());
        user.setSecondName(editProfileDto.getSecondName());
        user.setLastName(editProfileDto.getLastName());
        Position position = positionRepository.findPositionByName(editProfileDto.getPosition());
        employee.setPosition(position);
        userRepository.save(user);
        employeeRepository.save(employee);
    }
}
