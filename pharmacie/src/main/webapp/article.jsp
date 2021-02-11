<%@page import="metier.Operation"%>
<%@page import="metier.Article"%>
<%@page import="java.util.Iterator"%>
<%@page import="servlets.ArticleBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion de pharmacie</title>
<style>
tr:hover {
	background-color: #ADD8E6;
}
</style>
</head>
<body>
	<%
	ArticleBeans articles;
	if (request.getAttribute("modele") != null) {
		articles = (ArticleBeans) request.getAttribute("modele");

	} else {
		Operation o = new Operation();
		articles = new ArticleBeans();
		articles.setListe(o.getAll());
	}
	%>
	<p>Ajouter un article</p>
	<form action="arti" method="post" class="tableau">
		<table>
			<!-- 
			<tr>
				<td>Numero article</td>
				<td><input type="text" name="id" /></td>
			</tr>
-->
			<tr>
				<td>nom d'article</td>
				<td><input type="text" name="nom" id="nom" /></td>

			</tr>
			<tr>
				<td>quantite</td>
				<td><input type="number" name="quantite" id="quantite" /></td>
			</tr>
			<tr>
				<td>type maladie traiter</td>
				<td><input type="text" name="type" id="type" /></td>
			</tr>
			<tr>
				<td>prix</td>
				<td><input type="number" name="prix" id="prix" /></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="valider" /></td>
			</tr>

		</table>
	</form>

	<table id="table" width="60%">
		<thead>
			<tr>
				<th>Id</th>
				<th>nom</th>
				<th>quantite</th>
				<th>type</th>
				<th>prix</th>
				<th>Supprimmer</th>
				<th>Modifier</th>

			</tr>
		</thead>
		<%
		Iterator<Article> liste = articles.getListe().iterator();
		while (liste.hasNext()) {
			Article p = liste.next();
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getNom()%></td>
			<td><%=p.getQuantite()%></td>
			<td><%=p.getType()%></td>
			<td><%=p.getPrix()%></td>
			<td>
				<form action="arti" method=post>
					<input type="hidden" name="id" value="<%=p.getId()%>" /> <input
						type="hidden" name="action" value="supprimer" /> <input
						type="submit" value="supprimer" />
				</form>
			</td>
			<td>
				<form action="arti" method=post>
					<input type="hidden" name="id" value="<%=p.getId()%>" /> <input
						type="hidden" name="nom" value="<%=p.getNom()%>" /> <input
						type="hidden" name="quantite" value="<%=p.getQuantite()%>" /> <input
						type="hidden" name="type" value="<%=p.getType()%>" /> <input
						type="hidden" name="prix" value="<%=p.getPrix()%>" /> <input
						type="hidden" name="modifier" value="modifier" /> <input
						type="submit" value="modifier" />
				</form>
			</td>
		</tr>
		<%
		}
		%>

	</table>
	<script>
		var table = document.getElementById('table');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("nom").value = this.cells[1].innerHTML;
				document.getElementById("quantite").value = this.cells[2].innerHTML;
				document.getElementById("type").value = this.cells[3].innerHTML;
				document.getElementById("prix").value = this.cells[4].innerHTML;
			};
		}
	</script>

</body>
</html>