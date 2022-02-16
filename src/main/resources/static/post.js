// map setup
let map;

// making the map
function initMap() {
  console.log("can u see this?");

  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -34.397, lng: 150.644 },
    zoom: 8,

  });

}


// this function is executed when the user selects the submit button
function submitForm() {
  window.location.href = "/submit";
  console.log(name);
}
