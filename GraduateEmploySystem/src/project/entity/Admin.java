package project.entity;

/**
 * Admin��
 * ����Ա���̳�Person���е����Ժͷ���
 * @author 24517
 *
 */

public class Admin extends Person{
	public Admin() {}
	
	public Admin(String name,String password,String phoneNumer) {
		setName(name);
		setPassword(password);
		setPhoneNumer(phoneNumer);
	}
	
	/**
	 * ��дtoString����
	 */
	@Override
	public String toString() {
		return "����Ա��" + getName() +
				"   ��ϵ��ʽ��" + getPhoneNumer();
	}
}