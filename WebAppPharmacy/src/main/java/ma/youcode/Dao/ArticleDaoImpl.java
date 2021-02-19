package ma.youcode.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.youcode.ConnectionDB.SingletonConnection;
import ma.youcode.model.Article;

public class ArticleDaoImpl implements IArticleDao {

	public Article save(Article p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO ARTICLE(nom, quantite, type, prix) VALUES (?,?,?,?)");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setString(3, p.getType());
			ps.setInt(4, p.getPrix());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM ARTICLE");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;

	}

	public List<Article> articleParMC(String mc) {
		List<Article> articles = new ArrayList<Article>();
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ARTICLE WHERE NOM LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Article p = new Article();
				p.setId(rs.getInt("ID"));
				p.setNom(rs.getString("NOM"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setType(rs.getString("TYPE"));
				p.setPrix(rs.getInt("PRIX"));
				articles.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articles;
	}

	public Article getArticle(int id) {
		Article p = null;
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ARTICLE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Article();
				p.setId(rs.getInt("ID"));
				p.setNom(rs.getString("NOM"));
				p.setQuantite(rs.getInt("QUANTITE"));
				p.setType(rs.getString("TYPE"));
				p.setPrix(rs.getInt("PRIX"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	public Article update(Article p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE ARTICLE SET NOM=?,QUANTITE=?, TYPE=?, PRIX=? WHERE ID=?");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setString(3, p.getType());
			ps.setInt(4, p.getPrix());
			ps.setInt(5, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}

	public void deleteArticle(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM ARTICLE WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
