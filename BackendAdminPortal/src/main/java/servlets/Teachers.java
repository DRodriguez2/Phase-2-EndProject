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
import hibernateClasses.TeacherEntity;

@WebServlet(value = "/Teachers")
public class Teachers extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private  final static Logger Logger = LogManager.getLogger(Teachers.class);
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TeacherEntity> teachers;
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Teachers.jsp");
		teachers = (List<TeacherEntity>) HibernateUtil.getAll("TeacherEntity");
		request.setAttribute("teachers", teachers);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("jsp/Teachers.jsp");
		TeacherEntity teacher;
		int id;
		String fName,  lName;
		String formAction = request.getParameter("formAction");
		Logger.trace("form action: " +formAction);
		switch(formAction) {
		case "1": 
			
			id = Integer.parseInt(request.getParameter("addTeacherID"));
			fName = request.getParameter("addFirstName");
			lName = request.getParameter("addLastName");
			teacher = new TeacherEntity(id, fName, lName);
			
			if(!(HibernateUtil.search(teacher.getClass(), teacher.getTeacherID()) == null)) {
				request.setAttribute("result", "<SPAN style='color:red'>Unable to add, teacher already exists </SPAN>");
			}else {
				if(HibernateUtil.insert(teacher))
					request.setAttribute("result", "<SPAN style='color:green'>Successfully added teacher </SPAN>");
				else 
					request.setAttribute("result", "<SPAN style='color:red'>Unable to add teacher </SPAN>");
			}
			break;
			
		case "2":
			id = Integer.parseInt(request.getParameter("deleteTeacher"));
			if(HibernateUtil.search(TeacherEntity.class, id) == null) {
				request.setAttribute("result", "<SPAN style='color:red'> Unable to delete, teacher does not exist </SPAN>");
			}else {
				teacher = (TeacherEntity) HibernateUtil.search(TeacherEntity.class, id);
				if(HibernateUtil.delete(teacher))
					request.setAttribute("result", "<SPAN style='color:green'>Successfully deleted teacher </SPAN>");
				else
					request.setAttribute("result", "<SPAN style='color:red'>Unable to teacher </SPAN>");
			}
			break;
		}
		
		dis.forward(request, response); 
	}

}
