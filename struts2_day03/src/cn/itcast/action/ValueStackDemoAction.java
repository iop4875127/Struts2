package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemoAction extends ActionSupport {

	//1 定义变量
//	private String name;
//	//2 生成变量的get方法
//	public String getName() {
//		return name;
//	}
	
	@Override
	public String execute() throws Exception {
		
		//在执行的方法里面向变量设置值
//		name = "abcdefgh";
		//第一种方式 使用值栈对象里面的 set方法
		//1 获取值栈对象
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
//		//2 调用方法set方法
		stack.set("itcast", "itcastitheima");
//		
//		//3 调用方法push方法
		stack.push("abcd");
		
		return "success";
	}



}
