function Login()
{
//var username= document.getElementById("u")
//var password= document.getElementById("p")


//var data = JSON.stringify({ "username": username.value, "password": password.value }); 
 //alert(data);

//var URL ="http:/user/login";
    
 var form = new FormData();
form.append("username", "a");
form.append("password", "b");
    alert(form);
    
  var settings = {
  "url": "http://localhost:8080/user/login/",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "": ""
  },
  "processData": false,
  "mimeType": "multipart/form-data",
  "contentType": false,
  "data": form
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

/*$.ajax({
               cache: false,
               method:'POST',
               url: URL,
               data:data,
               dataType: JSON,
               success: function(data){ 
           alert(data) ;
                   
    if( response.success ){
    window.location.replace("www.google.gr");
}
       else {
         alert ("errorMessage");
          }
       }
})*/
}
