package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import hibernateClasses.HibernateUtil;
import hibernateClasses.SubjectEntity;
@WebServlet(value = "/Subjects")
public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Subjects.jsp");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String formAction = request.getParameter("formAction");
		
		switch(formAction) {
		case "1": 
			SubjectEntity subject = new SubjectEntity(request.getParameter("addSubject"));
			if(HibernateUtil.checkExists(subject.getClass(), subject.getSubject(), session)) {
				request.setAttribute("result", "Unable to add, subject already exists");
			}else {
				if(HibernateUtil.insert(subject, session))
					request.setAttribute("result", "Successfully added subject");
				else 
					request.setAttribute("result", "Unable to add subject");
			}
			break;
		case"2":
			break;

		}
		session.close();
		dis.forward(request, response); 
	}
}
