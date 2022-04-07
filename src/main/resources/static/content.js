// map setup
let map;

// this function is called in the html every time the page loads
function initMap() {


  var maxLat = postList[0].lat;
  var maxLng = postList[0].lng;
  var minLat = postList[0].lat;
  var minLng = postList[0].lng;
  for (var i = 0; i < postList.length; i++) {
    var Post = postList[i];
    var latitude = Post.lat;
    var longitude = Post.lng;

    if (latitude == null || longitude == null) {
      continue;
    }

    if (latitude > maxLat) {
      maxLat = latitude;
    }
    if (latitude < minLat) {
      minLat = latitude;
    }

    if (longitude > maxLng) {
      maxLng = longitude;
    }
    if (longitude < minLng) {
      minLng = longitude;
    }
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
    center: { lat: (maxLat + minLat) / 2, lng: (maxLng + minLng) / 2 },
    zoom: zoomAmount,
  });

  var markers = [];
  markers.length = postList.length;

  for (var i = 0; i < postList.length; i++) {
    var Post = postList[i];
    if (Post.lat == null || Post.lng == null) {
      continue;
    }
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
    //create and pass in function after 'click'
    var search = document.getElementById("searchButton")
    search.addEventListener('click', searchByTag)

}

function searchByTag() {
    for (var i = 0; i < postList.length; i++){
        var Post = postList[i]; //Post = post from postlist
        var Tag = Post.tags; //
        for (var j = 0; j < Tag.length; j++){
            if(Tag[j] == document.getElementById("searchBar").value){
                document.getElementById("#div-id-" + (i+1)).display = "none";
            }
        }
    }
}
