package project.entity;

/**
 * �̳��ڳ�����EmployDestination
 * ����������Ϊ������λ�͸�λ
 * @author 24517
 *
 */

public class Employed extends EmployDestination{
	private String workPlace;
	private String station;
	
	public Employed() {}
	
	public Employed(String workPlance,String station) {
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
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "����" +
				"   ��λ��" + workPlace +
				"   ��λ��" + station;
	}
	
	/**
	 * ��дgetOption()��������ҵȥ��Ϊ����������3
	 */
	@Override
	public String getOption() {
		return "3";
	}
}
