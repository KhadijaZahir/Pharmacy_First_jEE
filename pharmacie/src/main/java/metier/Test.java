package metier;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
        Operation op = new Operation();
        Article p = new Article();
        
        op.add(new Article(1, "aspro", 30, "fiever", 30 ));
        op.add(new Article(2, "aspro2", 30, "fiever", 30 ));
        op.add(new Article(3, "aspro3", 30, "fiever", 30 ));
        op.add(new Article(4, "aspro4", 30, "fiever", 30 ));
        op.remove(2);
        
        Iterator<Article> artis = op.getAll().iterator();
        while (artis.hasNext()) {
			Article pr = artis.next();
			pr.afficher();
			
			
		}
	}

}
