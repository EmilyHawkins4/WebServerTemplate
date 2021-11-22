package service;
import java.util.ArrayList;
public class BumperStickerPost {
    //private String name;
    private String image;
    private ArrayList<String> tags;
    private double latitude;
    private double longitude;
    private String title;
    private String name;
    private String username;
    //private int PostId;
    //private int TagId;
    //constructor

    public BumperStickerPost(){

    }

    public BumperStickerPost(String img, ArrayList<String> tag, String titl, double lat, double lon, String nam){
        image = img;
        tags = tag;
        latitude = lat;
        longitude = lon;
        title = titl;
        username = nam;
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

    public String getUsername() {
        return username;
    }

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

   public void setUserame(String newUsername) {
        username = newUsername;
    }
}