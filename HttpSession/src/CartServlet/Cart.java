package CartServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBUtils;
import Product.Book;
/**
 * ���ﳵ
 * @author wushijia
 *
 */
public class Cart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//�õ�Session����,���ҵõ����ﳵ�嵥
		List<Book> books = (List<Book>) req.getSession().getAttribute("cart");
		PrintWriter out = resp.getWriter();
		out.print("���ﳵ��������Ʒ:<br/>");
		if(books == null){//������ﳵ��û����Ʒ
			out.print("�㻹δ�����κ���Ʒ");
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/Session/cartindex");
//			resp.sendRedirect(req.getContextPath()+"/Session/cartindex");//�ض���
		}else{
			
			for (Book book : books) {//�г����ﳵ�е���
				out.write(book.getName()+"<br/>");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
