<%

String errorText = (String)request.getAttribute("errorText");

%>
<form action="?action=register" method="post" accept-charset="UTF-8" style="background-color: #000;">
	<div class="tborder login" style="padding-top: 5%; padding-bottom: 5%;">
		<div class="cat_bar">
			<h3 class="catbg">
				<span class="ie6_header floatleft"><img src="https://batatas.club/Themes/default/images/icons/login_sm.gif" alt="" class="icon"> Registrarse</span>
			</h3>
		</div>

		<span class="upperframe">
			<span></span>
		</span>

		<div class="roundframe"><br class="clear">
			<dl>
				<dt>Nombre:</dt>
				<dd><input type="text" name="p_nombre" size="20" value="" class="input_text"></dd>
				<dt>Apellido:</dt>
				<dd><input type="text" name="p_apellido" size="20" value="" class="input_text"></dd>
				<dt>DNI:</dt>
				<dd><input type="number" name="p_dni" size="20" value="" class="input_text"></dd>
			</dl>
			<dl>
				<dt>Telefono:</dt>
				<dd><input type="number" name="p_telefono" size="20" value="" class="input_text"></dd>
				<dt>Email:</dt>
				<dd><input type="email" name="p_email" size="20" value="" class="input_text"></dd>
			</dl>
			<p><input type="submit" value="Registrar" class="button_submit"></p>
			<p class="smalltext"><a href="?action=login">Ya tiene cuenta? Inicie sesión!</a></p>
			<%=(errorText != null ? "<p class=\"smalltext\" style=\"color: #fff;font-weight: bolder;\">" + errorText + "</p>" : "")%>
		</div>
		
		<span class="lowerframe">
			<span></span>
		</span>
	</div>
</form>