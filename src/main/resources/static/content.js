// map setup
let map;

// this adds the name if it is a name search page
var url = window.location.href;
window.onload = function searchName(){
    if(url.includes("?name=")){
        var start = url.indexOf("=");
        var username = url.substring(start+1, url.length);
        console.log("username"+username);
        document.getElementById("searchName").innerHTML = "<p>Posts by "+username+"</p>";
        document.getElementById("optionalButton").innerHTML = "<button class='button-small'><a href='/content' id='homeButton'>Back to View!</a></button>";
        //document.getElementById("container").style.marginTop=-5px;

    }

    // this displays the info window when a user clicks the card
    $(document).ready(function(){
           $(".checkClick").each(function(){
               $(this).on("click", function(){
                   //alert("clicked! ");
                   //console.log(this);
                   //console.log("marker: "+markers[1]);
                   // info = figure out corresponding info window
                   // this.info.open(map, this);
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

  var markers = [];
  markers.length = postList.length;

  for (var i = 0; i < postList.length; i++) {
    var Post = postList[i];
    if (Post.lat == null || Post.lng == null){
        continue;}
    var latitude = Post.lat;
    var longitude = Post.lng;
    var title = Post.title;
    var user = Post.username;
    var img = Post.image;

    markers[i] = new google.maps.Marker({
      position: new google.maps.LatLng(latitude, longitude),
      map: map,
    });
    markers[i].info = new google.maps.InfoWindow({
      content: "<b>" + title + "</b><br/> Posted by: " + user + "<br/> <img class = photo src=" + img + " width=200px >"
    });

    lastWindow=null;
    google.maps.event.addListener(markers[i], 'click', function () {
        if (lastWindow) lastWindow.close();
        this.info.open(map, this);
        console.log("lat: "+this.getPosition().lat());
        console.log("lng: "+this.getPosition().lng());
        var targetLat = '[lat=\"'+this.getPosition().lat()+'\"]'
        console.log(targetLat);
        console.log(document.querySelector(targetLat));
        document.querySelector(targetLat).scrollIntoView({behavior: "smooth"});
        lastWindow= this.info;
    });

  }

  //markers[2].info.open(map, markers[2]); <-- this opens the infowindow
  /*var theString = markers[2].info.toString();
  var index = theString.indexOf("<");
  console.log("index: "+index)
  var theTitle = theString.substring(2, 7);
    console.log("marker: "+ theTitle);*/

}