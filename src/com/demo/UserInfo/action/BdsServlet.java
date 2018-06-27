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
  
        /** 设置响应头允许ajax跨域访问 **/  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
  
        Writer outwriter = response.getWriter(); 
  
        //解析json数据
        JSONObject json=JsonReader.receivePost(request);  
        System.out.println("JSONObject"+json); 
          
        //将建json对象转换为java对象  
        String url = json.getString("url");
//        String url = "http://www.baidu.com";
        String params = json.getString("params");
        System.out.println("Url:"+url+"==params:"+params);
        byte[] result=null;
        try {  
            //post请求和get请求的最大不同就是提交请求信息的方式，post是通过把请求信息封装在http请求头中发送出去的  
            URL url1 = new URL(url);  
              
            //获得连接对象  
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();  
              
            //设置属性  
            conn.setRequestMethod("POST");  
            conn.setReadTimeout(5000);  
            conn.setConnectTimeout(5000);  
              
            //设置输入流和输出流,都设置为true  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
              
            //设置http请求头(可以参照:http://tools.jb51.net/table/http_header)  
            conn.setRequestProperty("Accept", "text/plain, text/html, text/json");//指定客户端能够接收的内容类型  
            conn.setRequestProperty("Connection", "keep-alive"); //http1.1  
              
            //封装要提交的数据  
            String name = URLEncoder.encode("张三", "UTF-8");  
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
            //把提交的数据以输出流的形式提交到服务器  
            OutputStream os = conn.getOutputStream();  
            os.write(data.getBytes());  
              System.out.println("conn.getResponseCode()"+conn.getResponseCode());
            //通过响应码来判断是否连接成功  
            if (conn.getResponseCode() == 200) {  
                //获得服务器返回的字节流  
                InputStream is = conn.getInputStream();  
                  
                //内存输出流,适合数据量比较小的字符串 和 图片  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                byte[] buf = new byte[1024];  
                int len = 0;  
                while((len = is.read(buf))!=-1){  
                    baos.write(buf, 0, len);  
                }  
                //可使用 toByteArray() 和 toString() 获取数据。  
                result = baos.toByteArray();  
                System.out.println(new String(result));  
                is.close();  
                System.out.println("客户端执行完毕!!");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    
        JSONObject jsonObject=new JSONObject() ;  
        jsonObject.put("result", result);
//        System.out.println("getUserName:"+loginUser.getUserName());
//        if(loginUser.getUserName().equalsIgnoreCase("1") && loginUser.getPassWord().equalsIgnoreCase("1")){  
//            //将java对象转换为json对象  
//            jsonObject.put("user", JSONObject.fromObject(loginUser));  
//            jsonObject.put("message", "用户登录成功！");
//            jsonObject.put("success", "true");
//            
//        }else{  
//        	jsonObject.put("user", JSONObject.fromObject(loginUser));  
//            jsonObject.put("message", "用户登录失败！");
//            jsonObject.put("success", "false");
//        }  
        outwriter.write(jsonObject.toString());  
        outwriter.flush();  
	}

}
