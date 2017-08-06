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
 * ��ȡ������
 * @author wushijia
 *
 */
public class getForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//���߷�����ʹ��ʲô���룬HTML�ĵ��õ���ʲô���룬�����ֵ�ʹ�ʲô����
		//��ȡ������
		try {
			User u = new User();
			Map<String, String[]> map = req.getParameterMap();
			for(Map.Entry<String, String[]> each : map.entrySet()){
				String name = each.getKey();//��ȡname
				String[] value = each.getValue();//��ȡvalue
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				Method setter = pd.getWriteMethod();//�õ�setter����
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
	private void test1(HttpServletRequest req) {//��ȡ�����ݵķ���һ
		String username = req.getParameter("username");//�û���
		String pwd = req.getParameter("pwd");//����
		String sex = req.getParameter("sex");//�Ա�
		String[] hobby = req.getParameterValues("hobby");//����
		String city = req.getParameter("city");//���ڵ�
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
