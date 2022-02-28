// map setup
let map;

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

    if(longitude>maxLat){
            maxLng = longitude;}
    if(longitude<minLat){
            minLng = longitude;}


}

    console.log(maxLat);
    console.log(minLat);
    console.log(maxLng);
    console.log(minLng);
  // creating the google map
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: (maxLat+minLat)/2, lng: (maxLng+minLng)/2 },
    zoom: 12,
//    restriction: {
//        latLngBounds: {
//          north: maxLng + 2,
//          south: minLng + 2,
//          east: maxLat + 2,
//          west: minLat + 2,
//        },
//      },
  });

  var markers = [];
  markers.length = postList.length;

  for (var i = 0; i < postList.length; i++) {
    var Post = postList[i];
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

    google.maps.event.addListener(markers[i], 'click', function () {
      this.info.open(map, this);
    });

  }

}