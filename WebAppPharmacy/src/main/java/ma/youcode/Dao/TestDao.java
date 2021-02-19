package ma.youcode.Dao;

import java.util.Iterator;
import java.util.List;

import ma.youcode.model.Article;

public class TestDao {

	public static void main(String[] args) {
		//test pour ajouter un article
       ArticleDaoImpl dao = new ArticleDaoImpl();
       Article p1= dao.save(new Article("oao", 200, "fievre", 15));
       Article p2= dao.save(new Article("oooo", 200, "vitabiotic", 15)); 
       Article p3= dao.save(new Article("sss", 200, "vitabiotic", 15)); 

       
       System.out.println(p1.toString());
       System.out.println(p2.toString());
       
       
       //test pour chercher un article
	   System.out.println("search for articles");

       List<Article> prods = dao.articleParMC("%d%");
       for(Article p:prods) {
    	   System.out.println(p.toString());
       }

	}

}
