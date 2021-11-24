package service;

import java.util.ArrayList;
import java.sql.*;

public class ConnectToDatabase {
    public static void/*ArrayList<String>*/ displayPosts() {
        String hostname = "hna.database.windows.net";
        String dbName = "BumperStickers";
        String user = "hna-admin";
        String password = "";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);

        Connection connection;

        try {
            connection = DriverManager.getConnection(url);

            String query1 = "SELECT Image, lat, long, title, username FROM Posts;";
            String query2 = "SELECT Tags.tagId, TaggedPosts.PostId, Tags.tagname" + "\n" +
                    "FROM TaggedPosts" + "\n" +
                    "INNER JOIN Tags ON TaggedPosts.tagId=Tags.tagId;";

            Statement st = connection.createStatement();//create the java statement

            ResultSet resultSet1 = st.executeQuery(query1);//execute the query and get a java resultset

            ArrayList<BumperStickerPost> PostList = new ArrayList<>();

            while (resultSet1.next()) {
                String Image = resultSet1.getString("Image");//might need to capatalize if doesn't work

                double lat = resultSet1.getDouble("lat");

                double lon = resultSet1.getDouble("long");

                String title = resultSet1.getString("title");

                String username = resultSet1.getString("username");

                BumperStickerPost sticker = new BumperStickerPost(Image, title, lat, lon, username);

                PostList.add(sticker);

                //printing out the results
                //System.out.println(sticker.getImage()+ " "+sticker.getTags()+ " "+sticker.getLat()+" "+ sticker.getLong());
            }

            resultSet1 = st.executeQuery(query2);

            while(resultSet1.next()) {
                ArrayList<String> tagName;
                }



            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}