// map setup
let map;

var markers = [];

var lastWindow = null;

// this adds the name if it is a name search page
var url = window.location.href;
window.onload = function searchName(){
    if(url.includes("?name=")){
        var start = url.indexOf("=");
        var username = url.substring(start+1, url.length);
        document.getElementById("searchName").innerHTML = "<h5 id='showPost'>Posts by "+username+"</h5>";
        document.getElementById("optionalButton").innerHTML = "<button class='button-small'><a href='/content' id='homeButton'>Back to View!</a></button>";
        document.getElementById("pageHeading").style.paddingBottom = "0px";
        document.getElementById("container").style.marginTop = "0px";

    }
    if(url.includes("?date=")){
            var start = url.indexOf("=");
            var date = url.substring(start+1, url.length);
            document.getElementById("searchName").innerHTML = "<h5 id='showPost'>Posts from "+date+"</h5>";
            document.getElementById("optionalButton").innerHTML = "<button class='button-small'><a href='/content' id='homeButton'>Back to View!</a></button>";
            document.getElementById("pageHeading").style.paddingBottom = "0px";
            document.getElementById("container").style.marginTop = "0px";

        }

    // this displays the info window when a user clicks the card
    $(document).ready(function(){
           $(".checkClick").each(function(){
               $(this).on("click", function(){
                    var cardLat = this.getAttribute("lat");
                    var cardLng = this.getAttribute("lng");
                    for(var p=0; p<markers.length; p++){
                        if(markers[p].getPosition().lat()==cardLat && markers[p].getPosition().lng()==cardLng){
                            if (lastWindow){lastWindow.close();}
                                markers[p].info.open(map, markers[p]);
                                lastWindow= markers[p].info;
                        }
                     }
               });
           });
    });
}

// this function is called in the html every time the page loads
function initMap() {


var maxLat = postList[0].lat;
var maxLng = postList[0].lng;
var minLat = postList[0].lat;
var minLng = postList[0].lng;
for(var i=0; i< postList.length; i++){
    var Post = postList[i];
    var latitude = Post.lat;
    var longitude = Post.lng;

    if(latitude>maxLat){
        maxLat = latitude;}
    if(latitude<minLat){
        minLat = latitude;}

    if(longitude>maxLng){
            maxLng = longitude;}
    if(longitude<minLng){
            minLng = longitude;}
}

var zoomAmount;
if (maxLat - minLat < 2 || maxLng - minLng < 2) {
    zoomAmount = 8;
}
else if (maxLat - minLat < 20 || maxLng - minLng < 20) {
    zoomAmount = 5;
}
else if (maxLat - minLat >= 20 || maxLng - minLng >= 20) {
    zoomAmount = 2;
}

  // creating the google map
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: (maxLat+minLat)/2, lng: (maxLng+minLng)/2 },
    zoom: zoomAmount,
  });

  markers.length = postList.length;

  for (var i = 0; i < postList.length; i++) {
    var Post = postList[i];
    if (Post.lat == null || Post.lng == null){
        continue;}
    var latitude = Post.lat;
    var tags = Post.tags;
    var longitude = Post.lng;
    var title = Post.title;
    var user = Post.username;
    var img = Post.image;

    markers[i] = new google.maps.Marker({
      position: new google.maps.LatLng(latitude, longitude),
      map: map,
    });
    markers[i].info = new google.maps.InfoWindow({
      content: "<b><h6>" + title + "</h6></b>"+ " <img class = photo src=" + img + " width='200px' height='150px'>"+"<strong>"+tags+"</strong>"+"<p> Posted by: " + user+"</p>"
    });

    lastWindow=null;
    google.maps.event.addListener(markers[i], 'click', function () {
        if (lastWindow) lastWindow.close();
        this.info.open(map, this);
        var targetCoordinates = '[lat=\"'+this.getPosition().lat()+'\"], [lng=\"'+this.getPosition().lng()+'\"]'
        document.querySelector(targetCoordinates).scrollIntoView({behavior: "smooth"});
        lastWindow= this.info;
    });

  }

}