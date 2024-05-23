package ch09;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/studentControl") //서블릿 생성
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	StudentDAO dao;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new StudentDAO();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list")
			.forward(request, response);
		} else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "insert": view = insert(request, response); break;
			
			}
			getServletContext().getRequestDispatcher("/ch09/"+view)
			.forward(request, response);
		}
	}

	//list, intsert 2개의 action 요청을 구현
	public String list(HttpServletRequest request, HttpServletResponse response) 
	{
		request.setAttribute("students", dao.getAll()); // 호출 결과 request scope object 속성에 'student'라는 이름으로 저장하고 뷰의 이름을 리턴
		return "studentInfo.jsp";
		
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) 
	{
		Student s = new Student();
		try {
			BeanUtils.populate(s, request.getParameterMap()); // BeanUtios 라이브러리 의존성 추가
			// 모든 입력값을 읽어와 Student 객체로 매핑한 다음
		} catch (Exception e) {e.printStackTrace();}
		dao.insert(s); // 메서드를 호출
		return list(request, response);
	}

}
