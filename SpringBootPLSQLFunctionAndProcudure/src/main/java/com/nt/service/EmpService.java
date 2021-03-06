package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	EmpRepo repo;
	@Autowired
	EntityManager manager;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

		
	public String saveEmp(Employee emp) {
		//repo.save(emp);
		jdbcTemplate.update("insert into emp(id,name,designation,salary,deptno) values(?,?,?,?,?)", 
								1024,emp.getName(),emp.getDesignation(),emp.getSalary(),emp.getDeptno());
		return "Recoard inserted";
	}

	public String getId(String name) {
		Session session = manager.unwrap(Session.class);
		String s = session.doReturningWork(con -> {
			// create Callable statement obj
			CallableStatement cs = con.prepareCall("{?=call get_id_of_employee(?)}");
			// register return,out parmaters
			cs.registerOutParameter(1, Types.VARCHAR); // return param (?4)
			// set value IN param
			cs.setString(2, name);
			// call PL/SQL function
			cs.execute();
			String ID = cs.getString(1);
			return ID;
		});
		return s;
	}
	
	public String getIdByNameAndDesiAndsalary(String name,String desi) {
		Session session = manager.unwrap(Session.class);
		String s =session.doReturningWork(con->{
	    	//create Callable statement obj
	    	CallableStatement cs=con.prepareCall("{?=call g(?,?)}");
	    	//register return,out parmaters	
	    	cs.registerOutParameter(1, Types.VARCHAR); //return param (?4)
	    	//set value IN param
	    	cs.setString(2, name);
	    	cs.setString(3, desi);
	    	//call PL/SQL function
	    	cs.execute();
	    	String ID = cs.getString(1);
	    	return ID;
			
	});
		return s;

	}
	
	public String getIdByNameAndDesiAndDeptno(String name,String desi,Integer deptno) {
		Session session = manager.unwrap(Session.class);
		String s =session.doReturningWork(con->{
	    	//create Callable statement obj
	    	CallableStatement cs=con.prepareCall("{?=call get_fun(?,?,?)}");
	    	//register return,out parmaters	
	    	cs.registerOutParameter(1, Types.VARCHAR); //return param (?4)
	    	//set value IN param
	    	cs.setString(2, name);
	    	cs.setString(3, desi);
	    	cs.setInt(4, deptno);
	    	//call PL/SQL function
	    	cs.execute();
	    	String ID = cs.getString(1);
	    	return ID;
			
	});
		return s;

	}
	
	public String getIdJT(String name) {
		SimpleJdbcCall sjc = new SimpleJdbcCall(jdbcTemplate);
		sjc = sjc.withFunctionName("get_id_of_employee");
		SqlParameterSource in = new MapSqlParameterSource().addValue("ename", name);
		String n = sjc.executeFunction(String.class, in);
		return n;
	}
	
	public String getIdByNameAndDesiAndDeptnoJT(String name,String desi,Integer deptno) {
		// crating simpleJdbcCall  with PL/SQL function name
		SimpleJdbcCall sjc = new SimpleJdbcCall(jdbcTemplate).withFunctionName("get_fun");
		// preparing inputs to PL/SQL function in the form of map object
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("ename", name);
		inputMap.put("desi", desi);
		inputMap.put("dept", deptno);
		return sjc.executeFunction(String.class,inputMap);// (1st is output type , 2nd is input data for PL/SQL it can be varAgrs ,Map .... )

	}
	
	
}