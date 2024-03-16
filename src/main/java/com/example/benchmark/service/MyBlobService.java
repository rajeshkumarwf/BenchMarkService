package com.example.benchmark.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyBlobService {
    //private final AzureBlobProperties azureBlobProperties;

    @Autowired
    Environment env;
    private BlobContainerClient containerClient() {
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(env.getProperty("azure.myblob.connectionstring")).buildClient();
        BlobContainerClient container = serviceClient.getBlobContainerClient(env.getProperty("azure.myblob.container"));
        return container;
    }

    public List<String> listFiles() {
        BlobContainerClient container = containerClient();
        List list = new ArrayList<String>();
        for (BlobItem blobItem : container.listBlobs()) {
            list.add(blobItem.getName());
        }
        return list;
    }

    public ByteArrayOutputStream downloadFile(String blobitem) {
        BlobContainerClient containerClient = containerClient();
        BlobClient blobClient = containerClient.getBlobClient(blobitem);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        blobClient.download(os);
        return os;
    }

    public String storeFile(String filename, InputStream content, long length,String entityName) throws Exception {
        if(!StringUtils.hasLength(filename)){
            throw new Exception("file is null/empty");
        }
        BlobClient client = containerClient().getBlobClient(entityName + "/" + filename);

        if (client.exists()) {
            System.out.println("exist");
        } else {
            client.upload(content, length);
        }

        return "File uploaded with success!";
    }

}

