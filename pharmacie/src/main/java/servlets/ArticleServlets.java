package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Article;
import metier.Operation;

/**
 * Servlet implementation class ArticleServlets
 */
public class ArticleServlets extends HttpServlet {
	/*
	 * private c op;
	 * 
	 * @Override public void init() throws ServletException { op = new Operation();
	 * }
	 */
	/*
	 * public ArticleServlets() { super(); }
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * //response.getWriter().append("Served at:").append(request.getContextPath());
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Operation op = new Operation();

		// doGet(request, response);
		if (request.getParameter("action") != null) {
			op.remove(Integer.parseInt(request.getParameter("id")));

		} /*else if (request.getParameter("modifier") != null) {
			op.modifier(Integer.parseInt(request.getParameter("id")), request.getParameter("nom"),Integer.parseInt(request.getParameter("quantite")), request.getParameter("type"),Integer.parseInt(request.getParameter("prix")));
			System.out.println("modifier done");
			

		}*/ else {
			// recupere les info
			// int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			String type = request.getParameter("type");
			int prix = Integer.parseInt(request.getParameter("prix"));
			// creation des objects

			// traitement
			// op.add(new Article(1L, nom, Integer.parseInt(quantite), type,
			// Integer.parseInt(prix)));
			op.add(new Article(nom, quantite, type, prix));
			// op.add(new Article(request.getParameter("nom"),
			// Integer.parseInt(request.getParameter("quantite")),
			// request.getParameter("type"),
			// Integer.parseInt(request.getParameter("prix"))));

			// afficher info
//		PrintWriter pr = response.getWriter();
//		pr.println("<html><head><title>web app getsion phamacie</title></head><body>");
//		pr.println(id + " " + nom + " " + quantite + " " + type + " " + prix);
//		pr.println("</body></html>");
		}
		ArticleBeans pb = new ArticleBeans();

		pb.setListe(op.getAll());
		request.setAttribute("modele", pb);
		request.getRequestDispatcher("article.jsp").forward(request, response);
		;
	}

}
