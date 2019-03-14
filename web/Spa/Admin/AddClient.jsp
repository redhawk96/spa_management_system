<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<%@include file="Layout/styles.jsp"%>
<title>New Client</title>
</head>
<body>

	<%@include file="Layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="Layout/navigation.jsp"%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<div class=" pb-2 mb-3 border-bottom">
				<div class="row">
					<div class="col-8"><h1 class="h2">New Client</h1></div>
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

				<div class="row">
					<div class="col-6 offset-3">
					
					<form action="<%= request.getContextPath()%>/addClientServerlet" method="post">
					<div class="tab-content" id="pills-tabContent">
					
					  <div class="tab-pane fade show active" id="pills-user" role="tabpanel" aria-labelledby="pills-user-tab">
					  
                          <div class="form-group">
						    <label>First Name</label>
						    <input type="text" class="form-control text-capitalize" placeholder="First name" name="first_name">
						  </div>
						    
						  <div class="form-group">
						    <label>Last Name</label>
						    <input type="text" class="form-control text-capitalize" placeholder="Last name" name="last_name">
						  </div>
						  
						  <div class="form-group">
						    <label>NIC</label>
						    <input type="text" class="form-control" placeholder="NIC" name="nic">
						  </div>
						  
						  <div class="form-group">
						    <label>Contact Number</label>
						    <input type="number" class="form-control" placeholder="Contact Number" name="contact_number">
						  </div>
						  
						  
						  <div class="form-group">
						    <label>Email</label>
						    <input type="email" class="form-control"placeholder="Email" name="email" >
						  </div>
						  
						  <div class="form-group float-right">
						  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						  	<li class="nav-item">
						  	<a class="btn btn-primary btn-block float-right" data-toggle="pill" href="#pills-spa" role="tab" aria-controls="pills-spa" aria-selected="false">Next</a>
							</li>
						  </ul>	
						  </div>
						  
						
					  </div>
					  
					  <div class="tab-pane fade" id="pills-spa" role="tabpanel" aria-labelledby="pills-spa-tab">
					  	
					  	  <div class="form-group">
						    <label>Spa Name</label>
						    <input type="text" class="form-control text-capitalize" placeholder="Spa Name" name="spa_name">
						  </div>
						    
						    <div class="form-group">
						    <label>Address</label>
						    <input type="Text" class="form-control text-capitalize" placeholder="Spa location" name="spa_address">
						  </div>
						  
						  <div class="form-group">
						    <label>Contact Number</label>
						    <input type="Number" class="form-control" placeholder="Spa Contact Number" name="spa_contact">
						  </div>
						  
						  <div class="form-group">
						    <label>Image</label>
						    <input type="text" class="form-control" name="spa_image">
						  </div>
						  
						  
						  <div class="form-group float-right">
						  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						  <!--  
						  	<li class="nav-item">
						    <a class="btn btn-secondary" id="pills-user-tab" data-toggle="pill" href="#pills-user" role="tab" aria-controls="pills-user" aria-selected="true">Previous</a>
						  	</li>
						  -->
						  	<li class="nav-item">
						  	<a class="btn btn-primary btn-block float-right" data-toggle="pill" href="#pills-register" role="tab" aria-controls="pills-register" aria-selected="false">Next</a>
							</li>
						  </ul>	
						  </div>
						</div>
						
					  
					  
					  <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="pills-register-tab">
					  
					    <div class="form-group">
						    <label>User Name</label>
						    <input type="text" class="form-control" placeholder="User Name" name="user_name">
						  </div>
						  
						  <div class="form-group">
						    <label>Password</label>
						    <input type="password" class="form-control" name="password">
						  </div>
						  
						  <div class="form-group float-right">
						  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item">
						  	<button class="btn btn-success" type="submit">Register</button>
							</li>
						  </ul>	
						  </div>
					  </div>
					  
				</div>
				</form>
				</div>
			</div>
		</div>
				
			<!--End of main content--> </main>
		</div>
	</div>
	<%@include file="Layout/footer.jsp"%>
	<%@include file="Layout/scripts.jsp"%>
</body>
</html>