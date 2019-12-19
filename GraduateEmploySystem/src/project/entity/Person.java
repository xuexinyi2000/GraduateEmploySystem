package project.entity;

/**
 * Person类，属性有用户名，密码和手机号
 * 供Graduate类和Admin类继承
 * @author 24517
 *
 */
public class Person {
	private String name; //用户名
	private String password; //密码
	private String phoneNumer; //手机号
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumer() {
		return phoneNumer;
	}
	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	
 }
