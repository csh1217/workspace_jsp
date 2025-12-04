package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = EmployeeDaoImpl.getInstance();//업캐스팅
	
	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}
	
	@Override
	public List<EmployeeVO> getDeptId(String deptId){
		return dao.getDeptId(deptId);
	}
	
	@Override
	public List<EmployeeVO> getDynamic(Map<String, Object> info) {
		return dao.getDynamic(info);
	}
}
