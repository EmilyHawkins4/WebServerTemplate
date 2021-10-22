// map setup
let map;

// this function is called in the html every time the page loads
function initMap() {

  // creating the google map
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 47.62607555, lng: -122.30418194524279 },
    zoom: 12,
  });

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
                photo.src = "https://kb.rspca.org.au/wp-content/uploads/2018/11/golder-retriever-puppy.jpeg" // eventually change to sticker image source
                card.appendChild(photo)

                // creating div holding the card body
                var cardBody = document.createElement("div")
                cardBody.className = "card-body"
                cardBody.id = "card-body-"+i

                    // creating caption of the card
                    var caption = document.createElement("h5")
                    caption.className = "card-title"
                    caption.id = "card-caption-"+i
                    caption.innerHTML="this is the caption" // eventually change to sticker caption
                    cardBody.appendChild(caption)

                    // creating the tags
                    var tags = document.createElement("h6")
                    tags.className = "card-text"
                    tags.id = "card-tags-"+i
                    tags.innerHTML="#sticker #dog #sticker" // eventually change to sticker tags
                    cardBody.appendChild(tags)

                    // creating the name
                    var name = document.createElement("p")
                    name.className = "card-text"
                    name.id = "card-name"+i
                    name.innerHTML="posted by: user" // eventually change to sticker tags
                    cardBody.appendChild(name)

                card.appendChild(cardBody)

            cardDiv.appendChild(card)
        }

        document.getElementById("content").appendChild(cardDiv);
}