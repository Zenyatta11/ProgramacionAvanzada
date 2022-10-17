<%@page import="edu.usal.LoginPage"%>

<%

String nameToShow = "Guest";

%>
<div id="header">
	<div class="frame">
		<div id="upper_section" class="middletext">
			<div class="user">
				
				<ul class="reset">
					<li class="greeting">Hello <span><%=nameToShow%> </span></li>
					<li><a href="?action=devolver">Tiene 2 libros arrendados.</a></li>
					<li><a href="?action=habUser">Hay 6 solicitudes de alta de usuario</a></li>
					<li><a href="?action=habLease">Hay 6 solicitudes de alta de arrenda</a></li>
					<li><%=(new java.util.Date()).toLocaleString()%></li>
				</ul>
			</div>
		</div>
		<br class="clear">
		<div id="main_menu">
			<ul class="dropmenu" id="menu_nav">
				<li id="button_home">
					<a class="active firstlevel" href="https://batatas.club/index.php">
						<span class="last firstlevel">Home</span>
					</a>
				</li>
				<li id="button_help">
					<a class="firstlevel" href="https://batatas.club/index.php?action=help">
						<span class="firstlevel">Arrendar Libros</span>
					</a>
				</li>
				<li id="button_search">
					<a class="firstlevel" href="https://batatas.club/index.php?action=search">
						<span class="firstlevel">Devolver Libros</span>
					</a>
				</li>
				<li id="button_admin">
					<a class="firstlevel" href="https://batatas.club/index.php?action=admin">
						<span class="firstlevel">Modificar Libros</span>
					</a>
					<ul>
						<li>
							<a href="https://batatas.club/index.php?action=admin;area=featuresettings">
								<span>Libros</span>
							</a>
						</li>
						<li>
							<a href="https://batatas.club/index.php?action=admin;area=packages">
								<span>Editoriales</span>
							</a>
						</li>
						<li>
							<a href="https://batatas.club/index.php?action=admin;area=logs;sa=errorlog;desc">
								<span>Autores</span>
							</a>
						</li>
						<li>
							<a href="https://batatas.club/index.php?action=admin;area=permissions">
								<span class="last">Generos</span>
							</a>
						</li>
					</ul>
				</li>
				<li id="button_login">
					<a class="firstlevel" href="https://batatas.club/index.php?action=logout;fef42b55=1bebaa445ac717c09ad72892fe2a5f73">
						<span class="last firstlevel">Login</span>
					</a>
				</li>
				<li id="button_logout">
					<a class="firstlevel" href="https://batatas.club/index.php?action=logout;fef42b55=1bebaa445ac717c09ad72892fe2a5f73">
						<span class="last firstlevel">Logout</span>
					</a>
				</li>
				<li id="button_search">
					<a class="firstlevel" href="https://batatas.club/index.php?action=logout;fef42b55=1bebaa445ac717c09ad72892fe2a5f73">
						<span class="last firstlevel">Aprobar Libros</span>
					</a>
				</li>
				<li id="button_search">
					<a class="firstlevel" href="https://batatas.club/index.php?action=logout;fef42b55=1bebaa445ac717c09ad72892fe2a5f73">
						<span class="last firstlevel">Aprobar Usuarios</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<br class="clear">
</div>