package project.ui;

import java.util.Scanner; 
import project.service.*;
import project.entity.*;

public class StudentUI {
	/**
	 * 毕业生的登录页面
	 */
	public static void login() {
		Graduate stu;
		System.out.println("\n当前【毕业生】");
		System.out.println(" 1.立即登录(如：用户名001,密码123456)");
		System.out.println(" 0.重新选择身份");
		Scanner input = new Scanner(System.in);
		String name;
		String password;
		String select = input.next();
		if(select.equals("0")) {
			/*返回主登录页面*/
			MainUI.Login();
		}else if(select.equals("1")){
			System.out.print("请输入用户名：");
			name = input.next();
			System.out.print("请输入密码：");
			password = input.next();
			/* 对输入的用户名和密码进行校验，若返回的毕业生为空，说明校验不成功，则重新登陆；否则，进入毕业生主菜单页面  */
			stu = StudentService.findByNameAndPassword(name, password);
			if(stu == null) {
				StudentUI.login();
			}else {
				StudentUI.Menu(stu);
			}
		}else {
			System.err.println("输入的格式不正确！\n");
			StudentUI.login();
		}
	}
	
	/**
	 * 毕业生的主功能菜单
	 * @param stu 
	 */
	public static void Menu(Graduate stu) {
		System.out.println("\n当前【毕业生】-【" + stu.getName() + "】");
		System.out.println("==>请选择你的操作：");
		System.out.println("    1.毕业生就业登记");
		System.out.println("    2.修改个人信息");
		System.out.println("    3.返回登录页");
		System.out.println("    0.退出系统");
		Scanner input = new Scanner(System.in);
		String select = input.next();
		if(select.equals("0")) {
			MainUI.Exit();
		}else if(select.equals("1")) {
			StudentUI.EmployRegister(stu);
		}else if(select.equals("2")) {
			StudentUI.ModifyInfo(stu);
		}else if(select.equals("3")) {
			StudentUI.login();
		}else {
			System.err.println("输入的格式不正确！\n");
			StudentUI.Menu(stu);
		}
	}
	
	/**
	 * 修改个人信息模块
	 * @param stu
	 */
	public static void ModifyInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【毕业生】-【" + stu.getName() + "】=> " + "修改个人信息");
			System.out.println("你现有的个人信息是   " + stu);
			System.out.println("==>请选择你要修改的信息：");
			System.out.println("    1.密码");
			System.out.println("    2.联系方式");
			System.out.println("    0.返回主菜单");
			select = input.next();
			if(select.equals("0")) {
				/*返回毕业生主菜单*/
				StudentUI.Menu(stu);
			}else if(select.equals("1") || select.equals("2")) {
				/*修改个人信息，1为修改密码，2为修改联系方式*/
				StudentService.ModifyInfo(stu, select);
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	/**
	 * 毕业生就业登记
	 */
	public static void EmployRegister(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【毕业生】-【" + stu.getName() + "】=> " + "毕业生就业登记");
			System.out.println("==>请选择你的操作：");
			System.out.println("    1.登记就业去向信息");
			System.out.println("    2.修改就业去向信息");
			System.out.println("    0.返回主菜单");
			select = input.next();
			if(select.equals("0")) {
				StudentUI.Menu(stu);
			}else if(select.equals("1")) {
				if(stu.PrintEmployDes() == null) {
					RegisterEmployInfo(stu);
				}else {
					System.err.println("你已经登记过就业去向信息！");
				}
			}else if(select.equals("2")) {
				if(stu.PrintEmployDes() == null) {
					System.err.println("你还未登记就业去向信息，请先登记！");
				}else {
					EditEmployInfo(stu);
				}
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	/**
	 * 登记就业去向模块
	 * @param stu
	 */
	public static void RegisterEmployInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		System.out.println("\n当前【毕业生】-【" + stu.getName() + "】=> 毕业生就业登记 => 登记就业去向信息");
		System.out.println("==>请选择你的就业去向：");
		System.out.println("    1.待业");
		System.out.println("    2.研究生");
		System.out.println("    3.工作");
		System.out.println("    4.创业");
		System.out.println("    0.返回");
		select = input.next();
		if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4")) {
			StudentService.RegisterEmployInfo(stu, select);
		}else if(select.equals("0")) {
		}else {
			System.err.println("输入的格式不正确！\n");
		}
	}
	
	/**
	 * 修改就业去向模块
	 * @param stu
	 */
	public static void EditEmployInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		System.out.println("\n当前【毕业生】-【" + stu.getName() + "】=> 毕业生就业登记 => 修改就业去向信息");
		System.out.println("你现在的就业信息是：" + stu.PrintEmployDes());
		System.out.println("==>请选择新的就业去向：");
		System.out.println("    1.待业");
		System.out.println("    2.研究生");
		System.out.println("    3.工作");
		System.out.println("    4.创业");
		System.out.println("    0.返回");
		select = input.next();
		if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4")) {
			StudentService.EditEmployInfo(stu, select);
		}else if(select.equals("0")) {
		}else {
			System.err.println("输入的格式不正确！\n");
		}
	}
}
