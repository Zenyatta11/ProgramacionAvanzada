<%
String contentToShow = (String) request.getAttribute("content");
if(contentToShow == null) contentToShow = "aprobarUsuarios.jsp";

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
				<div class="windowbg">
					<div style="min-height: 200px;">
						<div>
							<jsp:include page="<%=contentToShow%>" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>