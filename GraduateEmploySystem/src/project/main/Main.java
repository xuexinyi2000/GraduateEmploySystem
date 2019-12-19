package project.main;

import java.util.InputMismatchException;

import project.ui.*;

/**
 * ������������
 * @author 24517
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			/**
			 * ��ӭҳ��
			 */
			MainUI.Welcome();
			
			/**
			 * ��¼ҳ��
			 */
			MainUI.Login();
		} catch (InputMismatchException e) {
			System.err.println("�������˷Ƿ��ַ���sorry�������Ѿ��˳�����");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
