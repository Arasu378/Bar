var UserProfileid=sessionStorage.UserProfileId;
var xhttp = new XMLHttpRequest(); 

xhttp.open("GET", "http://localhost:8080/Bar/rest/GetVenueSummary/"+UserProfileid, false);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send();
var response = JSON.parse(xhttp.responseText);
//document.getElementById("demo_version").innerHTML ="Bar response  : "+xhttp.responseText;

for (var i=0; i<response.Model.length; i++) {
	var value=i+1;
	var row = $('<tr class="space_left" align="center"><td>' + value+'</td></div><div  class="card" ><td>'+'<img src="'+response.Model[i].PictureURL+'" alt="" border=3 height=50 width=50></img>' +'</td></div><div  class="card" ><td>'+response.Model[i].LiquorName 
    		+ '</td></div><div  class="card" ><td>' + response.Model[i].Category + '</td></div><div  class="card" ><td>' + response.Model[i].SubCategory + '</td></div><div  class="card" ><td>' + response.Model[i].LiquorCapacity
    		+ '</td></div><div  class="card" ><td>' + response.Model[i].DistributorName 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].Price 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].BinNumber 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].ProductCode 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].Shots 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].TotalBottles 
    		+'</td></div><div  class="card" ><td>' + response.Model[i].Type + '</td></div><div  class="card" ><td>'
    		
    		+'</td></div></tr>');
    $('#get_total_liquor_list').append(row);
}