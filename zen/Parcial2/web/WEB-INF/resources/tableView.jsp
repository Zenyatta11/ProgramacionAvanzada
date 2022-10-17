<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
String headerHTML = "";
String bodyHTML = "";

String filterHTML = (request.getAttribute("tableFilters") == null ? "" : (String)request.getAttribute("tableFilters"));
List<String> Headers = (List<String>)request.getAttribute("tableHeaders");
List<ArrayList<String>> Data = (List<ArrayList<String>>)request.getAttribute("tableData");

for(String text : Headers) {
	headerHTML = headerHTML + "<th style=\"background: #000; color:#FFF;\">" + text + "</th>";
}

for(ArrayList<String> line : Data) {
	String innerHTML = "";

	for(String text : line) {
		innerHTML = innerHTML + "<td style=\"text-align: center;\">" + text + "</td>";
	}
	bodyHTML = bodyHTML + "<tr>" + innerHTML + "</tr>";
}

%>
<table class="collapse" width="90%" border="1" style="margin-left: auto; margin-right: auto;">
	<thead>
		<%=filterHTML%>
		<tr>
			<%=headerHTML%>
		</tr>
	</thead>

	<tbody id="post_files\">
		<tr>
			<%=bodyHTML%>
		</tr>
	</tbody>
</table>