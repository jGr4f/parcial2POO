/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.parcial2poo.model;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author juanr
 */
public class ConexionDB {

    public static Firestore db;

    public static void conectarFirestore() {
        try {
            FileInputStream sAcc = new FileInputStream("");
            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(sAcc))
            .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Base conectada con exito.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());

        }
    }
}