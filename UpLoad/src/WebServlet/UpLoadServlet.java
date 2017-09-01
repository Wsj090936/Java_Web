package WebServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		//ִ���ϴ��ļ��Ĳ���
		//1���жϱ��Ƿ�֧���ϴ��ļ��Ĳ���
		boolean ismultipartContent = ServletFileUpload.isMultipartContent(req);//���֧���ļ��ϴ��Ĳ������ͻ᷵��true
		if(!ismultipartContent){
			throw new RuntimeException("����֧���ļ��ϴ��Ĳ���");
		}
		//���֧�ֵĻ�
//        1������������DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
//        2��ʹ�ù�����������������
		ServletFileUpload fileupload = new ServletFileUpload(factory);
//        3��ʹ�ý�����������request�������е�FileItem�����Ӧһ������������ļ��ֶ�Ҳ��������ͨ�ı��ֶ�
		try {
			List<FileItem> list = fileupload.parseRequest(req);
			//������������
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()){
					//��ͨ����
					processFormField(fileItem);
				}else{
					//�ϴ�����
					processUploadField(fileItem);
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �ļ��ϴ�����
	 * @param fileItem
	 */
	private void processUploadField(FileItem fileItem) {
		//�õ��ļ���
		String filename = fileItem.getName();
		try {
			InputStream is = fileItem.getInputStream();
			//����һ���洢�ļ���Ŀ¼
			String storePath = this.getServletContext().getRealPath("/images");
			File storePlace = new File(storePath);
			if(!storePlace.exists()){//�����Ŀ¼�����ھʹ���һ��
				storePlace.mkdirs();
			}
			//����һ���ļ��������ϴ�������
			File file = new File(storePlace,filename);
			//���ļ�ͨ����������浽����
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len=is.read(b)) != -1){
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ͨ����
	 * @param fileItem
	 */
	private void processFormField(FileItem fileItem) {
		String fieldname = fileItem.getFieldName();//�ֶ���
		String fieldvalue = fileItem.getString();//�ֶ�ֵ
		System.out.println(fieldname+"="+fieldvalue);//des=xxx
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
