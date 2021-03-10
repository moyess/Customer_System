package vip.moye.view;

import vip.moye.bean.Customer;
import vip.moye.service.CustomerService;
import vip.moye.utils.CMUtility;
import vip.moye.utils.MonoTools;

public class CustomerView {
	CustomerService cs = new CustomerService();
	public void menu(){
		while (true) {
			System.out.println("---------------客户信息管理软件-------------");
			System.out.println();
			System.out.println("\t\t1 添加客户");
			System.out.println("\t\t2 修改客户");
			System.out.println("\t\t3 删除客户");
			System.out.println("\t\t4 客户列表");
			System.out.println("\t\t5 退       出");	
			System.out.println();
			System.out.println("\t\t请选择(1-5):");
			char select = CMUtility.readMenuSelection();
			switch (select) {
			case '1':
				add();
				break;
			case '2':
				update();
				break;
			case '3':
				delete();
				break;
			case '4':
				list();				
				break;
			case '5':
				
				System.out.println("\t确定退出吗?(Y/N):");
				char confirm = CMUtility.readConfirmSelection();
				if (confirm == 'Y' || confirm == 'y') {
					return;
				}
				System.out.println("111");
				break;
				

			default:
				break;
			}
			
		}

		
	}

	private void list() {
		System.out.println("-----------------客户列表-----------------");
		System.out.println("编号    姓名       性别        年龄     电话\t\t邮箱");
		//调用service中的打印列表方法
		cs.CustomerList();
		System.out.println("----------------客户列表完成-----------------");
	}

	private void delete() {
		if(cs.getAll()[0] == null){
			System.out.println("没有可删除的客户!");
		}
		System.out.println("-----------------删除客户-----------------");
		System.out.println("请选择待删除客户编号(-1退出):");
		int num = CMUtility.readInt();
		if(num == -1){
			return;
			
		}
		System.out.println("确认是否删除(Y/N):");
		char confirm = CMUtility.readConfirmSelection();
		if(confirm == 'Y'){
			cs.deleteCustomer(num);
			System.out.println("-----------------删除完成-----------------");
		}else{
			System.out.println("取消删除！");
			return;
		}	
		
		
	}

	private void update() {
		if(cs.getAll()[0] == null){
			System.out.println("没有可修改的客户!");
			return;
		}
		System.out.println("-----------------修改客户-----------------");
		System.out.println("请选择待修改客户编号:(-1退出)");
		int num = CMUtility.readInt();
		if(num == -1){
			return;
		}else{
				num -= 1;
				System.out.println("姓名(" + cs.getAll()[num].getName() + "):<直接回车不修改>");
				cs.getAll()[num].setName(CMUtility.readString(20,cs.getAll()[num].getName()));
				System.out.println("性别(" + cs.getAll()[num].getGender() + "):<直接回车不修改>");
				cs.getAll()[num].setGender(CMUtility.readChar(cs.getAll()[num].getGender()));
				System.out.println("年龄(" + cs.getAll()[num].getAge() + "):<直接回车不修改>");
				cs.getAll()[num].setAge(CMUtility.readInt(cs.getAll()[num].getAge()));
				System.out.println("电话(" + cs.getAll()[num].getTel() + "):<直接回车不修改>");
				cs.getAll()[num].setTel(CMUtility.readString(20,cs.getAll()[num].getTel()));
				System.out.println("邮箱(" + cs.getAll()[num].getEmail() + "):<直接回车不修改>");
				cs.getAll()[num].setEmail(CMUtility.readString(20,cs.getAll()[num].getEmail()));
				
			
			return;
		}
			
			
			
		
		
	}

	private void add() {
		System.out.println("-----------------添加客户-----------------");
		System.out.print("姓名:");
		String name = CMUtility.readString(20);
		System.out.print("性别:");
		char gender = CMUtility.readChar('男');
		System.out.print("年龄:");
		int age = CMUtility.readInt();
		System.out.print("电话:");
		String tel = CMUtility.readString(11);
		System.out.print("邮箱:");
		String email = CMUtility.readString(20);
		//创建customer对象 调用customerService的addCustomer方法,并向里面传入一个对象C
		Customer c = new Customer( name,  gender, age, tel, email);
		
		cs.addCustomer(c);
		
		System.out.println("-----------------添加完成-----------------");

	}
}
