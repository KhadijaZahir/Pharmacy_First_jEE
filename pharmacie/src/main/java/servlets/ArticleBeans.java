package servlets;

import java.util.ArrayList;
import java.util.Vector;

import metier.Article;

public class ArticleBeans {
     private Article articles = new Article();
     private ArrayList<Article> liste = new ArrayList<Article>();
     
     
	public Article getArticles() {
		return articles;
	}
	public void setArticles(Article articles) {
		this.articles = articles;
	}
	public ArrayList<Article> getListe() {
		return liste;
	}
	public void setListe(ArrayList arrayList) {
		this.liste = arrayList;
	}
     
     
     
    		 
    		 
}
