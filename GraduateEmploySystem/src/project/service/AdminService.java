package project.service;

import project.util.InitUser;
import project.entity.*;
import java.util.*;

public class AdminService {
	public static HashMap<String,Admin> Admins = InitUser.AdminList;
	public static HashMap<String,Graduate> Graduates = InitUser.GraduateList;
	
	/**
	 * 管理员登录验证
	 * @param name 输入的用户名
	 * @param password 输入的密码
	 * @return 验证成功返回该管理员Admin信息，否则返回null
	 */
	public static Admin findByNameAndPassword(String name,String password) {
		int check = 0;
		Admin adm = new Admin();
		Admin temp;
		adm.setName(name);
		adm.setPassword(password);
		temp = Admins.get(name);
		if(temp == null) {
			System.err.println("该管理员不存在！\n");
		}else{
			if(temp.getPassword().equals(password)) {
				System.out.println("登录成功！\n");
				check = 1;
			}else {
				System.err.println("密码错误！\n");
			}
		}
		if(check == 1) {
			return temp;
		}else {
			return null;
		}
	}
	
	
	/**
	 * 修改个人信息
	 * @param adm 要修改的管理员
	 * @param select 具体修改的信息是什么，要修改的具体信息是哪一条,1为修改密码，2为修改手机号码
	 */
	public static void ModifyInfo(Admin adm,String select) {
		Admin temp = Admins.get(adm.getName());
		Scanner input = new Scanner(System.in);
		/*修改密码*/
		if(select.equals("1")) {
			System.out.print("请输入新的密码：");
			String newPassword = input.next();
			temp.setPassword(newPassword);
			System.out.println("修改密码成功！\n");
		/*修改联系方式*/
		}else if(select.equals("2")) {
			while(true) {
				System.out.print("请输入新的手机号码：");
				String newPhoneNum = input.next();
				if(CheckInfo.isPhoneNumber(newPhoneNum)) {
					temp.setPhoneNumer(newPhoneNum);
					System.out.println("修改联系方式成功！\n");
					break;
				}else {
					System.out.println("请输入有效的手机号！");
				}
			}
		}
	}
	
	
	/**
	 * 遍历所有毕业生信息
	 */
	public static void ShowAllGraInfo() {
		System.out.println("以下是所有毕业生的信息：");
		int count = 1;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate graduate = Graduates.get(name);
			System.out.println(count + "   基本信息：" + graduate);
			if(graduate.getEmployDes() == null) {
				System.out.println("\t就业去向：还未登记就业去向");
			}else {
				System.out.println("\t就业去向：" + graduate.getEmployDes());
			}
			count++;
		}
		System.out.println("共有 "+ (count-1) + " 条毕业生信息");
		System.out.println();
	}
	
	
	/**
	 * 添加毕业生信息
	 */
	public static void AddGraInfo() {
		Scanner input = new Scanner(System.in);
		String name,password,phoneNumber,id,sex,graduateYear;
		/*初始密码为123456*/
		password = "123456";
		/*用户名*/
		while(true) {
			System.out.print("请输入要添加的毕业生用户名：");
			name = input.next();
			if(CheckInfo.CheckName(name)) {
				break;
			}else {
				System.err.println("该用户名已有毕业生使用！请重新输入！");
			}
		}
		/*联系方式*/
		while(true) {
			System.out.print("请输入要添加的毕业生联系方式：");
			phoneNumber = input.next();
			if(CheckInfo.isPhoneNumber(phoneNumber)) {
				break;
			}else {
				System.out.println("请输入有效的手机号！");
			}
		}
		/*学号*/
		System.out.print("请输入要添加的毕业生学号：");
		id = input.next();
		/*性别*/
		System.out.print("请输入要添加的毕业生性别：");
		sex = input.next();
		/*毕业年份*/
		System.out.print("请输入要添加的毕业生毕业年份：");
		graduateYear = input.next();
		Graduate newgraduate = new Graduate(name,password,phoneNumber,sex,id,graduateYear);
		Graduates.put(name,newgraduate);
		System.out.println("添加毕业生 "+ name + " 成功！登录初始密码为123456 \n");
	}
	
	
	/**
	 * 删除毕业生信息
	 */
	public static void DelGraInfo() {
		Graduate temp;
		Scanner input = new Scanner(System.in);
		String name,select;
		System.out.print("请输入要删除的毕业生的用户名(如：001)：");
		name = input.next();
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("该毕业生不存在！\n");
		}else {
			System.out.println("该毕业生的信息为：" + temp);
			while(true) {
				System.out.println("是否删除？(1.删除/0.取消)");
				select = input.next();
				if(select.equals("1")) {
					Graduates.remove(name);
					System.out.println("删除成功！\n");
					break;
				}else if(select.equals("0")){
					System.out.println("删除已取消！\n");
					break;
				}else {
					System.err.println("输入的格式不正确!\n");
				}
			}
		}
	}
	
	
	/**
	 * 编辑毕业生信息
	 */
	public static void EditGraInfo() {
		Graduate temp;
		Scanner input = new Scanner(System.in);
		String name,select;
		System.out.print("请输入要编辑的毕业生用户名(如：002)：");
		name = input.next();
		temp = Graduates.get(name);
		if(temp == null) {
			System.err.println("该毕业生不存在！\n");
		}else {
			while(true){
				System.out.println("该毕业生的信息为：" + temp);
				System.out.println("==>请选择要编辑的用户信息：");
				System.out.print("1.性别  ");
				System.out.print("2.联系方式  ");
				System.out.print("3.学号  ");
				System.out.print("4.毕业年份  ");
				System.out.print("0.返回");
				System.out.println();
				select = input.next();
				if(select.equals("1")) {
					System.out.print("输入性别：");
					String sex = input.next();
					temp.setSex(sex);
					System.out.println("修改成功!\n");
				}else if(select.equals("2")) {
					while(true) {
						System.out.print("输入联系方式：");
						String phoneNumber = input.next();
						if(CheckInfo.isPhoneNumber(phoneNumber)) {
							temp.setPhoneNumer(phoneNumber);
							System.out.println("修改成功！\n");
							break;
						}else {
							System.out.println("请输入有效的手机号！");
						}
					}
				}else if(select.equals("3")) {
					System.out.print("输入学号：");
					String id = input.next();
					temp.setId(id);
					System.out.println("修改成功!\n");
				}else if(select.equals("4")) {
					System.out.print("输入毕业年份：");
					String year = input.next();
					temp.setGraduateYear(year);
					System.out.println("修改成功!\n");
				}else if(select.equals("0")){
					break;
				}else {
					System.err.println("输入的格式不正确!\n");
				}
			}
		}
	}
	
	
	/**
	 * 查询毕业生信息
	 */
	public static void SearchGraInfo() {
		Scanner input = new Scanner(System.in);
		String select;
		while(true) {
			System.out.println("==>请选择查询的方式：");
			System.out.print("1.通过用户名查询该毕业生信息");
			System.out.print("   2.通过毕业年份查询所有毕业生信息");
			System.out.print("   0.返回\n");
			select = input.next();
			if(select.equals("1")) {
				/*通过用户名查询毕业生信息*/
				SearchByName();
			}else if(select.equals("2")){
				/*通过毕业年份查询毕业生信息*/
				SearchByYear();
			}else if(select.equals("0")) {
				/*退出*/
				break;
			}else {
				System.err.println("输入的格式不正确!\n");
			}
		}
	}
	
	
	/**
	 * 查询毕业生信息  ==> 通过用户名查询毕业生信息
	 */
	public static void SearchByName() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入查询的毕业生的用户名(如：003)：");
		String name = input.next();
		Graduate temp = Graduates.get(name);
		if(temp != null) {
			System.out.print("查询到该毕业生的基本信息：");
			System.out.println(temp);
			if(temp.PrintEmployDes() == null) {
				System.out.println("未查询到该毕业生的就业去向信息");
			}else {
				System.out.print("查询到该毕业生的就业去向信息：");
				System.out.println(temp.PrintEmployDes());
			}
			System.out.println();
		}else {
			System.err.println("未查询到该毕业生！\n");
		}
	}
	
	
	/**
	 * 查询毕业生信息  ==> 通过毕业年份查询毕业生信息
	 */
	public static void SearchByYear() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入毕业年份(如：2018)：");
		String year = input.next();
		int count = 0;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		List<String> nameList = new ArrayList<>();
		/*找出所有符合毕业年份的毕业生，并把name存在nameList中*/
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate temp = Graduates.get(name);
			if(temp.getGraduateYear().equals(year)) {
				count++;
				nameList.add(temp.getName());
			}
		}
		if(count == 0) {
			System.out.println("未查询到该年份毕业的毕业生！\n");
		}else {
			System.out.println("共找到" + count + "条" + year + "年毕业的毕业生信息：");
			int t = 1;
			for(String i:nameList) {
				System.out.println(t + "   " + Graduates.get(i));
				t++;
			}
		}
		System.out.println();
	}
	
	/**
	 * 毕业生就业去向类型汇总的实现
	 * @param select 选择查看的类型 1.待业 2.研究生 3.工作 4.创业 5.未登记
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
				/*temp.getEmployDes()为空说明还未登记*/
				if(temp.getEmployDes() != null) {
					if(temp.getEmployDes().getOption().equals(select)) {
						count ++;
						nameList.add(temp.getName());
					}
				}
			}
		}
		/*遍历nameList中的毕业生*/
		if(count == 0) {
			System.out.println("目前没有就业去向为 " + type +" 的毕业生！\n");
		}else {
			System.out.println("共有 " + count + " 个毕业生的就业去向   " + type);
			int t = 1;
			for(String i:nameList) {
				System.out.println(t + "   " + Graduates.get(i));
				t++;
			}
		}
	}
	
	
	/**
	 * 将序号转换成就业去向类型
	 * @param select 输入序号
	 * @return 返回就业去向
	 */
	public static String FindEmployType(String select) {
		if(select.equals("1")) {
			return "待业";
		}else if(select.equals("2")){
			return "研究生";
		}else if(select.equals("3")){
			return "工作";
		}else if(select.equals("4")){
			return "创业";
		}else if(select.equals("5")){
			return "未登记";
		}
		return null;
	}
	
	
	/**
	 * 统计某一年毕业的毕业生男女人数，各就业去向人数
	 */
	public static void SubTotalByYear(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入要查看汇总信息的年份(如：2018)：");
		String year = input.next();
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		List<String> nameList = new ArrayList<>();
		int dy=0,yjs=0,gz=0,cy=0,wdj=0,boy=0,girl=0,count=0;
		/*找出所有符合毕业年份的毕业生，并把name存在nameList中*/
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
			if(sex.equals("男")) {
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
			System.out.println("未查询到该年毕业的毕业生信息");
		}else {
			System.out.println("毕业年份为 " + year + " 的毕业生共 " + count + " 人，" +
					"其中，" + "男生有 " + boy + " 人，" + "女生有 " + girl + "人。\n" +
					"就业去向为 待业     的有 " + dy + " 人，\n" + 
					"就业去向为 研究生 的有 " + yjs + " 人，\n" + 
					"就业去向为 工作     的有 " + gz + " 人，\n" + 
					"就业去向为 创业     的有 " + cy + " 人，\n" + 
					"就业去向为 未登记 的有 " + wdj + " 人。\n" );
		}
	}
	
	/**
	 * 统计所有毕业生的汇总信息
	 */
	public static void SubTotal() {
		String t;
		int dy=0,yjs=0,gz=0,cy=0,wdj=0,boy=0,girl=0,count=0;
		Set<String> names = Graduates.keySet();
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			Graduate graduate = Graduates.get(name);
			if(graduate.getSex().equals("男")) {
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
			System.out.println("暂无毕业生汇总信息");
		}else {
			System.out.println("共有 " + count + " 名毕业生，" +
					"其中，" + "男生有 " + boy + " 人，" + "女生有 " + girl + "人。\n" +
					"就业去向为 待业     的有 " + dy + " 人，\n" + 
					"就业去向为 研究生 的有 " + yjs + " 人，\n" + 
					"就业去向为 工作     的有 " + gz + " 人，\n" + 
					"就业去向为 创业     的有 " + cy + " 人，\n" + 
					"就业去向为 未登记 的有 " + wdj + " 人。\n" );
		}
	}
}


