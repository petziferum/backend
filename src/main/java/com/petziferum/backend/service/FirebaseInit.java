package com.petziferum.backend.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FirebaseInit {

    @PostConstruct
    public void initialize(){
        System.out.println("- - - Starte Firebase - - - ");
        try {
            File file = new ClassPathResource("./firebaseKey.json").getFile(); //Um Dateien einzulesen funktioniert es so mit ClassPathResource
            InputStream in = new FileInputStream(file);
            /*FileInputStream serviceAccount =
                    new FileInputStream("firebaseKey.json");
*/
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(in))
                    .setDatabaseUrl("https://petziferum-85609.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase gestartet");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
