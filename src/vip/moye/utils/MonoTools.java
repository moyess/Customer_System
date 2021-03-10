package vip.moye.utils;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vip.moye.bean.Customer;

public class MonoTools {
	public static  void deletElem(Customer [] Arr,int index){
		//从要删除的索引后开始，让后面每个元素向前移动一位
		for (int i=index+1;i<Arr.length;i++){
		Arr[i-1] = Arr[i];
		}
		Arr[Arr.length-1] = null;
//		List<Customer> list = (List) Arrays.asList(Arr);
//		List<Customer> arrayList = new ArrayList<Customer>(list);
//		System.out.println("1");
//		arrayList.remove(0);
	}
	 public static String getType(Object a) {
	        return a.getClass().toString();
	 
	    }
	 public static boolean checkcountname(String countname)
	    {
	         Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	            Matcher m = p.matcher(countname);
	            if (m.find()) {
	                return true;
	            }
	            return false;
	    }

}
