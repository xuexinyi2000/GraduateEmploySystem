package project.entity;

import jdk.javadoc.doclet.Doclet.Option;

/**
 * 继承于抽象类EmployDestination
 * 研究生，属性为所在学校
 * @author 24517
 *
 */

public class PostGraduate extends EmployDestination{
	private String school;
	
	public PostGraduate(){}
	
	public PostGraduate(String school){
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "研究生" + 
				"   所在学校：" + school;
	}
	
	/**
	 * 重写getOption()方法，就业去向为研究生，返回2
	 */
	@Override
	public String getOption() {
		return "2";
	}
}
