// map setup
let map;

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

    // sets form value with id of caption to variable caption
    var caption = document.getElementById("caption").value;

    // sets form value with id of img to variable image
    var image = document.getElementById("img").value;

    // sets form value with id of latitude to lat


    // sets form value of longitude to lng
    debugger;
    window.location.href = "/submit";
    console.log(name);
  }
