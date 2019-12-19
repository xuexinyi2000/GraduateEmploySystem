package project.service;

import project.util.*;
import project.entity.*;
import java.util.*;

public class StudentService {
	public static HashMap<String,Graduate> Graduates = InitUser.GraduateList;
	
	/**
	 * ��ҵ����¼��֤
	 * @param name ������û���
	 * @param password ���������
	 * @return ��֤�ɹ����ظñ�ҵ��Graduate�����򷵻�null
	 */
	public static Graduate findByNameAndPassword(String name,String password) {
		int check = 0;
		Graduate stu = new Graduate();
		Graduate temp;
		stu.setName(name);
		stu.setPassword(password);
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("�ñ�ҵ�������ڣ�\n");
		}else {
			if(temp.getPassword().equals(password)) {
				System.out.println("��¼�ɹ���\n");
				check = 1;
			}else {
				System.err.println("�������\n");
			}
		}
		if(check == 1) {
			return temp;
		}else {
			return null;
		}
	}
	
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param stu Ҫ�޸ĵĶ���
	 * @param select Ҫ�޸ĵľ�����Ϣ����һ��,1Ϊ�޸����룬2Ϊ�޸��ֻ�����
	 */
	public static void ModifyInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		Scanner input = new Scanner(System.in);
		if(select.equals("1")) {//�޸�����
			System.out.print("�������µ����룺");
			String newPassword = input.next();
			temp.setPassword(newPassword);
			System.out.println("�޸�����ɹ���\n");
		}else if(select.equals("2")) {//�޸���ϵ��ʽ
			while(true) {
				System.out.print("�������µ��ֻ����룺");
				String newPhoneNum = input.next();
				if(CheckInfo.isPhoneNumber(newPhoneNum)) {
					temp.setPhoneNumer(newPhoneNum);
					System.out.println("�޸���ϵ��ʽ�ɹ���\n");
					break;
				}else {
					System.out.println("��������Ч���ֻ��ţ�");
				}
			}
		}	
	}
	
	
	/**
	 * �ǼǾ�ҵȥ����Ϣ
	 * @param stu
	 * @param select ѡ�����ĸ���ҵȥ��
	 */
	public static void RegisterEmployInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		EmployDestination choose;
		Scanner input = new Scanner(System.in);
		switch(select) {
			/*��ҵ*/
			case "1":
				System.out.println("��ѡ��ľ�ҵȥ��Ϊ����ҵ");
				System.out.print("�������ҵ�����ڳ��У�");
				String city = input.next();
				choose = new Unemployed(city);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ��Ǽǳɹ���\n");
				break;
			/*�о���*/
			case "2":
				System.out.println("��ѡ��ľ�ҵȥ��Ϊ���о���");
				System.out.print("�������о���������ѧУ��");
				String school = input.next();
				choose = new PostGraduate(school);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ��Ǽǳɹ���\n");
				break;
			/*����*/
			case "3":
				System.out.println("��ѡ��ľ�ҵȥ��Ϊ������");
				System.out.print("�����빤����λ��");
				String gWorkPlace = input.next();
				System.out.print("�����빤����λ��");
				String gStation = input.next();
				choose = new Employed(gWorkPlace,gStation);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ��Ǽǳɹ���\n");
				break;
			/*��ҵ*/
			case "4":
				System.out.println("��ѡ��ľ�ҵȥ��Ϊ����ҵ");
				System.out.print("�����봴ҵ��λ��");
				String cWorkPlace = input.next();
				System.out.print("�����봴ҵ��λ��");
				String cStation = input.next();
				choose = new Entrepreneurship(cWorkPlace,cStation);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ��Ǽǳɹ���\n");
				break;
		}
	}
	
	
	/**
	 * �޸ľ�ҵȥ����Ϣ
	 * @param stu Ҫ�޸���Ϣ�ı�ҵ��
	 * @param select �޸ĵ����ԣ�1Ϊ��ҵ��2Ϊ�о�����3Ϊ������4Ϊ��ҵ
	 */
	public static void EditEmployInfo(Graduate stu,String select) {
		Graduate temp = Graduates.get(stu.getName());
		EmployDestination choose;
		Scanner input = new Scanner(System.in);
		switch(select) {
			/*��ҵ*/
			case "1":
				System.out.println("��ѡ����µľ�ҵȥ��Ϊ����ҵ");
				System.out.print("�������ҵ�����ڳ��У�");
				String city = input.next();
				choose = new Unemployed(city);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ���޸ĳɹ���\n");
				break;
			/*�о���*/
			case "2":
				System.out.println("��ѡ����µľ�ҵȥ��Ϊ���о���");
				System.out.print("�������о���������ѧУ��");
				String school = input.next();
				choose = new PostGraduate(school);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ���޸ĳɹ���\n");
				break;
			/*����*/
			case "3":
				System.out.println("��ѡ����µľ�ҵȥ��Ϊ������");
				System.out.print("�����빤����λ��");
				String gWorkPlace = input.next();
				System.out.print("�����빤����λ��");
				String gStation = input.next();
				choose = new Employed(gWorkPlace,gStation);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ���޸ĳɹ���\n");
				break;
			/*��ҵ*/
			case "4":
				System.out.println("��ѡ����µľ�ҵȥ��Ϊ����ҵ");
				System.out.print("�����봴ҵ��λ��");
				String cWorkPlace = input.next();
				System.out.print("�����봴ҵ��λ��");
				String cStation = input.next();
				choose = new Entrepreneurship(cWorkPlace,cStation);
				temp.setEmployDes(choose);
				System.out.println("��ҵȥ���޸ĳɹ���\n");
				break;
		}
	}
}
