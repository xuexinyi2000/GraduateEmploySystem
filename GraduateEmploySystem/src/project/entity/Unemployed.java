package project.entity;

/**
 * �̳��ڳ�����EmployDestination
 * ��ҵ������Ϊ���ڳ���
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
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "��ҵ" +
				"   ���ڳ��У�" + city;
	}
	
	/**
	 * ��дgetOption()��������ҵȥ��Ϊ��ҵ������1
	 */
	@Override
	public String getOption() {
		return "1";
	}
}
