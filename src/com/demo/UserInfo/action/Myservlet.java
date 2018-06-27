package com.demo.UserInfo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.UserInfo.Entity.User;
import com.demo.UserInfo.Util.JsonReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet.do")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public Myservlet() {
        super();        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("----doGet----");
		 response.setContentType("text/html;charset=utf-8");
	        /** ������Ӧͷ����ajax������� **/  
	        response.setHeader("Access-Control-Allow-Origin", "*");  
	        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
	        response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
		//����json����
        JSONObject json=JsonReader.receivePost(request);  
        System.out.println("JSONObject"+json); 
		User user = new User();
		user.PassWord="666";
		user.UserName="77";
		   Writer out = response.getWriter(); 
		 JSONObject jsonObject=new JSONObject() ;  
		 jsonObject.put("user", "user");  
         jsonObject.put("message", "�û���¼�ɹ���");
         jsonObject.put("success", "true");
         out.write(jsonObject.toString());  
         out.flush(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----������------");
		
		// response.setContentType("text/html");  
        // �����ַ�����ΪUTF-8, ����֧�ֺ�����ʾ  
        // response.setCharacterEncoding("UTF-8");  
  
        response.setContentType("text/html;charset=utf-8");  
  
        /** ������Ӧͷ����ajax������� **/  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
  
        Writer out = response.getWriter(); 
  
        //����json����
        JSONObject json=JsonReader.receivePost(request);  
        System.out.println("JSONObject"+json); 
          
        //����json����ת��Ϊjava����  
        String name = json.getString("UserName");
        String PassWord = json.getString("PassWord");
        System.out.println("name:"+name+"==PassWord:"+PassWord);
        User loginUser = (User)JSONObject.toBean(json,User.class);
        loginUser.setUserName(name);
        loginUser.setPassWord(PassWord);
        System.out.println("loginUser:"+loginUser);
    
        JSONObject jsonObject=new JSONObject() ;  
        System.out.println("getUserName:"+loginUser.getUserName());
        if(loginUser.getUserName().equalsIgnoreCase("1") && loginUser.getPassWord().equalsIgnoreCase("1")){  
            //��java����ת��Ϊjson����  
            jsonObject.put("user", JSONObject.fromObject(loginUser));  
            jsonObject.put("message", "�û���¼�ɹ���");
            jsonObject.put("success", "true");
            
        }else{  
        	jsonObject.put("user", JSONObject.fromObject(loginUser));  
            jsonObject.put("message", "�û���¼ʧ�ܣ�");
            jsonObject.put("success", "false");
        }  
        out.write(jsonObject.toString());  
        out.flush();  
                      
	}

}
