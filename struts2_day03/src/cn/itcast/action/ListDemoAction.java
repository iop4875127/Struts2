package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.entity.User;

public class ListDemoAction extends ActionSupport {

	// 1 定义list变量
	private List<User> list = new ArrayList<User>();
	// 2 get方法
	public List<User> getList() {
		return list;
	}
	
	public String execute() throws Exception {
		//3 向list中设置值
		User user1 = new User();
		user1.setUsername("小奥");
		user1.setPassword("123");
		user1.setAddress("美国");
		
		User user2 = new User();
		user2.setUsername("小王");
		user2.setPassword("250");
		user2.setAddress("越南");
		
		list.add(user1);
		list.add(user2);
		
		return "success";
	}

	






}
