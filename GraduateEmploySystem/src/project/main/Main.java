package project.main;

import java.util.InputMismatchException;

import project.ui.*;

/**
 * 整个程序的入口
 * @author 24517
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			/**
			 * 欢迎页面
			 */
			MainUI.Welcome();
			
			/**
			 * 登录页面
			 */
			MainUI.Login();
		} catch (InputMismatchException e) {
			System.err.println("您输入了非法字符！sorry！程序已经退出！！");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
