<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">
			Welcome to the <em>smallest</em> online shop in the world!!
		</h2>
	</header>
	<nav>
		<ul>
			<li><a href="#">Start</a></li>
			<li><a href="http://miw.uniovi.es">About</a></li>
			<li><a href="mailto:dd@email.com">Contact</a></li>
			<li><a href="add-shopping-cart-form.action"><s:text name="Add to shopping cart" /></a></li>
			<li><a href="view-shopping-cart.action"><s:text name="View shopping cart" /></a></li>
			<li><a href="logout.action"><s:text name="logout" /></a></li>
		</ul>
	</nav>
	<section>
		<article>
			<label class="mytitle">Add books:</label><br />
			<div style="color: red;">
				<s:property value="#request.bookError" />
				<br />
			</div>
			<s:form action="add-book">
				<s:textfield name="bookInfo.title" label="title" />
				<s:textfield name="bookInfo.author" label="author" />
				<s:textarea name="bookInfo.description" label="description" />
				<s:textfield name="bookInfo.basePrice" label="basePrice" />
				<s:textfield name="vat.taxGroup" label="taxGroup" />
				<s:submit label="Add book" />
			</s:form>
		</article>
	</section>
	<footer>
		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>
