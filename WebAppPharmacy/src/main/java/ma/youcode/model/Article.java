package ma.youcode.model;

import java.io.Serializable;

public class Article implements Serializable{
	private int id;
	private String nom;
	private int quantite;
	private String type;
	private int prix;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String nom, int quantite, String type, int prix) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.type = type;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", type=" + type + ", prix=" + prix
				+ "]";
	}
	

}
