<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<s:property value="#request.userExists" />
				<br />
			</div>
			<s:form action="register"  >
				<s:textfield name="registerInfo.username" label="Username" />
				<s:textfield name="registerInfo.phone" label="Phone" />
				<s:textfield name="registerInfo.age" label="Age" />
				<s:password name="registerInfo.password" label="Password" />
				<s:password name="registerInfo.repeatPassword" label="Repeat password" />
				<s:submit value="Register" />
			</s:form>
		</article>
	</section>
	<footer>
		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>
