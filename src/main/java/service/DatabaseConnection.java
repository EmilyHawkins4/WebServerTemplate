package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {
/*
    //save data from form to database
    public void saveData(BumperSticker post) {
        String hostName = "hna.database.windows.net";
        String dbName = "BumperStickers";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            String name;
            if (post.getName() == null) {
                name = null;
            } else {
                name = String.format("%s", post.getName());
            }
            String image;
            if (post.getImage() == null) {
                image = "final bb logo (white).png";
            } else {
                image = String.format("%s", post.getImage());
            }
            String title = String.format("%s", post.getTitle());
            String tags = String.format("%s", post.getTags());
            double lat = String.format("%f", post.getLat());
            double lng = String.format("%f", post.getLng());
            String query = "INSERT INTO post_database(name, image, title, tags, lat, lng) VALUES ('" + name + "','" + image + "','" + title + "','" + tags + "','" + lat + "','" + lng + "')";
            Statement st = connection.createStatement();
            st.execute(query);
        } catch (Exception e) {
            System.err.println("Got an error! ");
            System.err.println(e.getMessage());
        }
    }*/


}