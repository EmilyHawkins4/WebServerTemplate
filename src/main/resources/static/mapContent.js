// map setup
let map;

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -34.397, lng: 150.644 },
    zoom: 8,
  });

    // this div holds the heading of the map page
    var headingDiv = document.createElement("div")
    headingDiv.id = "headingDiv"

        // making page title
          var title = document.createElement("div")
          title.innerHTML = "<h1>Bumper Stickers!</h1>"
          headingDiv.appendChild(title);

          // making back to home button
          var b2h = document.createElement("button")
          b2h.innerHTML="<p>Back to home!</p>"
          headingDiv.appendChild(b2h);

    document.getElementById("content").appendChild(headingDiv);
    headingDiv.style.textAlign = "center";

   // this div holds the cards on the map page
    var cardDiv = document.createElement("div")
    cardDiv.id = "cardDiv"

        // this will loop through every sticker in the database
        for(i=0;i<10;i++){

            // creating one card
            var card = document.createElement("div")
            card.class = "card"
            card.id = "card-"+i
            card.style.width = "18rem"

                // creating photo of the card
                var photo = document.createElement("img")
                photo.class = "card-img-top"
                photo.id = "card-photo-"+i
                photo.width = "100"
                photo.src = "https://kb.rspca.org.au/wp-content/uploads/2018/11/golder-retriever-puppy.jpeg" // eventually change to sticker image source
                card.appendChild(photo)

                // div holding the card body
                var cardBody = document.createElement("div")
                cardBody.class = "card-body"
                cardBody.id = "card-body-"+i

                    // creating caption of the card
                    var caption = document.createElement("h5")
                    caption.class= "card-title"
                    caption.id = "card-caption-"+i
                    caption.innerHTML="this is the caption" // eventually change to sticker caption
                    cardBody.appendChild(caption)

                    // creating the tags
                    var tags = document.createElement("p")
                    tags.class = "card-text"
                    tags.id = "card-tags-"+i
                    tags.innerHTML="#sticker #dog #sticker" // eventually change to sticker tags
                    cardBody.appendChild(tags)

                card.appendChild(cardBody)

            cardDiv.appendChild(card)
        }

        document.getElementById("content").appendChild(cardDiv);
}