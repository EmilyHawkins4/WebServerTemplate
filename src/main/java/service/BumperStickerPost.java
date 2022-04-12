package service;
import java.util.ArrayList;
public class BumperStickerPost {
    //private String name;
    private String image;
    private ArrayList<String> tags;
    private Double latitude;
    private Double longitude;
    private String date;
    private String title;
    private String username;
    private int postId;
    //private int TagId;
    //constructor

    public BumperStickerPost(){

    }

    public BumperStickerPost(String img, String titl, Double lat, Double lng, String theDate, String nam, int Id){
        image = img;
        //tags = tag;
        latitude = lat;
        longitude = lng;;
        date = theDate;
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

    public Double getLat (){
        System.out.println("getLat: " + latitude);
        return latitude;
    }

    public Double getLng (){
        System.out.println("getLng: "+longitude);
        return longitude;
    }

    public String getDate (){
        System.out.println("getDate: "+date);
        return date;
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

    public void setLat (Double newLat){
        latitude = newLat;
    }

    public void setLng (Double newLng){
        longitude = newLng;
    }

    public void setDate (String newDate){
        date = newDate;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

   public void setUsername(String newUsername) {
        username = newUsername;
    }

    public void setPostId(int Id) { postId = Id;}

    public String toString(){
        String str = username + " " + image + " " + title  + " " + tags.toString()  + " lat:" + latitude  + " long:" + longitude +  " " + date + "\n";
        return str;
    }
}