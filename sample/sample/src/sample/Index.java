package sample;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import sample.test.Sources;

public class Index extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		pw.println(Sources.getMessage() + ' ' + name);
	}
}

