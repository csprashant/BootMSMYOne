package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.EmpService;

@RestController
public class EmpRestController {
	@Autowired EmpService service;
	
	@PostMapping("save")
	public String saveRecord() {
		Employee emp = new Employee("1035","Siddarth",695844.2,"Tester",11);
		return service.saveEmp(emp);
	}
	
	@GetMapping("get")
	public String getRecord(@RequestParam(name ="name") String name) {
		//return service.getId(name);
		return service.getIdJT(name);
	}
	
	@GetMapping("info")
	public String getIdByNameAndDesiAndsalary(
			@RequestParam(name ="name") String name,
			@RequestParam(name ="desi") String desi) {
		
		return service.getIdByNameAndDesiAndsalary(name, desi);
	}
	
	@GetMapping("pop")
	public String getIdByNameAndDesiAndDeptno(
			@RequestParam(name ="name") String name,
			@RequestParam(name ="desi") String desi,
			@RequestParam(name ="deptno") Integer deptno) {
		
		System.out.println("=============================="+deptno.getClass());
		//return service.getIdByNameAndDesiAndDeptno(name, desi, deptno);
		
		return service.getIdByNameAndDesiAndDeptnoJT(name,desi,deptno);
	}

}
