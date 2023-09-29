package com.Greatlearning.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Greatlearning.EMS.entity.Employee;


@Repository
public interface EmsRepository extends JpaRepository<Employee, Integer>{

}
