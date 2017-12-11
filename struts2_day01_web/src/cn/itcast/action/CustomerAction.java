package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	//使用模型驱动获取表单数据
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	//登录的方法
	public String login() {
		//1 得到request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2 作业：查询数据库判断用户名和密码是否正确
		// 用户名 admin  密码 250
		if("admin".equals(username) && "250".equals(password)) {
			//成功
			//向session里面放值
			request.getSession().setAttribute("username", username);
			return "loginsuccess";
			
		} else {
			//失败
			return "login";
		}
	}
	
	// 添加的方法
	public String addCustomer() {
		//调用service的方法添加到数据库
		CustomerService service = new CustomerService();
		service.addCustomer(customer);
		
		return "addCustomer";
	}
	
	// 到添加页面
	public String toAddPage() {
		return "toAddPage";
	}
	
	//1 定义list变量,get方法
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}

	//客户列表
	public String list() {
		//调用service
		CustomerService service = new CustomerService();
		//返回数据放到值栈的list里面
		list = service.findAll();
		
		//放到域对象里面（明天讲到）
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("list", list);
		
		return "list";
	}


}
