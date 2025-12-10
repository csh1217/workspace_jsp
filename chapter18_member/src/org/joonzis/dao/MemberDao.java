package org.joonzis.dao;

import org.joonzis.vo.MemberVO;

public interface MemberDao {
	public int validateId(String mid);
	public int insertMember(MemberVO mvo);
	public MemberVO doLogin(MemberVO mvo);
}
