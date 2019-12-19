package project.entity;

/**
 * Graduate类 
 * 毕业生属性和方法除了从Person类中继承的，
 * 还有特有的sex和id属性
 * @author 24517
 *
 */

public class Graduate extends Person{
	private String sex; //学生的性别
	private String id; //学号
	private String graduateYear; //毕业年份
	private EmployDestination employDes; //就业去向
	
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
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "毕业生：" + getName() + 
				"   学号：" + id +
				"   性别：" + sex +
				"   毕业年份： " + graduateYear +
				"   联系方式：" + getPhoneNumer();
	}
	
	/**
	 * 打印学生的就业去向
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
