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
  function submitForm(){

    // sets form value with id of name to variable name
    var name = document.getElementById("name").value;

    // sets form value with id of tags to variable tags
    var tags = document.getElementById("tags").value;

    // sets form value with id of title to variable title
    var title = document.getElementById("title").value;

    // sets form value with id of img to variable image
    var image = document.getElementById("img").value;

    // sets form value with id of latitude to lat


    // sets form value of longitude to lng
    window.location.href = "/submit";
    console.log(name);
  }
