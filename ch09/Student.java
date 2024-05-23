package ch09;

import java.sql.Date; //날짜 데이터로 타입을 사용하기 위해 import

public class Student {
	private int id;
	private String username;
	private String univ;
	private Date birth;
	private String email;
	
	public int getId() {    // getter/setter 메서드 자동 생성
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
