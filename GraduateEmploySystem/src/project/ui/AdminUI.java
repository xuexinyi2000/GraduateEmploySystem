package project.ui;

import java.util.Scanner;
import project.entity.*;
import project.service.AdminService;
import project.service.StudentService;

public class AdminUI {
	/**
	 * 管理员的登录页面
	 */
	public static void login() {
		Admin adm;
		System.out.println("\n当前【管理员】");
		System.out.println(" 1.立即登录(如：用户名admin1,密码123456)");
		System.out.println(" 0.重新选择身份");
		Scanner input = new Scanner(System.in);
		String name;
		String password;
		String select = input.next();
		if(select.equals("0")) {
			MainUI.Login();
		}else if(select.equals("1")){
			System.out.print("请输入用户名：");
			name = input.next();
			System.out.print("请输入密码：");
			password = input.next();
			adm = AdminService.findByNameAndPassword(name, password);
			if(adm == null) {
				AdminUI.login();
			}else {
				AdminUI.Menu(adm);
			}
		}else {
			System.err.println("输入的格式不正确！\n");
			AdminUI.login();
		}
	}
	
	/**
	 * 管理员的主功能菜单
	 * @param adm
	 */
	public static void Menu(Admin adm) {
		System.out.println("\n当前【管理员】-【" + adm.getName() + "】");
		System.out.println("==>请选择你的操作：");
		System.out.println("    1.毕业生信息管理");
		System.out.println("    2.信息汇总平台");
		System.out.println("    3.修改个人信息");
		System.out.println("    4.返回登录页");
		System.out.println("    0.退出系统");
		Scanner input = new Scanner(System.in);
		String select = input.next();
		if(select.equals("0")) {
			MainUI.Exit();
		}else if(select.equals("1")) {
			AdminUI.GraduateInfoManage(adm);
		}else if(select.equals("2")) {
			AdminUI.InfoSummary(adm);
		}else if(select.equals("3")) {
			AdminUI.ModifyInfo(adm);
		}else if(select.equals("4")){
			AdminUI.login();
		}else {
			System.err.println("输入的格式不正确！\n");
			AdminUI.Menu(adm);
		}
	}
	
	/**
	 * 修改个人信息模块
	 * @param adm
	 */
	public static void ModifyInfo(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【管理员】-【" + adm.getName() +"】=> 修改个人信息");
			System.out.println("你现有的个人信息是 " + adm);
			System.out.println("==>请选择你要修改的信息：");
			System.out.println("    1.密码");
			System.out.println("    2.联系方式");
			System.out.println("    0.返回主菜单");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.Menu(adm);
			}else if(select.equals("1") || select.equals("2")) {
				AdminService.ModifyInfo(adm, select);
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	/**
	 * 毕业生信息管理
	 * @param adm
	 */
	public static void GraduateInfoManage(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【管理员】-【" + adm.getName() +"】=> 毕业生信息管理");
			System.out.println("==>请选择你的操作：");
			System.out.println("    1.显示所有毕业生信息");
			System.out.println("    2.添加毕业生");
			System.out.println("    3.删除毕业生");
			System.out.println("    4.编辑毕业生信息");
			System.out.println("    5.查询毕业生信息");
			System.out.println("    0.返回主菜单");
			select = input.next();
			switch(select) {
				case "1":
					AdminService.ShowAllGraInfo();
					break;
				case "2":
					AdminService.AddGraInfo();
					break;
				case "3":
					AdminService.DelGraInfo();
					break;
				case "4":
					AdminService.EditGraInfo();
					break;
				case "5":
					AdminService.SearchGraInfo();
					break;
				case "0":
					AdminUI.Menu(adm);
				default:
					System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	/**
	 * 信息汇总平台
	 * @param adm 当前管理员
	 */
	public static void InfoSummary(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【管理员】-【" + adm.getName() +"】=> 信息汇总平台");
			System.out.println("==>请选择你的操作：");
			System.out.println("    1.毕业生就业去向汇总");
			System.out.println("    2.分类汇总统计");
			System.out.println("    0.返回主菜单");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.Menu(adm);
			}else if(select.equals("1")) {
				AdminUI.GraEmploySummary(adm);
			}else if(select.equals("2")) {
				AdminUI.SubTotal(adm);
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	
	/**
	 * 毕业生就业去向汇总
	 * @param adm 当前管理员
	 */
	public static void GraEmploySummary(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【管理员】-【" + adm.getName() +"】=> 信息汇总平台 => 毕业生就业去向汇总");
			System.out.println("==>请选择你要查看的毕业生就业去向类型：");
			System.out.println("    1.待业");
			System.out.println("    2.研究生");
			System.out.println("    3.工作");
			System.out.println("    4.创业");
			System.out.println("    5.还未登记的毕业生");
			System.out.println("    0.返回");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.InfoSummary(adm);
			}else if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4") || select.equals("5")) {
				AdminService.EmploySummary(select);
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
	
	/**
	 * 分类汇总统计
	 * @param adm 当前管理员
	 */
	public static void SubTotal(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n当前【管理员】-【" + adm.getName() +"】=> 信息汇总平台 => 分类汇总统计");
			System.out.println("==>请选择你的操作：");
			System.out.println("    1.按毕业年份查看汇总情况");
			System.out.println("    2.查看所有毕业生汇总情况");
			System.out.println("    0.返回");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.InfoSummary(adm);
			}else if(select.equals("1")) {
				/*按毕业年份查看汇总情况*/
				AdminService.SubTotalByYear();
			}else if(select.equals("2")){
				/*查看所有毕业生汇总情况*/
				AdminService.SubTotal();
			}else {
				System.err.println("输入的格式不正确！\n");
			}
		}
	}
}
