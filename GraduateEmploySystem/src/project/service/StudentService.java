package project.service;

import project.util.*;
import project.entity.*;
import java.util.*;

public class StudentService {
	public static HashMap<String,Graduate> Graduates = InitUser.GraduateList;
	
	/**
	 * 毕业生登录验证
	 * @param name 输入的用户名
	 * @param password 输入的密码
	 * @return 验证成功返回该毕业生Graduate，否则返回null
	 */
	public static Graduate findByNameAndPassword(String name,String password) {
		int check = 0;
		Graduate stu = new Graduate();
		Graduate temp;
		stu.setName(name);
		stu.setPassword(password);
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("该毕业生不存在！\n");
		}else {
			if(temp.getPassword().equals(password)) {
				System.out.println("登录成功！\n");
				check = 1;
			}else {
				System.err.println("密码错误！\n");
			}
		}
		if(check == 1) {
			return temp;
		}else {
			return null;
		}
	}
	
	
	/**
	 * 修改个人信息
	 * @param stu 要修改的对象
	 * @param select 要修改的具体信息是哪一条,1为修改密码，2为修改手机号码
	 */
	public static void ModifyInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		Scanner input = new Scanner(System.in);
		if(select.equals("1")) {//修改密码
			System.out.print("请输入新的密码：");
			String newPassword = input.next();
			temp.setPassword(newPassword);
			System.out.println("修改密码成功！\n");
		}else if(select.equals("2")) {//修改联系方式
			while(true) {
				System.out.print("请输入新的手机号码：");
				String newPhoneNum = input.next();
				if(CheckInfo.isPhoneNumber(newPhoneNum)) {
					temp.setPhoneNumer(newPhoneNum);
					System.out.println("修改联系方式成功！\n");
					break;
				}else {
					System.out.println("请输入有效的手机号！");
				}
			}
		}	
	}
	
	
	/**
	 * 登记就业去向信息
	 * @param stu
	 * @param select 选择了哪个就业去向
	 */
	public static void RegisterEmployInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		EmployDestination choose;
		Scanner input = new Scanner(System.in);
		switch(select) {
			/*待业*/
			case "1":
				System.out.println("你选择的就业去向为：待业");
				System.out.print("请输入待业的所在城市：");
				String city = input.next();
				choose = new Unemployed(city);
				temp.setEmployDes(choose);
				System.out.println("就业去向登记成功！\n");
				break;
			/*研究生*/
			case "2":
				System.out.println("你选择的就业去向为：研究生");
				System.out.print("请输入研究生的所在学校：");
				String school = input.next();
				choose = new PostGraduate(school);
				temp.setEmployDes(choose);
				System.out.println("就业去向登记成功！\n");
				break;
			/*工作*/
			case "3":
				System.out.println("你选择的就业去向为：工作");
				System.out.print("请输入工作单位：");
				String gWorkPlace = input.next();
				System.out.print("请输入工作岗位：");
				String gStation = input.next();
				choose = new Employed(gWorkPlace,gStation);
				temp.setEmployDes(choose);
				System.out.println("就业去向登记成功！\n");
				break;
			/*创业*/
			case "4":
				System.out.println("你选择的就业去向为：创业");
				System.out.print("请输入创业单位：");
				String cWorkPlace = input.next();
				System.out.print("请输入创业岗位：");
				String cStation = input.next();
				choose = new Entrepreneurship(cWorkPlace,cStation);
				temp.setEmployDes(choose);
				System.out.println("就业去向登记成功！\n");
				break;
		}
	}
	
	
	/**
	 * 修改就业去向信息
	 * @param stu 要修改信息的毕业生
	 * @param select 修改的属性，1为待业，2为研究生，3为工作，4为创业
	 */
	public static void EditEmployInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		EmployDestination choose;
		Scanner input = new Scanner(System.in);
		switch(select) {
			/*待业*/
			case "1":
				System.out.println("你选择的新的就业去向为：待业");
				System.out.print("请输入待业的所在城市：");
				String city = input.next();
				choose = new Unemployed(city);
				temp.setEmployDes(choose);
				System.out.println("就业去向修改成功！\n");
				break;
			/*研究生*/
			case "2":
				System.out.println("你选择的新的就业去向为：研究生");
				System.out.print("请输入研究生的所在学校：");
				String school = input.next();
				choose = new PostGraduate(school);
				temp.setEmployDes(choose);
				System.out.println("就业去向修改成功！\n");
				break;
			/*工作*/
			case "3":
				System.out.println("你选择的新的就业去向为：工作");
				System.out.print("请输入工作单位：");
				String gWorkPlace = input.next();
				System.out.print("请输入工作岗位：");
				String gStation = input.next();
				choose = new Employed(gWorkPlace,gStation);
				temp.setEmployDes(choose);
				System.out.println("就业去向修改成功！\n");
				break;
			/*创业*/
			case "4":
				System.out.println("你选择的新的就业去向为：创业");
				System.out.print("请输入创业单位：");
				String cWorkPlace = input.next();
				System.out.print("请输入创业岗位：");
				String cStation = input.next();
				choose = new Entrepreneurship(cWorkPlace,cStation);
				temp.setEmployDes(choose);
				System.out.println("就业去向修改成功！\n");
				break;
		}
	}
}
