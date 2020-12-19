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
	alert(response==200);
	if (response==200){window.location.replace("Ergasia.html/?userid=");}
	else alert("please provide correct credentials");
});

/*
const Http = new XMLHttpRequest();
const url="http://localhost:8080/user/login/";
Http.open('POST',url);
*/
}
