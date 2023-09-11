<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Open Tables</title>
    <link rel="stylesheet" href="/css/style.css" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
  </head>

  <body>
    <div class="container">
      <h1 class="mt-5">Open Tables:</h1>
      <table class="table">
        <thead>
          <tr>
            <th>Guest Name</th>
            <th># Guest</th>
            <th>Arrival Time</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${mesas}" var="mesa">
            <tr>
              <td><c:out value="${mesa.guest}" /></td>
              <td><c:out value="${mesa.number}" /></td>
              <td><c:out value="${mesa.createdAt}" /></td>
              <td>
                <form action="/tables" method="post">
                  <input type="hidden" name="mesaId" value="${mesa.id}" />
                  <button type="submit" class="btn btn-primary">
                    Pickup Table
                  </button>
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a class="btn btn-secondary" href="/home">Home</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
</html>
