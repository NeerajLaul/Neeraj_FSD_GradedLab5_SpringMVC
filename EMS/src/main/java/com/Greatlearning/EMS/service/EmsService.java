package com.Greatlearning.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Greatlearning.EMS.entity.Employee;
import com.Greatlearning.EMS.repository.EmsRepository;

@Service
public class EmsService {

	@Autowired
	EmsRepository EmsRepo;
	public void addEmployee(Employee E1)
	{
		EmsRepo.save(E1);
	}
	
	public void deleteEmployee(int id)
	{
		EmsRepo.deleteById(id);
	}

	public Employee getEmployee(int id) {
		
		return EmsRepo.findById(id).get();
	}

	public List<Employee> getAllEmployees() {
		
		return EmsRepo.findAll();
	}

	public void updateEmployee(int id, Employee newEmployee) {
		Employee dbemployee=getEmployee(id);
		dbemployee.setLastName(newEmployee.getLastName());
		dbemployee.setEmail(newEmployee.getEmail());
		dbemployee.setFirstName(newEmployee.getfirstName());
		EmsRepo.save(dbemployee);
	}
}