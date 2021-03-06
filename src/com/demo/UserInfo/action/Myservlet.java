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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----doGet----");
		response.setContentType("text/html;charset=utf-8");
		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// 解析json数据
		JSONObject json = JsonReader.receivePost(request);
		System.out.println("JSONObject" + json);
		User user = new User();
		user.PassWord = "666";
		user.UserName = "77";
		Writer out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", "user");
		jsonObject.put("message", "用户登录成功！");
		jsonObject.put("success", "true");
		out.write(jsonObject.toString());
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----进来了------");

		// response.setContentType("text/html");
		// 设置字符编码为UTF-8, 这样支持汉字显示
		// response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=utf-8");

		/** 设置响应头允许ajax跨域访问 **/
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");

		Writer out = response.getWriter();

		// 解析json数据
		JSONObject json = JsonReader.receivePost(request);
		System.out.println("JSONObject" + json);

		// 将建json对象转换为java对象
		String name = json.getString("UserName");
		String PassWord = json.getString("PassWord");
		System.out.println("name:" + name + "==PassWord:" + PassWord);
		User loginUser = (User) JSONObject.toBean(json, User.class);
		loginUser.setUserName(name);
		loginUser.setPassWord(PassWord);
		System.out.println("loginUser:" + loginUser);

		JSONObject jsonObject = new JSONObject();
		System.out.println("getUserName:" + loginUser.getUserName());
		if (loginUser.getUserName().equalsIgnoreCase("1") && loginUser.getPassWord().equalsIgnoreCase("1")) {
			// 将java对象转换为json对象
			jsonObject.put("user", JSONObject.fromObject(loginUser));
			jsonObject.put("message", "用户登录成功！");
			jsonObject.put("success", "true");

		} else {
			jsonObject.put("user", JSONObject.fromObject(loginUser));
			jsonObject.put("message", "用户登录失败！");
			jsonObject.put("success", "false");
		}
		out.write(jsonObject.toString());
		out.flush();

	}

	/**
	 * Servlet生命周期分为三个阶段： 1：初始化阶段，调用init()方法 2：响应客户请求阶段，调用service()方法
	 * 3：终止阶段，调用destory()方法
	 */
	@Override
	public void init() throws ServletException {

		super.init();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		super.service(request, response);
	}

	@Override
	public void destroy() {

		super.destroy();
	}
}
