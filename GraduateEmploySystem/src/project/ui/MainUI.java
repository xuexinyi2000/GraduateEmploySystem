package project.ui;

import java.util.Scanner;
import project.util.*;

public class MainUI {
	private static Scanner input = new Scanner(System.in);
	/**
	 * ����ϵͳUI
	 */
	public static void Welcome() {
		System.out.println("=========================================");
		System.out.println("\t��ӭ������ҵ����ҵȥ�����ƽ̨            ");
		System.out.println("=========================================");
//		System.out.println();
	}
	
	/**
	 * ��¼ģ��UI
	 */
	public static void Login() {
//		System.out.println("����Ա:admin1  ����:123456");
//		System.out.println("��ҵ��:001  ����:123456");
		System.out.println("\n==>����ѡ����û�����:");
		System.out.println("    1.��ҵ��");
		System.out.println("    2.����Ա");
		System.out.println("    0.�˳�ϵͳ");
		String select = input.next();
		if(select.equals("1")) {
			/*��ҵ���ĵ�¼ҳ��*/
			StudentUI.login();
		}else if(select.equals("2")) {
			/*����Ա�ĵ�¼ҳ��*/
			AdminUI.login();
		}else if(select.equals("0")){
			/*�˳�ϵͳ*/
			Exit();
		}else {
			System.err.println("����ĸ�ʽ����ȷ��\n");
			Login();
		}
	}
	
	/**
	 * �˳�ϵͳUI
	 */
	public static void Exit() {
		System.out.println("=====================================");
		System.out.println("               ллʹ��!");
		System.out.println("=====================================");
		System.exit(0);
	}
}
