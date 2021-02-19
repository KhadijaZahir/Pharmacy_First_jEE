package ma.youcode.Dao;

import java.util.List;

import ma.youcode.model.Article;
import ma.youcode.model.*;
public interface IArticleDao {
	public Article save(Article p);
	public List<Article> articleParMC(String mc);//chercher article
	public Article getArticle(int id); //consulter article
	public Article update(Article p);
	public void deleteArticle(int id);

}
