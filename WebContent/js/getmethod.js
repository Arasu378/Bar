function UserAction() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/Bar/rest/userservice/users", false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
    alert(xhttp.responseText);
    println(response);
    
    for (var i=0; i<response.UserList.length; i++) {
        var row = $('<tr><td>' + response.UserList[i].Id+ '</td><td>' + response.UserList[i].UserProfileId + '</td><td>' + response.UserList[i].UserFirstName 
        		 + response.UserList[i].UserLastName + '</td><td>' + response.UserList[i].UserMobileNumber + '</td><td>' + response.UserList[i].UserEmail
        		 + '</td><td>' +response. UserList[i].UserVenueName + '</td><td>' + response.UserList[i].UserCountry + '</td><td>' 
        		 + response.UserList[i].CreatedOn + '</td><td>' + response.UserList[i].ModifiedOn + '</td><td>' + response.UserList[i].Password + '</td></tr>');
        $('#bar_userlist').append(row);
    }
    
//    $.ajax({
//        url: '[{"Id":1,"UserProfileId":1,"UserFirstName":"Thirunavukkarasu","UserLastName":"v","UserMobileNumber":"91 9952904912","UserEmail":"v.t.a378@gmail.com","UserVenueName":"Arasu Bar Venue","UserCountry":"INDIA","UserOftenInventory":"","UserInventoryTime":0,"IsActive":false,"CreatedOn":"2017-06-21 12:26:33","ModifiedOn":"2017-06-21 12:26:33","Password":"arasu378"}]',
//        dataType: 'json',
//        success: function(data) {
//        	 alert(data);
//        	 var links = data[0].UserList;
//            for (var i=0; i<links.length; i++) {
//                var row = $('<tr><td>' + data[i].Id+ '</td><td>' + data[i].UserProfileId + '</td><td>' + data[i].UserFirstName 
//                		 + data[i].UserLastName + '</td><td>' + data[i].UserMobileNumber + '</td><td>' + data[i].UserEmail
//                		 + '</td><td>' + data[i].UserVenueName + '</td><td>' + data[i].UserCountry + '</td><td>' 
//                		 + data[i].CreatedOn + '</td><td>' + data[i].ModifiedOn + '</td><td>' + data[i].Password + '</td></tr>');
//                $('#bar_userlist').append(row);
//            }
//        },
//        error: function(jqXHR, textStatus, errorThrown){
//            alert('Error: ' + textStatus + ' - ' + errorThrown);
//        }
//    });
   
}