package project.util;

/**
 *  ��ʼ������Ա�ͱ�ҵ�����ݵ�AdminList��GraduateList
 */

import java.util.*;
import project.entity.*;

public class InitUser {
	public static HashMap<String,Graduate> GraduateList = new HashMap<String,Graduate>();
	public static HashMap<String,Admin> AdminList = new HashMap<String,Admin>();
	
	/* ��һ������������ִ��AdminInit()��GraduateInit()�����û����ݴ���map�� */
	static {
		AdminInit();
		GraduateInit();
	}
	
	public static void AdminInit() {
		Admin admin1 = new Admin("admin1","123456","13586858090");
		Admin admin2 = new Admin("admin2","123456","19858181243");
		AdminList.put("admin1",admin1);
		AdminList.put("admin2",admin2);
	}
	
	public static void GraduateInit() {
		/*�ѵǼǾ�ҵȥ��ı�ҵ�� */
		EmployDestination Employed1 = new Employed("��Ѷ","ǰ�˹���ʦ");
		EmployDestination PostGraduate1 = new PostGraduate("��ʦ��");
		Graduate Grad1 = new Graduate("001","123456","19878181243","��","2008212212045","2008");
		Grad1.setEmployDes(Employed1);
		Graduate Grad2 = new Graduate("002","123456","15878191243","��","2009212212047","2009");
		Grad2.setEmployDes(PostGraduate1);
		
		/*��δ�ǼǾ�ҵȥ���ҵ�� */
		Graduate Grad3 = new Graduate("003","123456","13878185243","Ů","2012212212087","2012");
		Graduate Grad4 = new Graduate("004","123456","15845181523","��","2018212212095","2018");
		Graduate Grad5 = new Graduate("005","123456","15843232763","Ů","2018212212096","2018");
		GraduateList.put("001",Grad1);
		GraduateList.put("002",Grad2);
		GraduateList.put("003",Grad3);
		GraduateList.put("004",Grad4);
		GraduateList.put("005",Grad5);
	}
}
