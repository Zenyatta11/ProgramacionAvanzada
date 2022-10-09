package edu.usal.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexPage {
	public IndexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getRequestDispatcher("/WEB-INF/resources/pageBegin.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/topSection.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/contentSection.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/footer.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/resources/pageEnd.jsp").include(request, response);
	}
}
