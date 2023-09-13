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
		<h3>Insert Word to Dictionary</h3>
		<form:form action="insert" method="post"
			modelAttribute="wordDictionary">

			<form:input type="hidden" path="id"/>

			<form:label path="word">Word</form:label>
			<form:input type="text" path="word" required="required" />
			<form:errors path="word" cssClass="text-warning" />
<br>
			<form:label path="definition">Definition</form:label>
			<form:input type="text" path="definition" required="required" />
			<form:errors path="definition" cssClass="text-warning" />
			

			<input type="submit" class="btn btn-success">
		</form:form>
		<p>${successSave}</p>

		<hr>

		<h3>Search Definition by Word</h3>
		<form action="findDefinition" method="get">
			<label for="word">Search word:</label> <input type="text" name="word"
				required="required"> <input type="submit"
				class="btn btn-success">
		</form>

		<hr>

		<h3>Search Definition by Partial Word</h3>
		<form action="findDefinitionByPartialWord" method="get">
			<label for="word">Search word:</label> <input type="text" name="word"
				required="required"> <input type="submit"
				class="btn btn-success">
		</form>



	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>