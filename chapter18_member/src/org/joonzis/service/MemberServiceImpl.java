package org.joonzis.service;

import org.joonzis.dao.MemberDao;
import org.joonzis.dao.MemberDaoImpl;
import org.joonzis.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao = MemberDaoImpl.getInstance();

	@Override
	public int validateId(String mid) {
		// TODO Auto-generated method stub
		return memberDao.validateId(mid);
	}

	@Override
	public int insertMember(MemberVO mvo) {
		return memberDao.insertMember(mvo);
	}

	@Override
	public MemberVO doLogin(MemberVO mvo) {
		// TODO Auto-generated method stub
		return memberDao.doLogin(mvo);
	}
	
	
	
}
