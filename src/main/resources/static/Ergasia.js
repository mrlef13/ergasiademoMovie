const MovieResults = document.getElementById('MovieResults')
const MovieMoreInfo = document.getElementById('MovieMoreInfo')

var jsondata= "";
var moviechosen = "";
var output2= new Array();
var output3= "";
var currentinput= "";

$("#logoutbtn").click(function gotoLogin() {
	window.location.replace("Login.html?")
});

$("#myprofile").click(function gotoMyprofile() {
	window.location.replace("Myprofile.html?userid="+getParameterByName('userid'));
});

function KeepSearch() {
var input= document.getElementById("sid");

var json= "";
var apikey= "f675ca42"  ;         
var URL = "http://www.omdbapi.com/?i=tt3896198&apikey="+ apikey+ "&t=" +input.value;
var output  = ""; 
var userid = getParameterByName('userid');

    
currentinput = input.value;
    if (input.value == "") {
        MovieResults.innerHTML="";
        MovieMoreInfo.innerHTML="";
    }
   
    else{
         
      var prevResult;  
   $.ajax({
               cache: false,
               method:'GET',
               url: URL,
               success: function(data){ 
               //console.log(data)
          if (data.hasOwnProperty('imdbID')){
			jsondata=data;
             output +="<h3>Title: "+data.Title+" </h3><h4>Year: "+data.Year+" </h4><img src="+data.Poster+"/>"
					+"<h5 id='plot'>  Plot: "+data.Plot+" </h5><br><button class='Moredetails' id='Moredetails' onclick= 'MovieSelected(\""+data.imdbID+"\")'>"
					+"More Info</button><button class='AddtoProfile' id='AddtoProfile' onclick= 'findMovieFromIMDBID(\""+data.imdbID+"\",\""+userid+"\")'>Add to My Profile</button>";
            
            output2[0] = "<h5>Runtime: "+data.Runtime+" </h5>" ;
            output2[1] = "<h5>Writer: "+data.Writer+" </h5>" ;
            output2[2] = "<h5>Director: "+data.Director+" </h5>";
            output2[3] = "<h5>Type: "+data.Type+" </h5>";
            output2[4] = "<h5>Genre: "+data.Genre+" </h5>";
            output2[5] = "<h5>Language: "+data.Language+" </h5>";
            output2[6] = "<h5>Awards: "+data.Awards+" </h5>";
            output2[7] = "<h5>Rated: "+data.Rated+" </h5>";
            output2[8] = "<h5>imdbRating: "+data.imdbRating+" </h5>";
            output2[9] = "<h5>Country: "+data.Country+" </h5>";
            output2[10] = "<h5>Metascore: "+data.Metascore+" </h5>";
            output2[11] = "<h5>Production: "+data.Production+" </h5>";
            output2[12] = "<h5>Released: "+data.Released+" </h5>";
            output2[13] = "<br><button id='LessInfo' class='LessInfo' onclick='HideInfo()'>Less Info</button>";


    	MovieResults.innerHTML= output;
	
            MovieMoreInfo.innerHTML= "";
                            
                   }else{ MovieResults.innerHTML = ""; }
    
         }      
      })
  }
   
    

var URL2= "http://www.omdbapi.com/?i=tt3896198&apikey="+ apikey+ "&t=" +currentinput+ "&plot=full";
$.ajax({
               method:'GET',
               url: URL2,
               success: function(data2){
               console.log(data2)
               output3 ="<h4>Full Plot: "+data2.Plot+" </h4>";

               }
     }) 
} 

function HideInfo() {
    console.log('testing')
    document.getElementById('MovieMoreInfo').style.display = "none";
    document.getElementById('Moredetails').style.display="block";
    document.getElementById('plot').style.display= "block";
}
function MovieSelected (id) {
    moviechosen = id
    //console.log(moviechosen);
    var results ="";
    
   var arrayLength = output2.length;
   for (var i = 0; i < arrayLength; i++) {
    results += output2[i] 
}
        MovieMoreInfo.innerHTML= output3  + results;
    
    document.getElementById('Moredetails').style.display= "none";
    document.getElementById('MovieMoreInfo').style.display="block";
    document.getElementById('plot').style.display= "none";
}


function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

function AddtoProfile(movieid, userid){
			console.log("AddtoProfile "+movieid);	
			var URL3= "http://localhost:8080/api/profile/?userid="+userid+"&movieid="+movieid;
			$.ajax({
             method:'PUT',
             url: URL3,
             success: function(data3){
				alert("movie added");
        	}
     	});
}
 
function findMovieFromIMDBID(imdbid,userid){
var URL= "http://localhost:8080/api/movies/?imdbid="+imdbid;

 $.ajax({
               method:'GET',
               url: URL,
               success: function(data){							
				if (data==0){					
						var form = new FormData();
						form.append("title", jsondata.Title);
						form.append("writer", jsondata.Writer);
						form.append("director",jsondata.Director);
						form.append("imdbid", imdbid);
						
						var settings = {
						  "url": "http://localhost:8080/api/movies/",
						  "method": "POST",
						  "timeout": 0,						  
						  "processData": false,
						  "mimeType": "multipart/form-data",
						  "contentType": false,
						  "data": form
						};
						
						$.ajax(settings).done(function (response) {
						  AddtoProfile(response, userid)
						});
				}
				if (data>0){
					AddtoProfile(data, userid)
				}				
				
               }
			
     })
}

