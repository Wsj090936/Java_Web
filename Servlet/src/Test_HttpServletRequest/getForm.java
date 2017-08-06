package Test_HttpServletRequest;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 获取表单数据
 * @author wushijia
 *
 */
public class getForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//告诉服务器使用什么编码，HTML文档用的是什么编码，里面的值就传什么编码
		//获取表单数据
		try {
			User u = new User();
			Map<String, String[]> map = req.getParameterMap();
			for(Map.Entry<String, String[]> each : map.entrySet()){
				String name = each.getKey();//获取name
				String[] value = each.getValue();//获取value
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				Method setter = pd.getWriteMethod();//得到setter属性
				if(value.length == 1){
					setter.invoke(u, value[0]);
				}else {
					setter.invoke(u, (Object)value);
				}
			}
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void test1(HttpServletRequest req) {//获取表单数据的方法一
		String username = req.getParameter("username");//用户名
		String pwd = req.getParameter("pwd");//密码
		String sex = req.getParameter("sex");//性别
		String[] hobby = req.getParameterValues("hobby");//爱好
		String city = req.getParameter("city");//所在地
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(sex);
		for (int i = 0;hobby != null && i < hobby.length; i++) {
			System.out.print(hobby[i]+" ");
		}
		System.out.println();
		System.out.println(city);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
