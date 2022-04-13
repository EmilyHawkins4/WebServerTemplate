// map setup
let map;

window.onload = function searchName(){

const d = new Date();
var date = (d.getMonth()+1)+"/"+d.getDate()+"/"+d.getFullYear();
var theDate = date.toString();
document.getElementById("date").value = theDate;
document.getElementById("date").setAttribute("field", theDate);

    document.getElementById("tags").addEventListener('keydown', function(event) {
        const key = event.key;
        if (key === "Backspace") {
            var text = document.getElementById("tags").value;
            if(text.charAt(text.length-1)=="#".charAt(0)){
                document.getElementById("tags").value = text.slice(0, -1);
            }
        }
    });
}
// making the map
function initMap() {

    var photo = document.getElementById('img');
    photo.addEventListener('input',loadImage,false);

    function loadImage(){
        if(document.getElementById('img').files[0].size > 1048576){
            alert("Your file is too large! Please select a different file!")
            document.getElementById("img").value = null;
        }
    }

    const myLatlng = { lat: 47.62607555, lng: -122.30418194524279 }
  map = new google.maps.Map(document.getElementById("map"), {
    center: myLatlng,
    zoom: 5,

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

        document.getElementById("lat").value = marker.getPosition().lat();
        document.getElementById("lng").value = marker.getPosition().lng();
        document.getElementById("lat").setAttribute("field", marker.getPosition().lat());
        document.getElementById("lng").setAttribute("field", marker.getPosition().lng());

  });
  }

  function addFirstTag(){
     var userTags = document.getElementById("tags").value;
          if(userTags.charAt(0) != "#"){
              document.getElementById("tags").value = "#"+document.getElementById("tags").value;
          }
  }
  function addMoreTags(){
    var value = document.getElementById("tags").value
    if(value.slice(-1)==" "){
        document.getElementById("tags").value = document.getElementById("tags").value + "#";
    }
  }
function checkTags(){
    var theTags = document.getElementById("tags").value;
    document.getElementById("tags").value = theTags.toLowerCase();
        if(theTags.charAt(0) != "#"){
            document.getElementById("tags").value = "#"+document.getElementById("tags").value;
        }
}
