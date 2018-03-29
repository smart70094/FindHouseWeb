<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script type="text/javascript" src="house.js"></script>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>FindHouseSystem</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 text-center">
				<form>
					
					<div class="form-label-group">
						<label for="inputCity">縣&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市</label>
	        			<input type="text" id="city" class="" placeholder="" required autofocus>
					</div>	
					
					<div class="form-label-group">
						<label for="inputDistrict">區&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;域</label>
	        			<input type="text" id="district" class="" placeholder="" required autofocus>
					</div>
					
					<div class="form-label-group">
						<label for="inputPrice_floor">價錢下限</label>
	        			<input type="text" id="price_floor" class="" placeholder="" required autofocus>
	        			<label for="inputPrice_ceil">價錢上限</label>
	        			<input type="text" id="price_ceil" class="" placeholder="" required autofocus>
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example"> 
     					 <button class="btn btn-primary" type="submit">Search</button>      					
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example"> 
     					 <button class="btn btn-secondary" type="button" onclick="clearInfo()">Clear</button>      					
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example"> 
     					 <button class="btn btn-success" type="button">Fresh</button>      					
					</div>
					
					
					
     					   
					
				</form>
			</div>
				
			<div class="col-lg-9 text-center">
				<table class="table table-bordered" style="width: 100%">
					<c:forEach var="element" items="${data}">
						<tr>
							<td><img src=${element.get("picture_address")} style="width: 100%"></td>
							<td>
								<ul>
									<li>${element.get("house_id")}</li>
									<li>${element.get("name")}</li>
									<li>${element.get("address")}</li>
									<li>${element.get("type")}</li>
									<li>${element.get("floor_info")}</li>
									<li>${element.get("price")}</li>
									<li>${element.get("area")}</li>
									<li>${element.get("house_holder")}</li>
									<li>${element.get("living")}</li>
									<li>${element.get("device")}</li>
									<li>${element.get("browsenum")}</li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
	
	
	
</body>
</html>

