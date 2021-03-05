package com.petziferum.backend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FbCocktailService {

    public Object getCocktail() throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        /*DocumentReference docRef = firestore.collection("cocktails").document();*/

        ApiFuture<QuerySnapshot> future = firestore.collection("cocktails").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        /*DocumentSnapshot document = future.get();
        System.out.println("document: --- ----   " + document);
        if (document.exists()) {
            Object cocktail = null;

            cocktail = document;
            return cocktail;
        } else {
            System.out.println("Nichts gefunden!");
            return null;
        }

         */
        class Cocktail {
            String id;
            String description;
            List<String> ingredients;
            String name;
            String strengh;

            public Cocktail(){

            }
        }
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document.getId() + " => " + document.toObject(Cocktail.class));

        }
        return documents;
    }
}
