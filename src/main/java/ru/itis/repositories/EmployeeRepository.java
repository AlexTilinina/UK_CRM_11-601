package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
