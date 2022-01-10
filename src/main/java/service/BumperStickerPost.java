package service;
import java.util.ArrayList;
public class BumperStickerPost {
    //private String name;
    private String image;
    private ArrayList<String> tags;
    private double latitude;
    private double longitude;
    private String title;
    private String username;
    private int postId;
    //private int TagId;
    //constructor

    public BumperStickerPost(){

    }

    public BumperStickerPost(String img, String titl, double lat, double lon, String nam, int Id){
        image = img;
        //tags = tag;
        latitude = lat;
        longitude = lon;
        title = titl;
        username = nam;
        postId = Id;
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

    public int getPostId(){return postId;}

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

   public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPostId(int Id) { postId = Id;}

    public String toString(){
        String str = username + " " + image + " " + title  + " " + tags.toString()  + " lat:" + latitude  + " long:" + longitude +"\n";
        return str;
    }
}