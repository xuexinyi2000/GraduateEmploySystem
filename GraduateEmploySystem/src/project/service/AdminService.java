package project.service;

import project.util.InitUser;
import project.entity.*;
import java.util.*;

public class AdminService {
	public static HashMap<String,Admin> Admins = InitUser.AdminList;
	public static HashMap<String,Graduate> Graduates = InitUser.GraduateList;
	
	/**
	 * ����Ա��¼��֤
	 * @param name ������û���
	 * @param password ���������
	 * @return ��֤�ɹ����ظù���ԱAdmin��Ϣ�����򷵻�null
	 */
	public static Admin findByNameAndPassword(String name,String password) {
		int check = 0;
		Admin adm = new Admin();
		Admin temp;
		adm.setName(name);
		adm.setPassword(password);
		temp = Admins.get(name);
		if(temp == null) {
			System.err.println("�ù���Ա�����ڣ�\n");
		}else{
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
	 * @param adm Ҫ�޸ĵĹ���Ա
	 * @param select �����޸ĵ���Ϣ��ʲô��Ҫ�޸ĵľ�����Ϣ����һ��,1Ϊ�޸����룬2Ϊ�޸��ֻ�����
	 */
	public static void ModifyInfo(Admin adm,String select) {
		Admin temp = Admins.get(adm.getName());
		Scanner input = new Scanner(System.in);
		/*�޸�����*/
		if(select.equals("1")) {
			System.out.print("�������µ����룺");
			String newPassword = input.next();
			temp.setPassword(newPassword);
			System.out.println("�޸�����ɹ���\n");
		/*�޸���ϵ��ʽ*/
		}else if(select.equals("2")) {
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
	 * �������б�ҵ����Ϣ
	 */
	public static void ShowAllGraInfo() {
		System.out.println("���������б�ҵ������Ϣ��");
		int count = 1;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate graduate = Graduates.get(name);
			System.out.println(count + "   ������Ϣ��" + graduate);
			if(graduate.getEmployDes() == null) {
				System.out.println("\t��ҵȥ�򣺻�δ�ǼǾ�ҵȥ��");
			}else {
				System.out.println("\t��ҵȥ��" + graduate.getEmployDes());
			}
			count++;
		}
		System.out.println("���� "+ (count-1) + " ����ҵ����Ϣ");
		System.out.println();
	}
	
	
	/**
	 * ��ӱ�ҵ����Ϣ
	 */
	public static void AddGraInfo() {
		Scanner input = new Scanner(System.in);
		String name,password,phoneNumber,id,sex,graduateYear;
		/*��ʼ����Ϊ123456*/
		password = "123456";
		/*�û���*/
		while(true) {
			System.out.print("������Ҫ��ӵı�ҵ���û�����");
			name = input.next();
			if(CheckInfo.CheckName(name)) {
				break;
			}else {
				System.err.println("���û������б�ҵ��ʹ�ã����������룡");
			}
		}
		/*��ϵ��ʽ*/
		while(true) {
			System.out.print("������Ҫ��ӵı�ҵ����ϵ��ʽ��");
			phoneNumber = input.next();
			if(CheckInfo.isPhoneNumber(phoneNumber)) {
				break;
			}else {
				System.out.println("��������Ч���ֻ��ţ�");
			}
		}
		/*ѧ��*/
		System.out.print("������Ҫ��ӵı�ҵ��ѧ�ţ�");
		id = input.next();
		/*�Ա�*/
		System.out.print("������Ҫ��ӵı�ҵ���Ա�");
		sex = input.next();
		/*��ҵ���*/
		System.out.print("������Ҫ��ӵı�ҵ����ҵ��ݣ�");
		graduateYear = input.next();
		Graduate newgraduate = new Graduate(name,password,phoneNumber,sex,id,graduateYear);
		Graduates.put(name,newgraduate);
		System.out.println("��ӱ�ҵ�� "+ name + " �ɹ�����¼��ʼ����Ϊ123456 \n");
	}
	
	
	/**
	 * ɾ����ҵ����Ϣ
	 */
	public static void DelGraInfo() {
		Graduate temp;
		Scanner input = new Scanner(System.in);
		String name,select;
		System.out.print("������Ҫɾ���ı�ҵ�����û���(�磺001)��");
		name = input.next();
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("�ñ�ҵ�������ڣ�\n");
		}else {
			System.out.println("�ñ�ҵ������ϢΪ��" + temp);
			while(true) {
				System.out.println("�Ƿ�ɾ����(1.ɾ��/0.ȡ��)");
				select = input.next();
				if(select.equals("1")) {
					Graduates.remove(name);
					System.out.println("ɾ���ɹ���\n");
					break;
				}else if(select.equals("0")){
					System.out.println("ɾ����ȡ����\n");
					break;
				}else {
					System.err.println("����ĸ�ʽ����ȷ!\n");
				}
			}
		}
	}
	
	
	/**
	 * �༭��ҵ����Ϣ
	 */
	public static void EditGraInfo() {
		Graduate temp;
		Scanner input = new Scanner(System.in);
		String name,select;
		System.out.print("������Ҫ�༭�ı�ҵ���û���(�磺002)��");
		name = input.next();
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("�ñ�ҵ�������ڣ�\n");
		}else {
			while(true){
				System.out.println("�ñ�ҵ������ϢΪ��" + temp);
				System.out.println("==>��ѡ��Ҫ�༭���û���Ϣ��");
				System.out.print("1.�Ա�  ");
				System.out.print("2.��ϵ��ʽ  ");
				System.out.print("3.ѧ��  ");
				System.out.print("4.��ҵ���  ");
				System.out.print("0.����");
				System.out.println();
				select = input.next();
				if(select.equals("1")) {
					System.out.print("�����Ա�");
					String sex = input.next();
					temp.setSex(sex);
					System.out.println("�޸ĳɹ�!\n");
				}else if(select.equals("2")) {
					while(true) {
						System.out.print("������ϵ��ʽ��");
						String phoneNumber = input.next();
						if(CheckInfo.isPhoneNumber(phoneNumber)) {
							temp.setPhoneNumer(phoneNumber);
							System.out.println("�޸ĳɹ���\n");
							break;
						}else {
							System.out.println("��������Ч���ֻ��ţ�");
						}
					}
				}else if(select.equals("3")) {
					System.out.print("����ѧ�ţ�");
					String id = input.next();
					temp.setId(id);
					System.out.println("�޸ĳɹ�!\n");
				}else if(select.equals("4")) {
					System.out.print("�����ҵ��ݣ�");
					String year = input.next();
					temp.setGraduateYear(year);
					System.out.println("�޸ĳɹ�!\n");
				}else if(select.equals("0")){
					break;
				}else {
					System.err.println("����ĸ�ʽ����ȷ!\n");
				}
			}
		}
	}
	
	
	/**
	 * ��ѯ��ҵ����Ϣ
	 */
	public static void SearchGraInfo() {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("==>��ѡ���ѯ�ķ�ʽ��");
			System.out.print("1.ͨ���û�����ѯ�ñ�ҵ����Ϣ");
			System.out.print("   2.ͨ����ҵ��ݲ�ѯ���б�ҵ����Ϣ");
			System.out.print("   0.����\n");
			select = input.next();
			if(select.equals("1")) {
				/*ͨ���û�����ѯ��ҵ����Ϣ*/
				SearchByName();
			}else if(select.equals("2")){
				/*ͨ����ҵ��ݲ�ѯ��ҵ����Ϣ*/
				SearchByYear();
			}else if(select.equals("0")) {
				/*�˳�*/
				break;
			}else {
				System.err.println("����ĸ�ʽ����ȷ!\n");
			}
		}
	}
	
	
	/**
	 * ��ѯ��ҵ����Ϣ  ==> ͨ���û�����ѯ��ҵ����Ϣ
	 */
	public static void SearchByName() {
		Scanner input = new Scanner(System.in);
		System.out.print("�������ѯ�ı�ҵ�����û���(�磺003)��");
		String name = input.next();
		Graduate temp = Graduates.get(name);
		if(temp != null) {
			System.out.print("��ѯ���ñ�ҵ���Ļ�����Ϣ��");
			System.out.println(temp);
			if(temp.PrintEmployDes() == null) {
				System.out.println("δ��ѯ���ñ�ҵ���ľ�ҵȥ����Ϣ");
			}else {
				System.out.print("��ѯ���ñ�ҵ���ľ�ҵȥ����Ϣ��");
				System.out.println(temp.PrintEmployDes());
			}
			System.out.println();
		}else {
			System.err.println("δ��ѯ���ñ�ҵ����\n");
		}
	}
	
	
	/**
	 * ��ѯ��ҵ����Ϣ  ==> ͨ����ҵ��ݲ�ѯ��ҵ����Ϣ
	 */
	public static void SearchByYear() {
		Scanner input = new Scanner(System.in);
		System.out.print("�������ҵ���(�磺2018)��");
		String year = input.next();
		int count = 0;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		List<String> nameList = new ArrayList<>();
		/*�ҳ����з��ϱ�ҵ��ݵı�ҵ��������name����nameList��*/
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate temp = Graduates.get(name);
			if(temp.getGraduateYear().equals(year)) {
				count++;
				nameList.add(temp.getName());
			}
		}
		if(count == 0) {
			System.out.println("δ��ѯ������ݱ�ҵ�ı�ҵ����\n");
		}else {
			System.out.println("���ҵ�" + count + "��" + year + "���ҵ�ı�ҵ����Ϣ��");
			int t = 1;
			for(String i:nameList) {
				System.out.println(t + "   " + Graduates.get(i));
				t++;
			}
		}
		System.out.println();
	}
	
	/**
	 * ��ҵ����ҵȥ�����ͻ��ܵ�ʵ��
	 * @param select ѡ��鿴������ 1.��ҵ 2.�о��� 3.���� 4.��ҵ 5.δ�Ǽ�
	 */
	public static void EmploySummary(String select) {
		int count = 0;
		String type = FindEmployType(select);
		Set<String> names = Graduates.keySet();
		List<String> nameList = new ArrayList<>();
		Iterator<String> iterator = names.iterator();
		if(select.equals("5")) {
			while(iterator.hasNext()) {
				String name = iterator.next();
				Graduate temp = Graduates.get(name);
				if(temp.getEmployDes() != null) {
					count ++;
					nameList.add(temp.getName());
				}
			}
		}else {
			while(iterator.hasNext()) {
				String name = iterator.next();
				Graduate temp = Graduates.get(name);
				/*temp.getEmployDes()Ϊ��˵����δ�Ǽ�*/
				if(temp.getEmployDes() != null) {
					if(temp.getEmployDes().getOption().equals(select)) {
						count ++;
						nameList.add(temp.getName());
					}
				}
			}
		}
		/*����nameList�еı�ҵ��*/
		if(count == 0) {
			System.out.println("Ŀǰû�о�ҵȥ��Ϊ " + type +" �ı�ҵ����\n");
		}else {
			System.out.println("���� " + count + " ����ҵ���ľ�ҵȥ��   " + type);
			int t = 1;
			for(String i:nameList) {
				System.out.println(t + "   " + Graduates.get(i));
				t++;
			}
		}
	}
	
	
	/**
	 * �����ת���ɾ�ҵȥ������
	 * @param select �������
	 * @return ���ؾ�ҵȥ��
	 */
	public static String FindEmployType(String select) {
		if(select.equals("1")) {
			return "��ҵ";
		}else if(select.equals("2")){
			return "�о���";
		}else if(select.equals("3")){
			return "����";
		}else if(select.equals("4")){
			return "��ҵ";
		}else if(select.equals("5")){
			return "δ�Ǽ�";
		}
		return null;
	}
	
	
	/**
	 * ͳ��ĳһ���ҵ�ı�ҵ����Ů����������ҵȥ������
	 */
	public static void SubTotalByYear(){
		Scanner input = new Scanner(System.in);
		System.out.print("������Ҫ�鿴������Ϣ�����(�磺2018)��");
		String year = input.next();
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		List<String> nameList = new ArrayList<>();
		int dy=0,yjs=0,gz=0,cy=0,wdj=0,boy=0,girl=0,count=0;
		/*�ҳ����з��ϱ�ҵ��ݵı�ҵ��������name����nameList��*/
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate temp = Graduates.get(name);
			if(temp.getGraduateYear().equals(year)) {
				nameList.add(temp.getName());
				count++;
			}
		}
		for(String name:nameList) {
			String t;
			String sex = Graduates.get(name).getSex();
			if(sex.equals("��")) {
				boy++;
			}else {
				girl++;
			}
			if(Graduates.get(name).getEmployDes() == null) {
				wdj++;
			}else {
				t = Graduates.get(name).getEmployDes().getOption();
				switch(t) {
					case "1":
						dy++;
						break;
					case "2":
						yjs++;
						break;
					case "3":
						gz++;
						break;
					case "4":
						cy++;
						break;
				}
			}
		}
		if(count == 0) {
			System.out.println("δ��ѯ�������ҵ�ı�ҵ����Ϣ");
		}else {
			System.out.println("��ҵ���Ϊ " + year + " �ı�ҵ���� " + count + " �ˣ�" +
					"���У�" + "������ " + boy + " �ˣ�" + "Ů���� " + girl + "�ˡ�\n" +
					"��ҵȥ��Ϊ ��ҵ     ���� " + dy + " �ˣ�\n" + 
					"��ҵȥ��Ϊ �о��� ���� " + yjs + " �ˣ�\n" + 
					"��ҵȥ��Ϊ ����     ���� " + gz + " �ˣ�\n" + 
					"��ҵȥ��Ϊ ��ҵ     ���� " + cy + " �ˣ�\n" + 
					"��ҵȥ��Ϊ δ�Ǽ� ���� " + wdj + " �ˡ�\n" );
		}
	}
	
	/**
	 * ͳ�����б�ҵ���Ļ�����Ϣ
	 */
	public static void SubTotal() {
		String t;
		int dy=0,yjs=0,gz=0,cy=0,wdj=0,boy=0,girl=0,count=0;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate graduate = Graduates.get(name);
			if(graduate.getSex().equals("��")) {
				boy++;
			}else {
				girl++;
			}
			if(graduate.getEmployDes() == null) {
				wdj++;
			}else {
				t = graduate.getEmployDes().getOption();
				switch(t) {
					case "1":
						dy++;
						break;
					case "2":
						yjs++;
						break;
					case "3":
						gz++;
						break;
					case "4":
						cy++;
						break;
				}
			}
			count++;
		}
		if(count == 0) {
			System.out.println("���ޱ�ҵ��������Ϣ");
		}else {
			System.out.println("���� " + count + " ����ҵ����" +
					"���У�" + "������ " + boy + " �ˣ�" + "Ů���� " + girl + "�ˡ�\n" +
					"��ҵȥ��Ϊ ��ҵ     ���� " + dy + " �ˣ�\n" + 
					"��ҵȥ��Ϊ �о��� ���� " + yjs + " �ˣ�\n" + 
					"��ҵȥ��Ϊ ����     ���� " + gz + " �ˣ�\n" + 
					"��ҵȥ��Ϊ ��ҵ     ���� " + cy + " �ˣ�\n" + 
					"��ҵȥ��Ϊ δ�Ǽ� ���� " + wdj + " �ˡ�\n" );
		}
	}
}


