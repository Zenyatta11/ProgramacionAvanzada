<%
String redirect = (String) request.getAttribute("redirect");
if(redirect == null) redirect = "/";

%>
<script>window.location='https://java.batatas.club/ProgramacionAvanzada/zen/Parcial2<%=redirect%>';</script>
