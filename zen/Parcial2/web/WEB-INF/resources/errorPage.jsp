<%@page import="edu.usal.dominio.ErrorLevel"%>
<%
ErrorLevel errorLevel = (ErrorLevel)request.getAttribute("errorLevel");
boolean success = errorLevel.isError();
String errorMessage = errorLevel.getPayload();
%>
<div id="content_section">
	<div class="frame">
		<div id="main_content_section">
			<div id="forumposts">
				<div class="cat_bar">
					<h3 class="catbg">
						<img src="https://batatas.club/Themes/default/images/topic/normal_post.gif" alt="" align="bottom">
						<span id="author">Files</span>
					</h3>
				</div>
				<div class="windowbg" style="background-color: #000;">
					<div style="min-height: 200px; padding: 5%;">
						<div>
							<div id="fatal_error">
								<div class="cat_bar">
									<h3 class="catbg">
										<%=(success ? "Success!" : "An Error Has Occurred!")%>
									</h3>
								</div>

								<div class="windowbg">
									<span class="topslice"><span></span></span>
									<div class="padding" style="text-align: center"><%=errorMessage%></div>
									<span class="botslice"><span></span></span>
									
									<div class="centertext">
										<a href="javascript:;" onclick="window.location = '<%=(String)request.getAttribute("rootDirectory")%>'">Home</a>
									</div>
									<br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>