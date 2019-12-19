package project.entity;

/**
 * Admin类
 * 管理员，继承Person类中的属性和方法
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
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "管理员：" + getName() +
				"   联系方式：" + getPhoneNumer();
	}
}