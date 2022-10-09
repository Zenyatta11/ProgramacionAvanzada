<%@page import="edu.usal.dominio.Usuario"%>

<%
String rootDirectory = (String)request.getAttribute("rootDirectory");
Usuario currentUser = (Usuario)request.getAttribute("currentUser");
String nameToShow = (currentUser != null ? currentUser.getNombre() : "Guest");

String buttons = "" + 
"				<li id=\"button_home\">" + 
"					<a class=\"active firstlevel\" href=\"" + rootDirectory + "/index\">" + 
"						<span class=\"last firstlevel\">Home</span>" + 
"					</a>" + 
"				</li>";
String subText = "";

if(currentUser == null) {
	buttons = buttons + "" + 
"				<li id=\"button_login\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=login\">" + 
"						<span class=\"last firstlevel\">Login</span>" + 
"					</a>" + 
"				</li>" + 
"				<li id=\"button_login\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=register\">" + 
"						<span class=\"last firstlevel\">Register</span>" + 
"					</a>" + 
"				</li>";
} else if(currentUser.isAdmin()) {
	buttons = buttons + "" + 
"				<li id=\"button_admin\">" + 
"					<a class=\"firstlevel\">" + 
"						<span class=\"firstlevel\">Modificar Libros</span>" + 
"					</a>" + 
"					<ul>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=libros\">" + 
"								<span>Libros</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=editoriales\">" + 
"								<span>Editoriales</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=authors\">" + 
"								<span>Autores</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=generos\">" + 
"								<span class=\"last\">Generos</span>" + 
"							</a>" + 
"						</li>" +
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=users\">" + 
"								<span class=\"last\">Usuarios</span>" + 
"							</a>" + 
"						</li>" +
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=admins\">" + 
"								<span class=\"last\">Administradores</span>" + 
"							</a>" + 
"						</li>" + 
"					</ul>" + 
"				</li>" + 
"				<li id=\"button_search\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=approve&item=libros\">" + 
"						<span class=\"last firstlevel\">Aprobar Libros</span>" + 
"					</a>" + 
"				</li>" + 
"				<li id=\"button_search\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=approve&item=usuarios\">" + 
"						<span class=\"last firstlevel\">Aprobar Usuarios</span>" + 
"					</a>" + 
"				</li>" + 
"				<li id=\"button_logout\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=logout\">" + 
"						<span class=\"last firstlevel\">Logout</span>" + 
"					</a>" + 
"				</li>";
	subText = "";
	int usuariosSinHabilitacion = (request.getAttribute("usuariosSinHabilitar") == null ? 0 : Integer.valueOf((String)request.getAttribute("usuariosSinHabilitar")));
	int solicitudesArrenda = (request.getAttribute("solicitudesArrenda") == null ? 0 : Integer.valueOf((String)request.getAttribute("solicitudesArrenda")));
	
	if(usuariosSinHabilitacion > 0) subText = subText + "<li><a href=\"?action=view&item=usersDisabled\">Hay " + usuariosSinHabilitacion + " solicitudes de alta de usuario</a></li>";
	if(solicitudesArrenda > 0) subText = subText + "<li><a href=\"?action=view&item=leases\">Hay " + solicitudesArrenda + " solicitudes de alta de arrenda</a></li>";

} else {
	buttons = buttons + "" + 
"				<li id=\"button_admin\">" + 
"					<a class=\"firstlevel\">" + 
"						<span class=\"firstlevel\">Ver</span>" + 
"					</a>" + 
"					<ul>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=libros\">" + 
"								<span>Libros</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=editoriales\">" + 
"								<span>Editoriales</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=authors\">" + 
"								<span>Autores</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=generos\">" + 
"								<span class=\"last\">Generos</span>" + 
"							</a>" + 
"						</li>" + 
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=users\">" + 
"								<span class=\"last\">Usuarios</span>" + 
"							</a>" + 
"						</li>" +
"						<li>" + 
"							<a href=\"" + rootDirectory + "/index?action=view&item=admins\">" + 
"								<span class=\"last\">Administradores</span>" + 
"							</a>" + 
"						</li>" + 
"					</ul>" + 
"				</li>" + 
"				<li id=\"button_help\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=lease&item=take\">" + 
"						<span class=\"firstlevel\">Arrendar Libros</span>" + 
"					</a>" + 
"				</li>" + 
"				<li id=\"button_search\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=lease&item=return\">" + 
"						<span class=\"firstlevel\">Devolver Libros</span>" + 
"					</a>" + 
"				</li>" + 
"				<li id=\"button_logout\">" + 
"					<a class=\"firstlevel\" href=\"" + rootDirectory + "/index?action=logout\">" + 
"						<span class=\"last firstlevel\">Logout</span>" + 
"					</a>" + 
"				</li>" + 
				"";

	subText = "<li><a href=\"?action=devolver\">Tiene 2 libros arrendados.</a></li>";
}

%>
<div id="header">
	<div class="frame">
		<div id="upper_section" class="middletext">
			<div class="user">
				
				<ul class="reset">
					<li class="greeting">Hello <span><%=nameToShow%> </span></li>
					<%=subText%>
					<li><%=(new java.util.Date()).toLocaleString()%></li>
				</ul>
			</div>
		</div>
		<br class="clear">
		<div id="main_menu">
			<ul class="dropmenu" id="menu_nav">
				<%=buttons%>
			</ul>
		</div>
	</div>
	<br class="clear">
</div>