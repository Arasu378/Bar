<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
     <style type="text/css">
    table {
        border: 1px solid #777;
        border-collapse: collapse;
        margin: 10px;
    } 

    table tr th,
    table tr td {
        border: 1px solid #777;
        margin-left: 15px;
        margin-right: 15px;
        margin-bottom: 5px;
        margin-top: 5px;
        font-style: normal;
        font-family: serif;
        
    }
    </style>
<title>User List</title>
</head>
<body>

 <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getmethod.js"></script>
        <script src="https://use.typekit.net/ayg4pcz.js"></script>
        
<div class="container">
<div class="table-responsive"  >
   <div id="datalist"></div>

    <script src="/path/to/js/jquery-1.10.2.min.js"></script>
<h1>Bar User List</h1>
<br/>
<input type="button" class="btn btn-success btn-lg active" value="Get Data" onclick="UserAction()" placeholder="center">

<table class="table table-bordered table-striped" id="bar_userlist"  onloadstart="UserAction()" >
<tr>
<th> Id </th>
<th> UserProfileId </th>
<th> UserFirstName </th>
<th> UserLastName </th>
<th> UserMobileNumber </th>
<th> UserEmail </th>
<th> UserVenueName </th>
<th> UserCountry </th>
<th> CreatedOn </th>
<th> ModifiedOn </th>
<th> Password </th>

</tr>
</table>



</div>

</div>
<p id="demo"></p>
        <script>
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Bar/rest/userservice/users", false);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send();
        var response = JSON.parse(xhttp.responseText);
var myObj, i, x = "";
myObj = response;
//alert(xhttp.responseText);

for (i in myObj.UserList) {
    x += myObj.UserList[i].UserFirstName + "<br>";
}
document.getElementById("demo").innerHTML = x;
for (var i=0; i<response.UserList.length; i++) {
    var row = $('<tr><td>' + response.UserList[i].Id+ '</td><td>' + response.UserList[i].UserProfileId + '</td><td>' + response.UserList[i].UserFirstName 
    		+ '</td><td>' + response.UserList[i].UserLastName + '</td><td>' + response.UserList[i].UserMobileNumber + '</td><td>' + response.UserList[i].UserEmail
    		 + '</td><td>' +response. UserList[i].UserVenueName + '</td><td>' + response.UserList[i].UserCountry + '</td><td>' 
    		 + response.UserList[i].CreatedOn + '</td><td>' + response.UserList[i].ModifiedOn + '</td><td>' + response.UserList[i].Password + '</td></tr>');
    $('#bar_userlist').append(row);
}

</script>
</body>
</html>