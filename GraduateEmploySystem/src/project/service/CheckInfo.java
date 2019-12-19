package project.service;

import project.util.*;
import project.entity.*;
import java.util.*;
import java.util.regex.Pattern;

public class CheckInfo {
	static InitUser init;
	/**
	 * ��һ�η��ʸ���ʱ���ͽ��û����ݳ�ʼ��
	 */
	static {
		init = new InitUser();
	}
	public static HashMap<String,Graduate> Graduates = InitUser.GraduateList;
	
	/**
	 * У������ı�ҵ���û����Ƿ����ظ�
	 * @param name
	 * @return ����Ѿ����ڣ�����false,���򷵻�true
	 */
	public static boolean CheckName(String name) {
		if(Graduates.get(name) == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPhoneNumber(String phoneNumber) {
		String regex = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
		Pattern p = Pattern.compile(regex);
		return p.matches(regex, phoneNumber);
	}
	
	public static boolean IsYear(String year) {
		int y = Integer.parseInt(year);
		if(y >= 1900 || y <= 2200) {
			return true;
		}else {
			return false;
		}
	}
}
