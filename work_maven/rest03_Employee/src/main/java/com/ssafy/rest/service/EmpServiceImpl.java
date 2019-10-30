package com.ssafy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.repo.EmpDAO;
import com.ssafy.restful.vo.EmployeeDto;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAO dao;
	
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return dao.findAllEmployees();
	}

	@Override
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return dao.findEmployeeById(id);
	}

	@Override
	public int getEmployeesTotal() throws Exception {
		return dao.getEmployeesTotal();
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
		return dao.findLikeEmployees(name);
	}

	@Override
	public void addEmployee(EmployeeDto emp) throws Exception {
		dao.addEmployee(emp);
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		return dao.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int id) throws Exception {
		return dao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) throws Exception {
		return dao.findEmployeesByManagerId(managerId);
	}

	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) throws Exception {
		return dao.findDepartmentsBydeptid(dept_id);
	}
	
}
