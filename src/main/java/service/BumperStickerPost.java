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

    public BumperStickerPost(String img, String titl, String lat, String lng, String nam, int Id){
        image = "https://holynamesacademy.blob.core.windows.net/bumperstickers/" +img;
        //tags = tag;
        latitude = Double.parseDouble(lat);
        longitude = Double.parseDouble(lng);;
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
        System.out.println("getLat: " + latitude);
        return latitude;
    }

    public double getLng (){
        System.out.println("getLng: "+longitude);
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

    public void setLng (double newLng){
        longitude = newLng;
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