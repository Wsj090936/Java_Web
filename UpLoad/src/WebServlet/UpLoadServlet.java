package WebServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*		String des = req.getParameter("des");
		String photo = req.getParameter("photo");
		System.out.println(des);
		System.out.println(photo);*/
		//执行上传文件的操作
		//1、判断表单是否支持上传文件的操作
		boolean ismultipartContent = ServletFileUpload.isMultipartContent(req);//如果支持文件上传的操作，就会返回true
		if(!ismultipartContent){
			throw new RuntimeException("表单不支持文件上传的操作");
		}
		//如果支持的话
//        1、创建工厂类DiskFileItemFactory对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
//        2、使用工厂创建解析器对象：
		ServletFileUpload fileupload = new ServletFileUpload(factory);
//        3、使用解析器来解析request对象：其中的FileItem对象对应一个表单项，可以是文件字段也可以是普通文本字段
		try {
			List<FileItem> list = fileupload.parseRequest(req);
			//遍历表单项数据
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()){
					//普通表单项
					processFormField(fileItem);
				}else{
					//上传表单项
					processUploadField(fileItem);
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processUploadField(FileItem fileItem) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 普通表单项
	 * @param fileItem
	 */
	private void processFormField(FileItem fileItem) {
		String fieldname = fileItem.getFieldName();//字段名
		String fieldvalue = fileItem.getString();//字段值
		System.out.println(fieldname+"="+fieldvalue);//des=xxx
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
