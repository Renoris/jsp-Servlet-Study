package kr.ac.jejunu.Model.VO;

public class ProfessorVO {
	private int prn;
	private String name;
	private String department;
	private String phone;
	public int getPrn() {
		return prn;
	}
	public void setPrn(int prn) {
		this.prn = prn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
