package service;
import java.util.ArrayList;
public class BumperStickerPost {
    //private String name;
    private String image;
    private ArrayList<String> tags;
    private double latitude;
    private double longitude;
    private String title;
    //private int PostId;
    //private int TagId;
    //constructor
    public BumperStickerPost(String img, ArrayList<String> tag, String titl, double lat, double lon){
        image = img;
        tags = tag;
        latitude = lat;
        longitude = lon;
        title = titl;
    }

    //get methods
    public String getImage (){
        return image;
    }

    public ArrayList<String> getTags (){
        return tags;
    }

    public double getLat (){
        return latitude;
    }

    public double getLong (){
        return longitude;
    }

    public String getTitle(){
        return title;
    }

    /*public String getName() {
        return name;
    }*/

    //set methods
    public void setImage(String newImage){
        image = newImage;
    }

    public void setTags (ArrayList<String> newTag){
        tags = newTag;
    }

    public void setLat (double newLat){
        latitude = newLat;
    }

    public void setLon (double newLon){
        longitude = newLon;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

   /* public void setName(String newName) {
        name = newName;
    }*/
}