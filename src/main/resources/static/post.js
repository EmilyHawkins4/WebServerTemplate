// map setup
let map;

// making the map
function initMap() {
    console.log("can u see this?");
    const myLatlng = { lat: 47.62607555, lng: -122.30418194524279 }
  map = new google.maps.Map(document.getElementById("map"), {
    center: myLatlng,
    zoom: 8,

  });

// Create the initial InfoWindow.
  let infoWindow = new google.maps.InfoWindow({
    content: "Select your bumbersticker's location!",
    position: myLatlng,
  });
  let marker = new google.maps.Marker({
       position: myLatlng,
       map,
       title: "Sticker!",
    });

  infoWindow.open(map);

  map.addListener("click", (mapsMouseEvent) => {
        infoWindow.close();
        marker.setMap(null);

      marker = new google.maps.Marker({
             position: mapsMouseEvent.latLng,
             map,
             title: "Sticker!",
          });

        console.log(JSON.stringify(mapsMouseEvent.latLng.toJSON(), null, 2));

        document.getElementById("lat").value = marker.getPosition().lat();
        document.getElementById("lng").value = marker.getPosition().lng();
        document.getElementById("lat").setAttribute("field", marker.getPosition().lat());
        document.getElementById("lng").setAttribute("field", marker.getPosition().lng());

    });


  }

function checkImage(){
  if(document.getElementById('img').files[0].size > 1048576){
        alert("Your file is too large! Please select a different file. ")
    }
}
