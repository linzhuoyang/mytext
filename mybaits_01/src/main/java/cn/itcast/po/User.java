package cn.itcast.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer id;
	private String userName;// 用户名称',
	private Date birthday;// 生日',
	private String sex;// 性别',
	private String address;// 地址',
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	public User(Integer id, String userName, Date birthday, String sex, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	

}
