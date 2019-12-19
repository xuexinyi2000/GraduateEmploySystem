package project.ui;

import java.util.Scanner;
import project.entity.*;
import project.service.AdminService;
import project.service.StudentService;

public class AdminUI {
	/**
	 * ����Ա�ĵ�¼ҳ��
	 */
	public static void login() {
		Admin adm;
		System.out.println("\n��ǰ������Ա��");
		System.out.println(" 1.������¼(�磺�û���admin1,����123456)");
		System.out.println(" 0.����ѡ�����");
		Scanner input = new Scanner(System.in);
		String name;
		String password;
		String select = input.next();
		if(select.equals("0")) {
			MainUI.Login();
		}else if(select.equals("1")){
			System.out.print("�������û�����");
			name = input.next();
			System.out.print("���������룺");
			password = input.next();
			adm = AdminService.findByNameAndPassword(name, password);
			if(adm == null) {
				AdminUI.login();
			}else {
				AdminUI.Menu(adm);
			}
		}else {
			System.err.println("����ĸ�ʽ����ȷ��\n");
			AdminUI.login();
		}
	}
	
	/**
	 * ����Ա�������ܲ˵�
	 * @param adm
	 */
	public static void Menu(Admin adm) {
		System.out.println("\n��ǰ������Ա��-��" + adm.getName() + "��");
		System.out.println("==>��ѡ����Ĳ�����");
		System.out.println("    1.��ҵ����Ϣ����");
		System.out.println("    2.��Ϣ����ƽ̨");
		System.out.println("    3.�޸ĸ�����Ϣ");
		System.out.println("    4.���ص�¼ҳ");
		System.out.println("    0.�˳�ϵͳ");
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
			System.err.println("����ĸ�ʽ����ȷ��\n");
			AdminUI.Menu(adm);
		}
	}
	
	/**
	 * �޸ĸ�����Ϣģ��
	 * @param adm
	 */
	public static void ModifyInfo(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ������Ա��-��" + adm.getName() +"��=> �޸ĸ�����Ϣ");
			System.out.println("�����еĸ�����Ϣ�� " + adm);
			System.out.println("==>��ѡ����Ҫ�޸ĵ���Ϣ��");
			System.out.println("    1.����");
			System.out.println("    2.��ϵ��ʽ");
			System.out.println("    0.�������˵�");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.Menu(adm);
			}else if(select.equals("1") || select.equals("2")) {
				AdminService.ModifyInfo(adm, select);
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	/**
	 * ��ҵ����Ϣ����
	 * @param adm
	 */
	public static void GraduateInfoManage(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ������Ա��-��" + adm.getName() +"��=> ��ҵ����Ϣ����");
			System.out.println("==>��ѡ����Ĳ�����");
			System.out.println("    1.��ʾ���б�ҵ����Ϣ");
			System.out.println("    2.��ӱ�ҵ��");
			System.out.println("    3.ɾ����ҵ��");
			System.out.println("    4.�༭��ҵ����Ϣ");
			System.out.println("    5.��ѯ��ҵ����Ϣ");
			System.out.println("    0.�������˵�");
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
					System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	/**
	 * ��Ϣ����ƽ̨
	 * @param adm ��ǰ����Ա
	 */
	public static void InfoSummary(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ������Ա��-��" + adm.getName() +"��=> ��Ϣ����ƽ̨");
			System.out.println("==>��ѡ����Ĳ�����");
			System.out.println("    1.��ҵ����ҵȥ�����");
			System.out.println("    2.�������ͳ��");
			System.out.println("    0.�������˵�");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.Menu(adm);
			}else if(select.equals("1")) {
				AdminUI.GraEmploySummary(adm);
			}else if(select.equals("2")) {
				AdminUI.SubTotal(adm);
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	
	/**
	 * ��ҵ����ҵȥ�����
	 * @param adm ��ǰ����Ա
	 */
	public static void GraEmploySummary(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ������Ա��-��" + adm.getName() +"��=> ��Ϣ����ƽ̨ => ��ҵ����ҵȥ�����");
			System.out.println("==>��ѡ����Ҫ�鿴�ı�ҵ����ҵȥ�����ͣ�");
			System.out.println("    1.��ҵ");
			System.out.println("    2.�о���");
			System.out.println("    3.����");
			System.out.println("    4.��ҵ");
			System.out.println("    5.��δ�Ǽǵı�ҵ��");
			System.out.println("    0.����");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.InfoSummary(adm);
			}else if(select.equals("1") || select.equals("2") || select.equals("3") || select.equals("4") || select.equals("5")) {
				AdminService.EmploySummary(select);
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
	
	/**
	 * �������ͳ��
	 * @param adm ��ǰ����Ա
	 */
	public static void SubTotal(Admin adm) {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("\n��ǰ������Ա��-��" + adm.getName() +"��=> ��Ϣ����ƽ̨ => �������ͳ��");
			System.out.println("==>��ѡ����Ĳ�����");
			System.out.println("    1.����ҵ��ݲ鿴�������");
			System.out.println("    2.�鿴���б�ҵ���������");
			System.out.println("    0.����");
			select = input.next();
			if(select.equals("0")) {
				AdminUI.InfoSummary(adm);
			}else if(select.equals("1")) {
				/*����ҵ��ݲ鿴�������*/
				AdminService.SubTotalByYear();
			}else if(select.equals("2")){
				/*�鿴���б�ҵ���������*/
				AdminService.SubTotal();
			}else {
				System.err.println("����ĸ�ʽ����ȷ��\n");
			}
		}
	}
}
