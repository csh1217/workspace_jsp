package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	// 필드
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = "";
	
	// 객체 생성자
	// * 싱글톤( 외부에서 접근할 수 없게 private 처리)
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	// 자체적으로 객체 생성(외부에서 객체 생성 불가)
	public static MemberDAO getInstance(){ //외부에서 getInstance 실행 시 같은 객체(dao) 반환
		return dao;
	}
	
	// DBCP 설정
	private static DataSource ds;//sql 패키지
	static {
		try {
			//javax.naming패키지
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// java:comp/env : 톰캣
			// jdbc/oracle : Resource name을 찾아서 ds에 전달
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	// 각 메소드
	// 테이블 전체 목록 가져오는 메소드 - getAllList
	public List<MemberVO> getAllList() {
		List<MemberVO> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "select * from member";//sql문 작성
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { // 데이터가 있을 때
				MemberVO vo = new MemberVO();
				vo.setIdx(rs.getInt(1));//1번째 컬럼을 int로 가져와 
				vo.setId(rs.getString(2));
				vo.setPw(rs.getString(3));
				vo.setName(rs.getString(4));
				vo.setAge(rs.getInt(5));
				vo.setAddr(rs.getString(6));
				vo.setReg_date(rs.getDate(7));
				list.add(vo);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 데이터 삽입 메소드 - insert
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "insert into member values(member_seq.nextval,?,?,?,?,?, sysdate)";//sql문 작성
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getAddr());
			
			result = ps.executeUpdate();
			
			if(result>0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	// 데이터 삭제 메소드 - remove
	public int remove(String id) {
		int result = 0;
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "delete from member where id=?";//sql문 작성
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
		
		
	
	// id를 통해 유저 정보 가져오는 메소드 - getUserInfoById
	public MemberVO getUserInfoById(String id){
		MemberVO table = null;
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "select * from member where id=?";//sql문 작성
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				table = new MemberVO(); // 데이터가 있을 때 객체 생성
				table.setIdx(rs.getInt(1));
				table.setId(rs.getString(2));
				table.setPw(rs.getString(3));
				table.setName(rs.getString(4));
				table.setAge(rs.getInt(5));
				table.setAddr(rs.getString(6));
				table.setReg_date(rs.getDate(7));
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return table;
	}
	
	// 수정할 유저 정보 가져오는 메소드 - getUpdateView
	public MemberVO getUpdateView(String id) {
		MemberVO table = null;
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "select * from member where id=?";//sql문 작성
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				table = new MemberVO(); // 데이터가 있을 때 객체 생성
				table.setIdx(rs.getInt(1));
				table.setId(rs.getString(2));
				table.setPw(rs.getString(3));
				table.setName(rs.getString(4));
				table.setAge(rs.getInt(5));
				table.setAddr(rs.getString(6));
				table.setReg_date(rs.getDate(7));
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return table;
	}
	// 데이터 수정 메소드 - update
	public int update(MemberVO vo) {
		int result = 0;
		try {
			conn = ds.getConnection(); //DB 연결
			sql = "update member set id=?, pw=?, name=?, age=?, addr=? where id = ?";//sql문 작성
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getAddr());
			ps.setString(6, vo.getId());
			result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
