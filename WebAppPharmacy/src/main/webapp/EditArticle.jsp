<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pharmacy</title>
<!-- <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


</head>

<body>
	<%@include file="header.jsp"%>

	<div class="container col-md-8 col-md-offset-2 col-xs-12  mr-8 ml-8">
		<div class="card">
			<div class="card-header bg-primary">Ajouter un article</div>
			<div class="card-body"></div>
			<form action="UpdateArticle.php" method="post">
			<div class="form-group">
					<label class="control-label">ID</label> <input type="number"
						name="id" value="${article.id}" class="form-control"
						required="required" /> <span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Nom</label> <input type="text"
						name="nom" value="${article.nom}" class="form-control"
						required="required" /> <span></span>
				</div>

				<div class="form-group">
					<label class="control-label">Quantite</label> <input type="number"
						name="quantite" value="${article.quantite}" class="form-control"
						required="required" /> <span></span>
				</div>

				<div class="form-group">
					<label class="control-label">Type</label> <input type="text"
						name="type" value="${article.type}" class="form-control"
						required="required" /> <span></span>
				</div>

				<div class="form-group">
					<label class="control-label">Prix</label> <input type="number"
						name="prix" value="${article.prix}" class="form-control"
						required="required" /> <span></span>
				</div>

				<div>
					<button type="submit" class="btn btn-primary">Sauvegader</button>
				</div>
			</form>

		</div>
	</div>
</body>
</html>