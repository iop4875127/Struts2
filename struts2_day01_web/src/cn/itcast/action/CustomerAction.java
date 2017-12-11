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
	
	//客户列表
	public String list() {
		//调用service
		CustomerService service = new CustomerService();
		List<Customer> list = service.findAll();
		
		//放到域对象里面（明天讲到）
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "list";
	}


}
