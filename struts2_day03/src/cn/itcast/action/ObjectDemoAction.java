package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.entity.User;

public class ObjectDemoAction extends ActionSupport {

	//1 定义对象变量
	private User user = new User();
	//2 生成get方法
	public User getUser() {
		return user;
	}
	
	public String execute() throws Exception {
		//3 向值栈的user里面放数据
		user.setUsername("lucy");
		user.setPassword("123");
		user.setAddress("美国");
		
		return "success";
	}






}
