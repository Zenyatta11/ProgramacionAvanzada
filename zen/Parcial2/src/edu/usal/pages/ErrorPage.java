package edu.usal.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.dominio.ErrorLevel;

public class ErrorPage {
	public ErrorPage(HttpServletRequest request, HttpServletResponse response, ErrorLevel errorLevel) throws ServletException, IOException  {
		request.setAttribute("errorLevel", errorLevel);
		request.getRequestDispatcher("/WEB-INF/resources/pageBegin.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/topSection.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/errorPage.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/footer.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/pageEnd.jsp").include(request, response);
	}
}