package com.petziferum.backend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FbCocktailService {

    public Object getCocktail() throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef = firestore.collection("cocktails").document("ZHraTUqGfxuumwhQvKYf");

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();
        System.out.println("document: --- ----   " + document);
        if (document.exists()) {
            Object cocktail = null;

            cocktail = document;
            return cocktail;
        } else {
            System.out.println("Nichts gefunden!");
            return null;
        }
    }
}
