package project.entity;

import jdk.javadoc.doclet.Doclet.Option;

/**
 * �̳��ڳ�����EmployDestination
 * �о���������Ϊ����ѧУ
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
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "�о���" + 
				"   ����ѧУ��" + school;
	}
	
	/**
	 * ��дgetOption()��������ҵȥ��Ϊ�о���������2
	 */
	@Override
	public String getOption() {
		return "2";
	}
}
