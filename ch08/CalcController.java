package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("op");
		
		long result = 0;
		
		switch(request.getParameter("op")) {
		case "+": result = n1+n2; break;
		case "-": result = n1-n2; break;
		case "/": result = n1/n2; break;
		case "*": result = n1*n2; break;
		}
		
		request.setAttribute("result", result); 
		getServletContext().getRequestDispatcher("/ch08/calcResult.jsp")
			.forward(request, response);
	//계산 결과를 'result'라는 이름으로 request scope에 저장하고 결과를 보여주는 calcResult.jsp 페이지로 포워딩 한다.
}

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
