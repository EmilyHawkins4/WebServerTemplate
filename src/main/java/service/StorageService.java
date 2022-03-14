package service;

import java.io.*;
import java.util.Map;
import java.util.stream.Stream;
import com.azure.core.util.Configuration;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import org.springframework.web.multipart.MultipartFile;

public class StorageService {
    //private static final String CONNECTION_STRING = Configuration.getGlobalConfiguration().get(System.getenv("storageExplorerConnectionString"));
    public String StorageServices (MultipartFile file) throws IOException {
        try {
            String constr = System.getenv("storageExplorerConnectionString");
            Map<String, String> env = System.getenv();
            for (String envName : env.keySet()) {
                if(envName == "storageExplorerConnectionString"){
                    constr = env.get(envName);
                }
                System.out.format("%s=%s%n", envName, env.get(envName));
            }
            System.out.println(constr);

            BlobContainerClient container = new BlobContainerClientBuilder()
                    .connectionString(constr)
                    .containerName("upload")
                    .buildClient();

            BlobClient blob = container.getBlobClient(file.getOriginalFilename());

           // blob.upload(file.getInputStream(), file.getSize(), true);
            blob.upload(new BufferedInputStream(file.getInputStream()) , file.getInputStream().available());
            System.out.println("ok!");

        }
        catch (Exception e){
            System.err.println("Got an error!");
            System.err.println(e.getMessage());
        }
        return "ok";

       /* try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(CONNECTION_STRING);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Get a reference to a container.
            // The container name must be lower case
            CloudBlobContainer container = blobClient.getContainerReference("mycontainer");

            // Create the container if it does not exist.
            container.createIfNotExists();
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(CONNECTION_STRING);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("mycontainer");

            CloudBlockBlob blob = container.getBlockBlobReference(file.getName());
            //Stream<String> lines = new BufferedReader(new InputStreamReader(file));
            blob.upload(file.getInputStream(), file.getSize(), true);
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

        return "ok";
*/

    }
}
