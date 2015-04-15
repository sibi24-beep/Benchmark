package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19443")
public class BenchmarkTest19443 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map95920 = new java.util.HashMap<String,Object>();
		map95920.put("keyA-95920", "a_Value"); // put some stuff in the collection
		map95920.put("keyB-95920", param.toString()); // put it in a collection
		map95920.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map95920.get("keyB-95920"); // get it back out
		bar = (String)map95920.get("keyA-95920"); // get safe value back out
	
		return bar;	
	}
}