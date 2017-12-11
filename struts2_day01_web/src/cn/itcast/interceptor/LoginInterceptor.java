package cn.itcast.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 拦截器类
 * @author asus
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	//这个方法里面写拦截器逻辑
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 判断session里面是否有名称是username的值
		// 得到session
		HttpServletRequest request = ServletActionContext.getRequest();
		Object obj = request.getSession().getAttribute("username");
		//判断
		if(obj != null) {
			//登录状态
			//做类似于放行操作，执行action的方法
			return invocation.invoke();
		} else {
			//不是登录状态
			//不到登录，不执行action的方法，返回登录页面
			//到result标签里面找到名称是login的值，到配置路径里面
			return "login";
		}
	}

}
