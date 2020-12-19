function Login()
{
	var u =document.getElementById("u").value;
	var p =document.getElementById("p").value;
	
var form = new FormData();
form.append("username", u);
form.append("password", p);

var settings = {
  "url": "http://localhost:8080/user/login/",
  "method": "POST",
  "timeout": 0,  
  "processData": false,
  "mimeType": "multipart/form-data",
  "contentType": false,
  "data": form
};

$.ajax(settings).success(function (response) {
	alert(response);
	if (response!=null){window.location.replace("Ergasia.html?userid="+response);}
	else alert("Please provide correct credentials");
});
}
