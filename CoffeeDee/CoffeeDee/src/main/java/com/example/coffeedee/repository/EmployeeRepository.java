package com.example.coffeedee.repository;

import com.example.coffeedee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.deleted = false and e.id = :id")
    Employee getEmployeeById(Long id);
}