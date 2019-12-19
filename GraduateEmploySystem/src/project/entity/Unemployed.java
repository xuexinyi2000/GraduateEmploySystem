package project.entity;

/**
 * 继承于抽象类EmployDestination
 * 待业，属性为所在城市
 * @author 24517
 *
 */

public class Unemployed extends EmployDestination{
	private String city;
	
	public Unemployed() {}
	
	public Unemployed(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "待业" +
				"   所在城市：" + city;
	}
	
	/**
	 * 重写getOption()方法，就业去向为待业，返回1
	 */
	@Override
	public String getOption() {
		return "1";
	}
}
