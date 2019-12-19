package project.util;

/**
 *  初始化管理员和毕业生数据到AdminList，GraduateList
 */

import java.util.*;
import project.entity.*;

public class InitUser {
	public static HashMap<String,Graduate> GraduateList = new HashMap<String,Graduate>();
	public static HashMap<String,Admin> AdminList = new HashMap<String,Admin>();
	
	/* 第一次遇到这个类就执行AdminInit()，GraduateInit()，将用户数据存入map中 */
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
		/*已登记就业去向的毕业生 */
		EmployDestination Employed1 = new Employed("腾讯","前端工程师");
		EmployDestination PostGraduate1 = new PostGraduate("杭师大");
		Graduate Grad1 = new Graduate("001","123456","19878181243","男","2008212212045","2008");
		Grad1.setEmployDes(Employed1);
		Graduate Grad2 = new Graduate("002","123456","15878191243","男","2009212212047","2009");
		Grad2.setEmployDes(PostGraduate1);
		
		/*还未登记就业去向毕业生 */
		Graduate Grad3 = new Graduate("003","123456","13878185243","女","2012212212087","2012");
		Graduate Grad4 = new Graduate("004","123456","15845181523","男","2018212212095","2018");
		Graduate Grad5 = new Graduate("005","123456","15843232763","女","2018212212096","2018");
		GraduateList.put("001",Grad1);
		GraduateList.put("002",Grad2);
		GraduateList.put("003",Grad3);
		GraduateList.put("004",Grad4);
		GraduateList.put("005",Grad5);
	}
}
