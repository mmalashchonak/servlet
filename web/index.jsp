<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>

<h1>Add New Person</h1>
<form action="SaveServlet" method="post">
  <table>
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Save Person"/></td></tr>
  </table>
</form>

<br/>
<a href="ViewServlet">view persons</a>

</body>
</html>
