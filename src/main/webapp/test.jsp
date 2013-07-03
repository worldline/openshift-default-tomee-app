<%@ page language="java" %>
<html>
  <head>
    <title>Test page</title>
  </head>
<body>
<table border="1">
<tr><td><b>Property Names</b></td>
<td><b>Property Values</b></td></tr>
<%
java.util.Properties p = System.getProperties();
java.util.Enumeration keys = p.keys();
while (keys.hasMoreElements()) {
  String key = (String)keys.nextElement();
  String value = (String)p.get(key);
  System.out.println(key + ": " + value);
%>
<tr>
<td><%= key %></td>
<td><%= value %></td>
</tr>
<% } %>
</table>

<table border="1">
<tr><td><b>Variable Names</b></td>
<td><b>Variable Values</b></td></tr>
<%
java.util.Map<String, String> variables = System.getenv();
for (java.util.Map.Entry<String, String> entry : variables.entrySet())
{
   String key = entry.getKey();
   String value = entry.getValue();
   System.out.println(key + "=" + value);
%>
<tr>
<td><%= key %></td>
<td><%= value %></td>
</tr>
<% } %>
</table>

</body>
</html>