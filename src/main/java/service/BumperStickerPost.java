package service;
import java.util.ArrayList;

public class BumperStickerPost {
    private String img;
    private ArrayList<String> tg;
    private double lat;
    private double lon;
    //private int PostId;
    //private int TagId;

    //constructor
    public BumperStickerPost(String image, ArrayList<String> tag, double latitude, double longitude){
        img = image;
        tg = tag;
        lat = latitude;
        lon = longitude;
    }

    //get methods
    public String getImage (){
        return img;
    }

    public ArrayList<String> getTag (){
        return tg;
    }

    public double getLat (){
        return lat;
    }

    public double getLong (){
        return lon;
    }

    //set methods
    public void setImage(String newImage){
       img = newImage;
    }

    public void setTag (ArrayList<String> newTag){
        tg = newTag;
    }

    public void setLat (double newLat){
        lat = newLat;
    }

    public void setLon (double newLon){
        lon = newLon;
    }
}


