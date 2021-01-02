<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">View your shopping cart...</h2>
	</header>
	<nav>
		<ul>
			<li><a href="index.action">Start</a></li>
			<li><a href="http://miw.uniovi.es">About</a></li>
			<li><a href="mailto:dd@email.com">Contact</a></li>
			<li><a href="add-shopping-cart-form.action"><s:text
						name="Add to shopping cart" /></a></li>
			<li><a href="view-shopping-cart.action"><s:text
						name="View shopping cart" /></a></li>
			<li><a href="logout.action"><s:text name="logout" /></a></li>
		</ul>
	</nav>
	<section>
		<article>
			<%
				if (request.getAttribute("booksInCart") != null) {
			%>
			<h3>View of the shopping cart!</h3>
			<table>
				<caption>The books you have in the shopping cart</caption>
				<thead>
					<tr>
						<th>Title</th>
						<th>Quantity
						<th>Price by unit</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.booksInCart">
						<tr>
							<td><s:property value="key.title" /></td>
							<td><s:property value="value" /></td>
							<td><s:property value="key.price" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<span>Total price:</span> <span> <s:property
					value="#request.price"></s:property>
			</span>
			<%
				}
			%>
			<%
				if (request.getAttribute("booksInCart") == null) {
			%>
				<span>You dont have books to be shown</span>
			<%
				}
			%>
		</article>
	</section>
	<footer>
		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>