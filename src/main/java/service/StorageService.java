package service;

import java.io.*;
import java.util.stream.Stream;
import com.azure.core.util.Configuration;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import org.springframework.web.multipart.MultipartFile;

public class StorageService {
    private static final String CONNECTION_STRING = Configuration.getGlobalConfiguration().get(System.getenv("StorageExplorerConnectionString"));
    public String StorageService (MultipartFile file)
    {
        try
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
            Stream<String> lines = new BufferedReader(new InputStreamReader(file));
            blob.upload(file.getInputStream());
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

        return "ok";


    }
}
