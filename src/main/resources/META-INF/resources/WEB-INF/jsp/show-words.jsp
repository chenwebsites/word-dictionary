<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">


<title>Word Dictionary</title>
</head>
<body>
	<div class="container">
		<h1>Word Dictionary</h1>
		<hr>
		<div class="alert">${wordNotExists}</div>
		<c:if test="${condition}">
			<c:forEach items="${wordsList}" var="wordDictionary">
				<div class="container">
					<div class="row">
						<div class="col">
							<h5>${wordDictionary.word}</h5>
						</div>
						<div
							class="col-2 d-flex justify-content-between align-items-center">
							<a href="remove-word?id=${wordDictionary.id}"
								class="btn btn-warning btn-sm">Delete Word</a>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p class="mb-1">${wordDictionary.definition}</p>
						</div>
					</div>
				</div>


			</c:forEach>
		</c:if>



		<hr>
		<a href="/" class="btn btn-secondary btn-sm active"
			aria-pressed="true">Back</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>