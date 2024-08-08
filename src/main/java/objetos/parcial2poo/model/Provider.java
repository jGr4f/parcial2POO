/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.parcial2poo.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanr
 */
public class Provider {
    CollectionReference reference;
    
    static Firestore db;
    
    public static boolean guardarX(String coleccion, String documento, Map<String, Object>data){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Informacion guardada correctamente. ");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        return false;
    }
    public static boolean actualizarX(String coleccion, String documento, Map<String, Object>data){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println("Informacion actualizada correctamente. ");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        return false;
    }
    
    public static boolean eliminar(String coleccion, String documento){
        db = FirestoreClient.getFirestore();
        
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Informacion eliminada correctamente. ");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        return false;
    }
    public static void cargarTablaPersona(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Email");
        model.addColumn("Documento");
        model.addColumn("Edad");
        
        try {
            CollectionReference personas = ConexionDB.db.collection("Persona");
            ApiFuture<QuerySnapshot> querySnaps = personas.get();
            
            for(DocumentSnapshot document: querySnaps.get().getDocuments()){
                model.addRow(new  Object[]{
                    document.getId(),
                    document.getString("Nombre"),
                    document.getString("Email"),
                    document.getString("Documento"),
                    document.getString("Edad")
                        
                });
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        }
        table.setModel(model);
        
    }
    
}