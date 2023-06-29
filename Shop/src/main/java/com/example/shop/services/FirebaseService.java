package com.example.shop.services;

import ch.qos.logback.classic.log4j.XMLLayout;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service
public class FirebaseService {

    private Storage store = StorageOptions.getDefaultInstance().getService();


    public String save(MultipartFile file) throws Exception {
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("myfirstproject-b8101.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        store =StorageOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("myfirstproject-b8101-firebase-adminsdk-fhlyq-fd9abd73e8.json")))
                .build().getService();
        store.create(blobInfo, file.getInputStream());
        return imageName;
    }

    public String getUrl(String fileName){
        return "https://firebasestorage.googleapis.com/v0/b/myfirstproject-b8101.appspot.com/o/" + fileName + "?alt=media&token=5a719401-e3c4-4fd3-a0da-7d55efa4e0c7";
    }
}
