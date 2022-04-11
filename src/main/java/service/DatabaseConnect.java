package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.Arrays;

public class DatabaseConnect {

        //save data from form to database
        public void saveData(BumperStickerPost post) {
            String postId = "";
            String tagId = "";

            String hostName = "hna.database.windows.net";
            String dbName = "BumperStickers";
            String user = "hna-admin";
            String password = "HolyNames123";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
                    + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url);
                String username;
                if (post.getUsername() == null) {
                    username = null;
                } else {
                    username = String.format("%s", post.getUsername());
                }
                String image = post.getImage();
                /*if (post.getImage() == null) {
                    image = "final bb logo (white).png";
                } else {
                    image = String.format("%s", post.getImage());
                }*/
                String title = String.format("%s", post.getTitle());
                //String tags = String.format("%s", post.getTags());
                String lat;
                if (post.getLat() == null){
                    lat = null;
                } else {
                    lat = String.format("%f", post.getLat());
                }

                String lng;
                if (post.getLng() == null){
                    lng = null;
                } else {
                    lng = String.format("%f", post.getLng());
                }
                //String lat = String.format("%f", post.getLat());
                //String lng = String.format("%f", post.getLng());
                String query = "INSERT INTO Posts(username, Image, title, lat, long) VALUES ('" + username + "','" + image + "','" + title + "'," + lat + "," + lng + ")";
                Statement st = connection.createStatement();
                st.execute(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet postIDs = st.getGeneratedKeys();
                postIDs.next();
                postId = postIDs.getString(1);
                System.out.println("postID:" + postId);
            } catch (Exception e) {
                System.err.println("Got an error! ");
                System.err.println(e.getMessage());
            }
            try {
                connection = DriverManager.getConnection(url);
                //String theTags = .toString(.toArray()).replace("[", "").replace("]", "");
                String theTags = Arrays.toString(post.getTags().toArray()).replace("[", "").replace("]", "");
                String tags = String.format("%s", theTags);
                String query = "INSERT INTO Tags(tagname) VALUES ('" + tags + "')";
                Statement st = connection.createStatement();
                st.execute(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet tagIDs = st.getGeneratedKeys();
                tagIDs.next();
                tagId = tagIDs.getString(1);
                System.out.println("tagtID:" + tagId);
            } catch (Exception e) {
                System.err.println("Got an error! ");
                System.err.println(e.getMessage());
            }
            try {
                connection = DriverManager.getConnection(url);

                String query = "INSERT INTO TaggedPosts(tagId, PostId) VALUES ('" + tagId + "','" + postId + "')";
                Statement st = connection.createStatement();
                st.execute(query);
            } catch (Exception e) {
                System.err.println("Got an error! ");
                System.err.println(e.getMessage());
            }
        }

}
