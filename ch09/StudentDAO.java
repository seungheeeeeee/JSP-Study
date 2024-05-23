package ch09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tpc://localhost/~/jwbookdb";
	// 연결/종료 메서드 구현
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
		} 	catch (Exception e) {e.printStackTrace();}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close(); 
		}   catch (Exception e) {e.printStackTrace();}
	}
	// 학생 등록 메서드 구현
	public void insert(Student s) {
		open();
		String sql = 
				"INSERT INTO student(username, univ, birth, email) values(?,?,?,?)"; // PreparedStatement를 이용해'?'에 해당하는 데이터를 매핑한다.
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		  finally {close();}
	}
	//학생 목록 메서드 구현
	public List<Student> getAll() {
		open();
		List<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student"); //전체 학생 목록 가져오기
			ResultSet rs = pstmt.executeQuery(); // ReasultSet을 이용헤 Student 객체에 매핑
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
		} catch (Exception e) {e.printStackTrace();} //예외 처리
		  finally {close();} //연결 종료
		return students;
	}
}
