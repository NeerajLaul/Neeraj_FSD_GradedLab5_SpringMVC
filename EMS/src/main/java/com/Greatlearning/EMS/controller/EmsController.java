package com.Greatlearning.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Greatlearning.EMS.entity.Employee;
import com.Greatlearning.EMS.service.*;

@Controller
@RequestMapping("/EMS")  
public class EmsController {
	
	@Autowired
	EmsService emsservice;
	
	
	@PostMapping("/addEmpReqParam")
	public String addEmployee( @RequestParam("id") int id,
						   @RequestParam("firstName") String fname,
						   @RequestParam("lastName") String lname,
						   @RequestParam("eMail") String mail)
	{
			Employee E1=new Employee(id, fname, lname, mail);
			emsservice.addEmployee(E1);
			return "Employee Added Successfully";
	}
	
	
	@PostMapping("/addEmpReqBody")
	public String addEmployeeReqBody(@RequestBody Employee E1)
	{
			System.out.println(E1.getLastName());
			emsservice.addEmployee(E1);
			return "Employee Added Successfully";
	}
	
	@PostMapping("/addEmployeePathVariable/{id}/{fname}/{lname}/{cat}")
	public String addEmployeePathVariable(@PathVariable("id") int id,
									  @PathVariable("firstName") String fname,
									  @PathVariable("lastName") String lname,
									  @PathVariable("eMail") String mail)
	{
		Employee E1=new Employee(id,fname,lname,mail);
		emsservice.addEmployee(E1);
		return "Employee Added Successfully";
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee( @RequestParam("id") int id)
	{
			emsservice.deleteEmployee(id);
			return "Employee Deleted Successfully";
	}
	
	@GetMapping("/getEmployee")
	public Employee getEmployee( @RequestParam("id") int id)
	{
			return emsservice.getEmployee(id);
			
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees()
	{
			return emsservice.getAllEmployees();
			
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("id")  int id,
			   				 @RequestBody Employee newEmployee)
	{
	emsservice.updateEmployee(id,newEmployee);
	return "Employee Updated Successfully";
	}	
	
	@GetMapping("/list")
	public String listEmployee(Model theModel)
	{
		List<Employee> listEmployees= emsservice.getAllEmployees();
		theModel.addAttribute("Employees", listEmployees);
		return "Employees/list-Employees";
			
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Employee E1=new Employee();
		theModel.addAttribute("Employee", E1);
		return "EMS/Employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("Employee") Employee E1)
	{
			emsservice.addEmployee(E1);
			return "redirect:/Employees/list";
	}
	
	@PostMapping("/delete")
	public String deleteMyEmployee( @RequestParam("EmployeeId") int id)
	{
			emsservice.deleteEmployee(id);
			return "redirect:/Employees/list";
	}
	
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("EmployeeId")  int id,
			   				 Model theModel)
	{
		
	Employee Employeedb=emsservice.getEmployee(id);
	theModel.addAttribute("Employee", Employeedb);
	return "EMS/Employee-form";
	}
}