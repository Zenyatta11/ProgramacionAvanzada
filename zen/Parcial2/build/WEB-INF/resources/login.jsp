<%

String errorText = (String)request.getAttribute("errorText");

%>
<form action="?action=login" method="post" accept-charset="UTF-8" style="background-color: #000;">
	<div class="tborder login" style="padding-top: 5%; padding-bottom: 5%;">
		<div class="cat_bar">
			<h3 class="catbg">
				<span class="ie6_header floatleft"><img src="https://batatas.club/Themes/default/images/icons/login_sm.gif" alt="" class="icon"> Login</span>
			</h3>
		</div>

		<span class="upperframe">
			<span></span>
		</span>

		<div class="roundframe"><br class="clear">
			<dl>
				<dt>Nombre:</dt>
				<dd><input type="text" name="p_username" size="20" value="" class="input_text"></dd>
				<dt>DNI:</dt>
				<dd><input type="password" name="p_passwd" value="" size="20" class="input_password"></dd>
			</dl>
			<p><input type="submit" value="Login" class="button_submit"></p>
			<p class="smalltext"><a href="?action=register">No tiene cuenta? Registrese!</a></p>
			<%=(errorText != null ? "<p class=\"smalltext\" style=\"color: #fff;font-weight: bolder;\">" + errorText + "</p>" : "")%>
		</div>
		
		<span class="lowerframe">
			<span></span>
		</span>
	</div>
</form>