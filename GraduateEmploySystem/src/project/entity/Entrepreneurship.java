package project.entity;

/**
 * 继承于抽象类EmployDestination
 * 创业，属性为工作单位和岗位
 * @author 24517
 *
 */

public class Entrepreneurship extends EmployDestination{
	private String workPlace;
	private String station;
	
	public Entrepreneurship() {}
	
	public Entrepreneurship(String workPlance,String station) {
		this.workPlace = workPlance;
		this.station = station;
	}
	
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "创业" + 
				"   单位：" + workPlace +
				"   岗位：" + station;
	}
	
	/**
	 * 重写getOption()方法，就业去向为创业，返回4
	 */
	@Override
	public String getOption() {
		return "4";
	}
}
