package project.entity;

/**
 * �̳��ڳ�����EmployDestination
 * ��ҵ������Ϊ������λ�͸�λ
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
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "��ҵ" + 
				"   ��λ��" + workPlace +
				"   ��λ��" + station;
	}
	
	/**
	 * ��дgetOption()��������ҵȥ��Ϊ��ҵ������4
	 */
	@Override
	public String getOption() {
		return "4";
	}
}
