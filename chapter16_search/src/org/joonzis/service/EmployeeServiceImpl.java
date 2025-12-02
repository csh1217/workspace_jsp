package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = EmployeeDaoImpl.getInstance();//업캐스팅
	
	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}
	
}
