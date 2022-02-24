// map setup
let map;

// this function is called in the html every time the page loads
function initMap() {

  // creating the google map
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 47.62607555, lng: -122.30418194524279 },
    zoom: 12,
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