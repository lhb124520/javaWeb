package com.demo.UserInfo.action;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.UserInfo.Entity.User;
import com.demo.UserInfo.Util.JsonReader;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BdsServlet
 */
@WebServlet("/BdsServlet")
public class BdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public BdsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");  
  
        /** ������Ӧͷ����ajax������� **/  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
  
        Writer outwriter = response.getWriter(); 
  
        //����json����
        JSONObject json=JsonReader.receivePost(request);  
        System.out.println("JSONObject"+json); 
          
        //����json����ת��Ϊjava����  
        String url = json.getString("url");
//        String url = "http://www.baidu.com";
        String params = json.getString("params");
        System.out.println("Url:"+url+"==params:"+params);
        byte[] result=null;
        try {  
            //post�����get��������ͬ�����ύ������Ϣ�ķ�ʽ��post��ͨ����������Ϣ��װ��http����ͷ�з��ͳ�ȥ��  
            URL url1 = new URL(url);  
              
            //������Ӷ���  
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();  
              
            //��������  
            conn.setRequestMethod("POST");  
            conn.setReadTimeout(5000);  
            conn.setConnectTimeout(5000);  
              
            //�����������������,������Ϊtrue  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
              
            //����http����ͷ(���Բ���:http://tools.jb51.net/table/http_header)  
            conn.setRequestProperty("Accept", "text/plain, text/html, text/json");//ָ���ͻ����ܹ����յ���������  
            conn.setRequestProperty("Connection", "keep-alive"); //http1.1  
              
            //��װҪ�ύ������  
            String name = URLEncoder.encode("����", "UTF-8");  
            String message = "username="+name+"&password=123"; 
            String UserID="";
            ArrayList<String> list=new ArrayList<String>();
            list.add("1");
            list.add("1");
            list.add("HK");
            list.add("android_dbs");
            list.add("869775012153232");
            list.add("http://192.168.8.35:80");
            list.add("BDS");
            list.add("1.62");
            //String list="list:['1','1','HK','android_dbs','869775012153232','http:\/\/192.168.8.35:80','BDS','1.62']";
            String label="User_UserLoginWithCompanyID"; 
            String APIKey="android_dbs";
            String CompanyID="";
            String SessionKey="";
            String liststr=list.toString();
            String data = "UserID="+UserID+"&list="+liststr+"&label="+label+"&APIKey="+APIKey+
            		"&CompanyID="+CompanyID+"&SessionKey="+SessionKey+"";
            System.out.println("data:"+data);
            //���ύ�����������������ʽ�ύ��������  
            OutputStream os = conn.getOutputStream();  
            os.write(data.getBytes());  
              System.out.println("conn.getResponseCode()"+conn.getResponseCode());
            //ͨ����Ӧ�����ж��Ƿ����ӳɹ�  
            if (conn.getResponseCode() == 200) {  
                //��÷��������ص��ֽ���  
                InputStream is = conn.getInputStream();  
                  
                //�ڴ������,�ʺ��������Ƚ�С���ַ��� �� ͼƬ  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                byte[] buf = new byte[1024];  
                int len = 0;  
                while((len = is.read(buf))!=-1){  
                    baos.write(buf, 0, len);  
                }  
                //��ʹ�� toByteArray() �� toString() ��ȡ���ݡ�  
                result = baos.toByteArray();  
                System.out.println(new String(result));  
                is.close();  
                System.out.println("�ͻ���ִ�����!!");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    
        JSONObject jsonObject=new JSONObject() ;  
        jsonObject.put("result", result);
//        System.out.println("getUserName:"+loginUser.getUserName());
//        if(loginUser.getUserName().equalsIgnoreCase("1") && loginUser.getPassWord().equalsIgnoreCase("1")){  
//            //��java����ת��Ϊjson����  
//            jsonObject.put("user", JSONObject.fromObject(loginUser));  
//            jsonObject.put("message", "�û���¼�ɹ���");
//            jsonObject.put("success", "true");
//            
//        }else{  
//        	jsonObject.put("user", JSONObject.fromObject(loginUser));  
//            jsonObject.put("message", "�û���¼ʧ�ܣ�");
//            jsonObject.put("success", "false");
//        }  
        outwriter.write(jsonObject.toString());  
        outwriter.flush();  
	}

}
