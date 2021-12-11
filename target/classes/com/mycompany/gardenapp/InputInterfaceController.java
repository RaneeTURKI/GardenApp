/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gardenapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ranee
 */
public class InputInterfaceController implements Initializable {

    static int n;
    static int ss;
    static int se;
    static int t;
    static String type;
    static int pl;
    static int pc;
    static List<String> warning = new ArrayList<String>();
    static int it;

    @FXML
    private TextField garden;
    @FXML
    private TextField tuyan;
    @FXML
    private TextField shadowEnd;
    @FXML
    private TextField shadowStart;
    @FXML
    private Button button;
    @FXML
    private ChoiceBox<String> plantType;
    @FXML
    private TextField iLigne;
    @FXML
    private TextField iCol;
    @FXML
    private Button addPlant;

    final String[] code = new String[]{"L", "T", "R", "C"} ;//   ObservableList list =FXCollections.observableArrayList();

    ObservableList<String> list = FXCollections.observableArrayList("laitus", "tomates", "rose", "clematites");
    Garden gr;
    @FXML
    private Button show;
    @FXML
    private TextField iTaille;
    @FXML
    private Button result;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadData();
        
        
    }

  

    @FXML
        private void getGardenSize(KeyEvent event) {
                n = Integer.parseInt(garden.getText().toString());

    }


    @FXML
        private void getShadowStart(KeyEvent event) {
              ss = Integer.parseInt(shadowStart.getText().toString());

    }

    @FXML
        private void getTuyanColone(KeyEvent event) {
        t = Integer.parseInt(tuyan.getText().toString());

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @FXML
        private void showGarden(ActionEvent event) {
        ArrayList<ArrayList<Plante>> plants = gr.plants;
          for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {

                  System.out.print( plants.get(x).get(y).x);
               
            }
              System.out.print("\n");

        }


       

        
    }

    @FXML
        private void getShadowEnd(KeyEvent event) {
                se = Integer.parseInt(shadowEnd.getText().toString());

    }


    @FXML
        private void getIndiceLigne(KeyEvent event) {
          
        pl= Integer.parseInt(iLigne.getText().toString());

    }

    @FXML
        private void getIndiceColone(KeyEvent event) {
             int a=  Integer.parseInt(iCol.getText().toString());
           if  (a==t)
               warning.add(" plante pas prise en compte c'est l'emplacement de tuyau");
               else
           pc = a;

    }

    @FXML
        private void addPlant(ActionEvent event) {
            Plante p = new Plante( pl, pc,it,type);
            
            gr.addPlant(p);
            
            
    }
    

  
    public void LoadData(){
      
       plantType.getItems().addAll(list);


       
    }

    @FXML
    private void getPlantType(MouseEvent event) {
        
         plantType.getSelectionModel().selectedIndexProperty()
            .addListener(new ChangeListener<Number>(){ 
            

    public void changed(ObservableValue ov, Number value, Number new_value) {
        type= code[new_value.intValue()];

    }
}
);
    }

    @FXML
    private void setGarden(ActionEvent event) {
            gr =new Garden(n,t,ss,se );

    }

    @FXML
    private void getIndiceTaille(KeyEvent event) {
           it = Integer.parseInt(iTaille.getText().toString());

    }

    @FXML
    private void showResult(ActionEvent event) {
        
         for (int x = 1; x < n-1; x++) {

            for (int y = 1; y < n-1; y++) {
                
               Plante b= gr.plants.get(x).get(y);
               if (b.x !="*" || b.x != "")
               {
                int b0 = b.tMax ;
                int b1 = gr.plants.get(x).get(y+1).tMax;
                int b2 = gr.plants.get(x).get(y-1).tMax;
                int b3 = gr.plants.get(x+1).get(y+1).tMax;
                int b4 = gr.plants.get(x+1).get(y-1).tMax;
                int b5 = gr.plants.get(x-1).get(y+1).tMax;
                int b6 = gr.plants.get(x-1).get(y-1).tMax;
                int b7 = gr.plants.get(x).get(y-1).tMax;
                int b8 = gr.plants.get(x).get(y+1).tMax;
                List<Integer> liste = new ArrayList<Integer>();
                
                liste.addAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8));
                   Integer max = Collections.max(liste);    
                    Integer min = Collections.min(liste); 
                    
                    if (Math.abs(b0-max)>30 ||Math.abs(b0-min)>30)
                        warning.add("plante de l'emplacement " +x +","+y+ " a un voisin non compatible " );

        

                
                




}                        
               
               

               
            }

        }
         
         System.out.println(warning);
    }



  


 



}
