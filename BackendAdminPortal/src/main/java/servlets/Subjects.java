package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernateClasses.HibernateUtil;
import hibernateClasses.SubjectEntity;

@WebServlet(value = "/Subjects")
public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  final static Logger Logger = LogManager.getLogger(Subjects.class);
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SubjectEntity> subjects;
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Subjects.jsp");
		subjects = (List<SubjectEntity>) HibernateUtil.getAll("SubjectEntity");
		request.setAttribute("subjects", subjects);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Subjects.jsp");
		SubjectEntity subject;
		String formAction = request.getParameter("formAction");
		Logger.trace("form action: " +formAction);
		switch(formAction) {
		case "1": 
			if(!(HibernateUtil.search(SubjectEntity.class, request.getParameter("addSubject")) == null)) {
				request.setAttribute("result", "<SPAN style='color:red'>Unable to add, subject already exists </SPAN>");
			}else {
				subject = new SubjectEntity(request.getParameter("addSubject"));
				if(HibernateUtil.insert(subject))
					request.setAttribute("result", "<SPAN style='color:green'>Successfully added subject </SPAN>");
				else 
					request.setAttribute("result", "<SPAN style='color:red'>Unable to add subject </SPAN>");
			}
			break;
			
		case "2":
			if(HibernateUtil.search(SubjectEntity.class, request.getParameter("addSubject")) == null) {
				request.setAttribute("result", "<SPAN style='color:red'> Unable to delete, subject does not exist </SPAN>");
			}else {
				subject = new SubjectEntity(request.getParameter("deleteSubject"));
				if(HibernateUtil.delete(subject))
					request.setAttribute("result", "<SPAN style='color:green'>Successfully deleted subject </SPAN>");
				else
					request.setAttribute("result", "<SPAN style='color:red'>Unable to delete </SPAN>");
			}
			break;
		}
		
		dis.forward(request, response); 
	}
}
