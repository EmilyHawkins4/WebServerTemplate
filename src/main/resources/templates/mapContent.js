console.log("really hope you can see this!!");
alert("the js is finally working!");

var mapboxgl = require('mapbox-gl/dist/mapbox-gl.js');

mapboxgl.accessToken = 'pk.eyJ1IjoiZW1pbHloYXdraW5zIiwiYSI6ImNrdDR4dW45azAzNmUybnA3MHN3dnpmcGUifQ.Ghn-1zwT9vWyQEg42YHkPA';
var map = new mapboxgl.Map({
container: 'map',
style: 'mapbox://styles/mapbox/streets-v11'
});