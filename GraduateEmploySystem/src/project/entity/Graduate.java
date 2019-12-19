package project.entity;

/**
 * Graduate�� 
 * ��ҵ�����Ժͷ������˴�Person���м̳еģ�
 * �������е�sex��id����
 * @author 24517
 *
 */

public class Graduate extends Person{
	private String sex; //ѧ�����Ա�
	private String id; //ѧ��
	private String graduateYear; //��ҵ���
	private EmployDestination employDes; //��ҵȥ��
	
	public Graduate() {}
	
	public Graduate(String name,String password,String phoneNumer,String sex,String id,String graduateYear) {
		setName(name);
		setPassword(password);
		setPhoneNumer(phoneNumer);
		this.sex = sex;
		this.id = id;
		this.graduateYear = graduateYear;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getGraduateYear() {
		return graduateYear;
	}

	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}
	
	public EmployDestination getEmployDes() {
		return employDes;
	}

	public void setEmployDes(EmployDestination employDes) {
		this.employDes = employDes;
	}
	
	/**
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "��ҵ����" + getName() + 
				"   ѧ�ţ�" + id +
				"   �Ա�" + sex +
				"   ��ҵ��ݣ� " + graduateYear +
				"   ��ϵ��ʽ��" + getPhoneNumer();
	}
	
	/**
	 * ��ӡѧ���ľ�ҵȥ��
	 * @return
	 */
	public String PrintEmployDes() {
		if(employDes == null) {
			return null;
		}else {
			return employDes.toString();
		}
	}
}
