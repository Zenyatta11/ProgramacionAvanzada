package sample;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Docs extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("This is the Docs page!!");
	}
}

