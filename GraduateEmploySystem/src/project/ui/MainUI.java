package project.ui;

import java.util.Scanner;
import project.util.*;

public class MainUI {
	private static Scanner input = new Scanner(System.in);
	/**
	 * 进入系统UI
	 */
	public static void Welcome() {
		System.out.println("=========================================");
		System.out.println("\t欢迎来到毕业生就业去向管理平台            ");
		System.out.println("=========================================");
//		System.out.println();
	}
	
	/**
	 * 登录模块UI
	 */
	public static void Login() {
//		System.out.println("管理员:admin1  密码:123456");
//		System.out.println("毕业生:001  密码:123456");
		System.out.println("\n==>请先选择的用户类型:");
		System.out.println("    1.毕业生");
		System.out.println("    2.管理员");
		System.out.println("    0.退出系统");
		String select = input.next();
		if(select.equals("1")) {
			/*毕业生的登录页面*/
			StudentUI.login();
		}else if(select.equals("2")) {
			/*管理员的登录页面*/
			AdminUI.login();
		}else if(select.equals("0")){
			/*退出系统*/
			Exit();
		}else {
			System.err.println("输入的格式不正确！\n");
			Login();
		}
	}
	
	/**
	 * 退出系统UI
	 */
	public static void Exit() {
		System.out.println("=====================================");
		System.out.println("               谢谢使用!");
		System.out.println("=====================================");
		System.exit(0);
	}
}
