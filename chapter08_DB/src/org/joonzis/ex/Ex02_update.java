package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex02_update {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null; //쿼리 날리기
		
		try {
			conn = DBConnection.getConnection();
			String sql = "update sample set name='박씨' where name='김씨'";
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "김씨");
			
			int result = ps.executeUpdate();
			if (result>0) {
				System.out.println("데이터 변경 성공!");
				conn.commit();
			}else {
				System.out.println("데이터 변경 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				if(conn!= null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
