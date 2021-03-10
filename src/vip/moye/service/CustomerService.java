package vip.moye.service;

import java.util.Arrays;

import vip.moye.bean.Customer;
import vip.moye.utils.MonoTools;

public class CustomerService {
	private  Customer[] all;
	
	public CustomerService() {
		all = new Customer[5];
	}
	public CustomerService(int initSize){
		all = new Customer[initSize];
	}
	
	public Customer[] getAll() {
		return all;
	}
	public void setAll(Customer[] all) {
		this.all = all;
	}

	private int total;
	public void addCustomer(Customer c){
		if (all.length <= total) {
			System.out.println("存储客户数已满");
			Customer[] newArr = Arrays.copyOf(all, all.length*2);
			all = newArr;
			System.out.println("已自动扩容最大存储客户数！");
			all[total++] = c;
			return;
		}
		//number = total;
		all[total++] = c;
	}
	public  void updateCustomer(int num){
		for (int i = num; i < all.length; i++) {
			
		}
	}
	public void CustomerList() {
		for (int i = 0; i < all.length; i++) {
			if(all[i]!=null){
				int number = i+1;
			System.out.println(number + "    " + all[i].getName() + "       " 
			+ all[i].getGender() + "        " + all[i].getAge()+ "     " 
					+ all[i].getTel() + "\t\t" + all[i].getEmail() );
			}
			
		}
	}
	public void deleteCustomer(int num) {
		num -=1;
		MonoTools.deletElem(all,num);
		total--;
	}
	
}
