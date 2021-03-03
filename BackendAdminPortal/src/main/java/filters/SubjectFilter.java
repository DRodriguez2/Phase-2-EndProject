package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebFilter(urlPatterns = { "/Subjects" })
public class SubjectFilter implements Filter {
	private  final static Logger Logger = LogManager.getLogger(SubjectFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Logger.trace("form action: " + request.getParameter("formAction"));
		switch(request.getParameter("formAction")) {
		case "1" : 
			if (request.getParameter("addSubject") == null || request.getParameter("addSubject").isEmpty()) {
				request.setAttribute("result", "<SPAN style='color:red'>Subject cannot be empty </SPAN>");
				request.getRequestDispatcher("jsp/Subjects.jsp").forward(request, response);
				return;
			}
			break;
		case "2" :
			if (request.getParameter("deleteSubject") == null || request.getParameter("deleteSubject").isEmpty()) {
				request.setAttribute("result", "<SPAN style='color:red'>Subject cannot be empty </SPAN>");
				request.getRequestDispatcher("jsp/Subjects.jsp").forward(request, response);
				return;
			}
			break;
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
