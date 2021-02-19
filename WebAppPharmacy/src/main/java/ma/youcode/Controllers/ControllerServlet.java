package ma.youcode.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.youcode.Dao.ArticleDaoImpl;
import ma.youcode.Dao.IArticleDao;
import ma.youcode.model.Article;

//instead of anottation in web.xml
//@WebServlet(name = "cs", urlPatterns = { "*.php" }) //pour deployer une servlet

public class ControllerServlet extends HttpServlet {
	private IArticleDao metier;

	@Override
	public void init() throws ServletException {
		// instancier la couche metier
		metier = new ArticleDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if (path.equals("/index.php")) {
			req.getRequestDispatcher("articles.jsp").forward(req, resp);

		} else if (path.equals("/chercher.php")) {
			// lire le mot cle
			String motCle = req.getParameter("motCle");
			// appler couche metier pour recupere list des articles
			ArticleModel model = new ArticleModel();
			// stocker le mocle dans le model
			model.setMotCle(motCle);
			List<Article> articles = metier.articleParMC("%" + motCle + "%");
			// stocker le list article dans le model
			model.setArticles(articles);
			// stocker le model dans obj request
			req.setAttribute("model", model);
			req.getRequestDispatcher("articles.jsp").forward(req, resp);

		} else if (path.equals("/ajouter.php")) {
			req.setAttribute("article", new Article()); // default value in input
			req.getRequestDispatcher("AjouterArticles.jsp").forward(req, resp);

		} else if (path.equals("/SaveArticle.php") && (req.getMethod().equals("POST"))) {
			// lire le parametre url

			String nm = req.getParameter("nom");
			int qtt = Integer.parseInt(req.getParameter("quantite"));
			String typ = req.getParameter("type");
			int prx = Integer.parseInt(req.getParameter("prix"));
			Article p = metier.save(new Article(nm, qtt, typ, prx));
			req.setAttribute("article", p);
			req.getRequestDispatcher("confirmation.jsp").forward(req, resp);

		} else if (path.equals("/supprimer.php")) {
			int id = Integer.parseInt(req.getParameter("id"));
			metier.deleteArticle(id);
			// req.getRequestDispatcher("articles.jsp").forward(req, resp);
			resp.sendRedirect("chercher.php?motCle=");
		} else if (path.equals("/edit.php")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Article p = metier.getArticle(id);
			req.setAttribute("article", p);
			req.getRequestDispatcher("EditArticle.jsp").forward(req, resp);
		} else if (path.equals("/UpdateArticle.php") && (req.getMethod().equals("POST"))) {
			int id = Integer.parseInt(req.getParameter("id"));
			String nm = req.getParameter("nom");
			int qtt = Integer.parseInt(req.getParameter("quantite"));
			String typ = req.getParameter("type");
			int prx = Integer.parseInt(req.getParameter("prix"));

			Article p = new Article(nm, qtt, typ, prx);
			p.setId(id);
			metier.update(p);
			req.setAttribute("article", p);
			req.getRequestDispatcher("confirmation.jsp").forward(req, resp);

		} else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
