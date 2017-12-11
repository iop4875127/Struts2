package cn.itcast.valuestack;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.entity.User;

public class ValueStackAction extends ActionSupport {

//	private String username;
//	public String getUsername() {
//		return username;
//	}
	
//	private User user = new User();
//	public User getUser() {
//		return user;
//	}
	
	private List<User> list = new ArrayList<User>();
	public List<User> getList() {
		return list;
	}

	public String execute() throws Exception {
//		username = "itcast";
		
//		user.setUsername("mary");
//		user.setPassword("250");
//		user.setAddress("china");
		
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
