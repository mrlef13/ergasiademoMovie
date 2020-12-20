const SavedMovies = document.getElementById('SavedMovies')

var ommitProperties= ["id", "imdbid"];

$("#homebtn").click(function gotoSearch() {
	window.location.replace("Ergasia.html?userid="+getParameterByName('userid'));
});

$( document ).ready(function getAllMoviesOfUser() {
	URL="http://localhost:8080/api/profile/?userid="+getParameterByName('userid');
	$.ajax({		
               method:'GET',
               url: URL,
               success: function(data2){				
               SavedMovies.innerHTML=jsonList(data2);				
               }
     })
});

  function jsonList(json){
	  var res="";
		  jQuery.each(json, function(id,value) {
			res+="<ul>";							
				if (typeof value=='object'){
						res+=jsonList(value);					
				}
				else {
					if (!ommitProperties.includes(id))
					res +="<li>"+id+": "+value+"</li>";
				}
				res+="</ul>";				
		});		
		console.log(res);
		return res;			  	 
  }