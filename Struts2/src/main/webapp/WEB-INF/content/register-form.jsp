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
		</ul>
	</nav>
	<section>
		<article>
			<label class="mytitle">Registro:</label><br />
			<div style="color: red;">
				<s:property value="#request.mymessage" />
				<br />
			</div>
			<s:form action="register"  >
				<s:textfield name="user.name" label="name" />
				<s:textfield name="user.email" label="email" />
				<s:textfield name="user.phone" label="phone" />
				<s:password name="user.password" label="password" />
				<s:password name="user.repeatPassword" label="Repeat password" />
				<s:submit label="registro" />
			</s:form>
		</article>
	</section>
	<footer>
		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>
