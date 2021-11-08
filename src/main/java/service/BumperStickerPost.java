package service;
public class BumperStickerPost {
    private String name;
    private String image;
    private String tags;
    private double lat;
    private double lon;
    private String title;
    //private int PostId;
    //private int TagId;
    //constructor
    /*public BumperStickerPost(String img, String tag, String titl, String nm){
        image = img;
        tags = tag;
        //lat = latitude;
        //lon = longitude;
        title = titl;
        name = nm;
    }*/

    //get methods
    public String getImage (){
        return image;
    }

    public String getTags (){
        return tags;
    }

    public double getLat (){
        return lat;
    }

    public double getLong (){
        return lon;
    }

    public String getTitle(){
        return title;
    }

    public String getName() {
        return name;
    }

    //set methods
    public void setImage(String newImage){
        image = newImage;
    }

    public void setTags (String newTag){
        tags = newTag;
    }

    public void setLat (double newLat){
        lat = newLat;
    }

    public void setLon (double newLon){
        lon = newLon;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

    public void setName(String newName) {
        name = newName;
    }
}