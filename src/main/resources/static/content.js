// map setup
let map;

// this function is called in the html every time the page loads
function initMap() {

  // creating the google map
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 47.62607555, lng: -122.30418194524279 },
    zoom: 12,
  });

 for(let i = 0; i < postList.size(), i++){
    var Post = postList.get(i);
    Post.get
 }

  const marker1 = new google.maps.Marker({
    position: new google.maps.LatLng(47.6205, -122.3493),
    map: map,
  });




 /*   var imgSrc = "https://kb.rspca.org.au/wp-content/uploads/2018/11/golder-retriever-puppy.jpeg"
    var tags = "#these #are #the #tags"
    var title = "Title!"
    var user = "Person"
    var lat = 47.6260456
    var lng = -122.3064097

    const contentString =
        '<div id="content">' +
        '<div id="siteNotice">' +
        "</div>" +
        '<h2 id="firstHeading" class="firstHeading">'+ title +'</h2>' +
        '<div id="bodyContent">' +
        '<img class = "photo" src="'+ imgSrc+'" width="200px">'+
        "<p><b>" + tags + "</b></p>" +
        "<p>Posted by: "+ user+"</p>" +
        "</div>" +
        "</div>";
      const infowindow = new google.maps.InfoWindow({
        content: contentString,
      });
      const marker = new google.maps.Marker({
        position: { lat: lat, lng: lng },
        map,
        title: "Uluru (Ayers Rock)",
      });

      marker.addListener("click", () => {
        infowindow.open({
          anchor: marker,
          map,
          shouldFocus: false,
        });
      });
*/



/*
   // this div holds the cards on the map page
    var cardDiv = document.createElement("div")
    cardDiv.id = "cardDiv"
    cardDiv.className = "card-deck"


        // this will loop through every sticker in the database
        for(i=0;i<10;i++){

            // creating card div
            var card = document.createElement("div")
            card.className = "card"
            card.id = "card-"+i
            card.style.width = "18rem"

                // creating photo of the card
                var photo = document.createElement("img")
                photo.className = "card-img-top"
                photo.id = "card-photo-"+i
                //photo.width = "300"
                photo.src = imgSrc // eventually change to sticker image source
                card.appendChild(photo)

                // creating div holding the card body
                var cardBody = document.createElement("div")
                cardBody.className = "card-body"
                cardBody.id = "card-body-"+i

                    // creating title of the card
                    var title = document.createElement("h5")
                    title.className = "card-title"
                    title.id = "card-title-"+i
                    title.innerHTML= "Title" // eventually change to sticker title
                    cardBody.appendChild(title)

                    // creating the tags
                    var tags = document.createElement("h6")
                    tags.className = "card-text"
                    tags.id = "card-tags-"+i
                    tags.innerHTML= "Tags" // eventually change to sticker tags
                    cardBody.appendChild(tags)

                    // creating the name
                    var name = document.createElement("p")
                    name.className = "card-text"
                    name.id = "card-name"+i
                    name.innerHTML="posted by: " + user // eventually change to sticker tags
                    cardBody.appendChild(name)

                // adds cardBody to card
                card.appendChild(cardBody)

            // adds cars to cardDiv
            cardDiv.appendChild(card)
        }

        // adds cardDiv to the content div
        document.getElementById("content").appendChild(cardDiv);*/
}