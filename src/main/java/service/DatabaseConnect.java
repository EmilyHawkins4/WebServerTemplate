package service;

//import com.azure.storage.*;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import java.io.*;
//import com.azure.core.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class DatabaseConnect {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=your_storage_account;" +
                    "AccountKey=your_storage_account_key";

        public String uploadImage(){
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint("<your-storage-account-url>")
                    .sasToken("<your-sasToken>")
                    .buildClient();

            BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("mycontainer");

            BlobClient blobClient = blobContainerClient.getBlobClient("myblob");

            blobServiceClient.createBlobContainer("mycontainer");

            BlobClient blobClientUpload = blobContainerClient.getBlobClient("myblob");
            String dataSample = "samples";
            blobClientUpload.upload(BinaryData.fromString(dataSample));

            /*try {
                return blobClient.downloadContent();
            } catch {
                return null;
            }*/
        }

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
                String image;
                if (post.getImage() == null) {
                    image = "final bb logo (white).png";
                } else {
                    image = String.format("%s", post.getImage());
                }
                String title = String.format("%s", post.getTitle());
                //String tags = String.format("%s", post.getTags());
                String lat = String.format("%f", post.getLat());
                String lng = String.format("%f", post.getLng());
                String query = "INSERT INTO Posts(username, Image, title, lat, long) VALUES ('" + username + "','" + image + "','" + title + "','" + lat + "','" + lng + "')";
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
                String tags = String.format("%s", post.getTags());
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
