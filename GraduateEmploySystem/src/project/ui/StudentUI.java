package project.ui;

import java.util.Scanner; 
import project.service.*;
import project.entity.*;

public class StudentUI {
	/**
	 * ��ҵ���ĵ�¼ҳ��
	 */
	public static void login() {
		Graduate stu;
		System.out.println("\n��ǰ����ҵ����");
		System.out.println(" 1.������¼(�磺�û���001,����123456)");
		System.out.println(" 0.����ѡ�����");
		Scanner input = new Scanner(System.in);
		String name;
		String password;
		String select = input.next();
		if(select.equals("0")) {
			/*��������¼ҳ��*/
			MainUI.Login();
		}else if(select.equals("1")){
			System.out.print("�������û�����");
			name = input.next();
			System.out.print("���������룺");
			password = input.next();
			/* ��������û������������У�飬�����صı�ҵ��Ϊ�գ�˵��У�鲻�ɹ��������µ�½�����򣬽����ҵ�����˵�ҳ��  */
			stu = StudentService.findByNameAndPassword(name, password);
			if(stu == null) {
				StudentUI.login();
			}else {
				StudentUI.Menu(stu);
			}
		}else {
			System.err.println("����ĸ�ʽ����ȷ��\n");
			StudentUI.login();
		}
	}
	
	/**
	 * ��ҵ���������ܲ˵�
	 * @param stu 
	 */
	public static void Menu(Graduate stu) {
		System.out.println("\n��ǰ����ҵ����-��" + stu.getName() + "��");
		System.out.println("==>��ѡ����Ĳ�����");
		System.out.println("    1.��ҵ����ҵ�Ǽ�");
		System.out.println("    2.�޸ĸ�����Ϣ");
		System.out.println("    3.���ص�¼ҳ");
		System.out.println("    0.�˳�ϵͳ");
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
			System.err.println("����ĸ�ʽ����ȷ��\n");
			StudentUI.Menu(stu);
		}
	}
	
	/**
	 * �޸ĸ�����Ϣģ��
	 * @param stu
	 */
	public static void ModifyInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ����ҵ����-��" + stu.getName() + "��=> " + "�޸ĸ�����Ϣ");
			System.out.println("�����еĸ�����Ϣ��   " + stu);
			System.out.println("==>��ѡ����Ҫ�޸ĵ���Ϣ��");
			System.out.println("    1.����");
			System.out.println("    2.��ϵ��ʽ");
			System.out.println("    0.�������˵�");
			select = input.next();
			if(select.equals("0")) {
				/*���ر�ҵ�����˵�*/
				StudentUI.Menu(stu);
			}else if(select.equals("1") || select.equals("2")) {
				/*�޸ĸ�����Ϣ��1Ϊ�޸����룬2Ϊ�޸���ϵ��ʽ*/
				StudentService.ModifyInfo(stu, select);
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	/**
	 * ��ҵ����ҵ�Ǽ�
	 */
	public static void EmployRegister(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ����ҵ����-��" + stu.getName() + "��=> " + "��ҵ����ҵ�Ǽ�");
			System.out.println("==>��ѡ����Ĳ�����");
			System.out.println("    1.�ǼǾ�ҵȥ����Ϣ");
			System.out.println("    2.�޸ľ�ҵȥ����Ϣ");
			System.out.println("    0.�������˵�");
			select = input.next();
			if(select.equals("0")) {
				StudentUI.Menu(stu);
			}else if(select.equals("1")) {
				if(stu.PrintEmployDes() == null) {
					RegisterEmployInfo(stu);
				}else {
					System.err.println("���Ѿ��Ǽǹ���ҵȥ����Ϣ��");
				}
			}else if(select.equals("2")) {
				if(stu.PrintEmployDes() == null) {
					System.err.println("�㻹δ�ǼǾ�ҵȥ����Ϣ�����ȵǼǣ�");
				}else {
					EditEmployInfo(stu);
				}
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	/**
	 * �ǼǾ�ҵȥ��ģ��
	 * @param stu
	 */
	public static void RegisterEmployInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		System.out.println("\n��ǰ����ҵ����-��" + stu.getName() + "��=> ��ҵ����ҵ�Ǽ� => �ǼǾ�ҵȥ����Ϣ");
		System.out.println("==>��ѡ����ľ�ҵȥ��");
		System.out.println("    1.��ҵ");
		System.out.println("    2.�о���");
		System.out.println("    3.����");
		System.out.println("    4.��ҵ");
		System.out.println("    0.����");
		select = input.next();
		if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4")) {
			StudentService.RegisterEmployInfo(stu, select);
		}else if(select.equals("0")) {
		}else {
			System.err.println("����ĸ�ʽ����ȷ��\n");
		}
	}
	
	/**
	 * �޸ľ�ҵȥ��ģ��
	 * @param stu
	 */
	public static void EditEmployInfo(Graduate stu) {
		Scanner input = new Scanner(System.in);
		String select;
		System.out.println("\n��ǰ����ҵ����-��" + stu.getName() + "��=> ��ҵ����ҵ�Ǽ� => �޸ľ�ҵȥ����Ϣ");
		System.out.println("�����ڵľ�ҵ��Ϣ�ǣ�" + stu.PrintEmployDes());
		System.out.println("==>��ѡ���µľ�ҵȥ��");
		System.out.println("    1.��ҵ");
		System.out.println("    2.�о���");
		System.out.println("    3.����");
		System.out.println("    4.��ҵ");
		System.out.println("    0.����");
		select = input.next();
		if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4")) {
			StudentService.EditEmployInfo(stu, select);
		}else if(select.equals("0")) {
		}else {
			System.err.println("����ĸ�ʽ����ȷ��\n");
		}
	}
}
