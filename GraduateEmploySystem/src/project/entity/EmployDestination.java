package project.entity;

/**
 * EmployDestination类 抽象类
 * 就业去向由待业，研究生，工作单位，企业继承
 * @author 24517
 *1.待业 2.研究生 3.工作 4.创业 5.未登记
 */

public abstract class EmployDestination {
	private String option = "5";
	
	public String getOption() {
		return option;
	}
}
