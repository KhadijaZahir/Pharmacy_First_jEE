package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conx.ConnectionDB;

public class Operation {
	private ArrayList<Article> articles = new ArrayList<Article>();

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	// ajouter
	public void add(Article p) {
		Connection connection = null;
		try {
			connection = ConnectionDB.connect();
			PreparedStatement pr = connection
					.prepareStatement("INSERT INTO article (nom, quantite, type, prix) VALUES(?,?,?,?)");
			// String query = "INSERT INTO article(id, nom, quantite, type, prix)"+
			// "OVERRIDING SYSTEM VALUE" +
			// "values(?,?,?,?,?)" ;
			// PreparedStatement pr = cn.prepareStatement(query);

			// String query = "INSERT INTO article VALUE(NULL, ?,?,?,?)";
			// PreparedStatement pr = ConnectionDB.getConnection().prepareStatement(query);
			/*
			 * pr.setInt(1, p.getId()); pr.setString(2,p.getNom()); pr.setInt(3,
			 * p.getQuantite()); pr.setString(4,p.getType()); pr.setInt(5, p.getPrix());
			 */
			pr.setString(1, p.getNom());
			pr.setInt(2, p.getQuantite());
			pr.setString(3, p.getType());
			pr.setInt(4, p.getPrix());
			pr.execute();
			getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// articles.add(p);
	}

	// update
	/*
	 public void modifier(Article ar) {
	
		Connection connection = null;

		try {
			connection = ConnectionDB.connect();
			// PreparedStatement pr = connection.prepareStatement("UPDATE SET `nom`= ?,
			// `quantite`= ?, `type`= ?, `prix`= ? WHERE id= ?");
			PreparedStatement pr = connection.prepareStatement(
					"UPDATE public.article SET nom=?, quantite=?, type=?, prix=? WHERE id = ?;");
	
			
			 pr.setString(1, ar.getNom());
			 pr.setInt (2, ar.getQuantite());
			 pr.setString(3, ar.getType());
			 pr.setInt (4, ar.getPrix());
			 pr.setInt (5,ar.getId());
			 
			pr.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */
	// supp
	public void remove(int id) {
		Connection connection = null;

		try {
			connection = ConnectionDB.connect();
			PreparedStatement pr = connection.prepareStatement("DELETE FROM article WHERE id= ?");
			pr.setInt(1, id);
			pr.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * for(Article p:articles) { if(p.getId()== id) { articles.remove(p); break; } }
		 */
	}

	// afficher
	public ArrayList getAll() {
		Connection connection = null;
		ArrayList listArticle = new ArrayList<Article>();
		try {
			connection = ConnectionDB.connect();
			PreparedStatement pr = connection.prepareStatement("SELECT * FROM article");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Article p = new Article();
				p.setId(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setQuantite(rs.getInt("quantite"));
				p.setType(rs.getString("type"));
				p.setPrix(rs.getInt("prix"));
				listArticle.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listArticle;
	}

}
