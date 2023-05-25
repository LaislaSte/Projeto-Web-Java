package backenddm20231n.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerTeste
 */
@WebServlet("/ControllerTeste")
public class ControllerTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTeste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("RECEBI SOMETHING");
		request.setAttribute("livro", "Livro anabelle");
		RequestDispatcher disp = request.getRequestDispatcher("consulta.jsp");
		response.sendRedirect("consulta.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chasert-UTF-8");
		System.out.println("RECEBI SOMETHING FROM POST");
		RequestDispatcher disp;
		
		String m = (String) request.getParameter("nome");
		if(!m.isEmpty() && m != null) {
			request.setAttribute("mensagem", "CAdastro feito");
			disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);
		}else {
			request.setAttribute("mensagem", "Nada feito - preencha os campos");
			disp = request.getRequestDispatcher("consulta.jsp");
			disp.forward(request, response);
		}
		
		
	}

}
