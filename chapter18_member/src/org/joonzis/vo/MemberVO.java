package org.joonzis.vo;

import java.sql.Date;

public class MemberVO {
	private int m_idx;
	private String mId, mPw, mName, meMail;
	private Date mRegDate;
	public MemberVO() {
	}
	public MemberVO(int m_idx, String mId, String mPw, String mName, String meMail, Date mRegDate) {
		super();
		this.m_idx = m_idx;
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.meMail = meMail;
		this.mRegDate = mRegDate;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getMeMail() {
		return meMail;
	}
	public void setMeMail(String meMail) {
		this.meMail = meMail;
	}
	public Date getmRegDate() {
		return mRegDate;
	}
	public void setmRegDate(Date mRegDate) {
		this.mRegDate = mRegDate;
	}
	
	

}
