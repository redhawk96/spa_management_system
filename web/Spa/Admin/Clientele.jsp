<%@page import="java.sql.ResultSet"%>
<%@page import="spa.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<%@include file="Layout/styles.jsp"%>
<title>Clientele</title>
</head>
<body>

	<%@include file="Layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="Layout/navigation.jsp"%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<div class=" pb-2 mb-3 border-bottom">
				<div class="row">
					<div class="col-8"><h1 class="h2">Clientele</h1></div>
					<div class="col float-right">
						<div class="alert ${message_color} alert-dismissible fade show" role="alert">
						  ${message}
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
					</div>
				</div>
			</div>

			<!--Main content-->
			<div class="col pb-2 mb-3">

				<div class="row mt-4">
					<div class="col-12">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Client ID</th>
									<th scope="col">Name</th>
									<th scope="col">Spa</th>
									<th scope="col">Address</th>
									<th scope="col">Contact</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
							<%
							ResultSet res = Client.displayAllClients();
                            while(res.next()){
                        	%>
								<tr>
									<td class="align-middle"><%= res.getString("client_id") %></td>
									<td class="align-middle text-capitalize"><%= res.getString("first_name") %> <%= res.getString("last_name") %></td>
									<td class="align-middle text-capitalize"><%= res.getString("spa_name") %></td>
									<td class="align-middle"><%= res.getString("spa_address") %></td>
									<td class="align-middle"><%= res.getString("spa_contact") %></td>
									<td class="align-middle text-center">
										<a href="<%= request.getContextPath()%>/viewSpaServerlet?cid=<%= res.getString("client_id") %>" class="btn btn-info btn-sm"><i class="fas fa-spinner"></i> View</a>
										<a href="<%= request.getContextPath()%>/removeClientServerlet?cid=<%= res.getString("client_id") %>" class="btn btn-danger ml-2 btn-sm"><i class="fas fa-trash-alt"></i> Remove</a>
									</td>
								</tr>
							<% } %>
							</tbody>
						</table>
					</div>
				</div>

				<!--End of main content-->
			</main>
		</div>
	</div>
	<%@include file="Layout/footer.jsp"%>
	<%@include file="Layout/scripts.jsp"%>
</body>
</html>