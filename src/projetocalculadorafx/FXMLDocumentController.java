/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projetocalculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author eduardo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lblResult;
    private double num1=0,num2=0,answer=0;
    private String operator = "";
        
    @FXML
    private void numberCalc(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        lblResult.setText(lblResult.getText() + value);
    }
    
    @FXML
    private void operatorCalc(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        
        switch (value) {
            case "+":
                num1 = Double.parseDouble(lblResult.getText());
                operator = value;
                lblResult.setText("");
                break;
                
            case "-":
                num1 = Double.parseDouble(lblResult.getText());
                operator = value;
                lblResult.setText("");
                break;
                
            case "*":
                num1 = Double.parseDouble(lblResult.getText());
                operator = value;
                lblResult.setText("");
                break;
                
            case "/":
                num1 = Double.parseDouble(lblResult.getText());
                operator = value;
                lblResult.setText("");
                break;
                
            case ".":
                lblResult.setText(lblResult.getText() + ".");
                break;
                
            case "(-)":
                double temp = Double.parseDouble(lblResult.getText());
                temp *= -1;
                lblResult.setText(String.valueOf(temp));
                
        }
    
        if (value.equals("=")) {
            num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
            case "+":
                answer = num1 + num2;
                break;
                
            case "-":
                answer = num1 - num2;
                break;
            
            case "*":
                answer = num1 * num2;
                break;
                
            case "/":
                answer = num1 / num2;
                break;
            }
        lblResult.setText(String.valueOf(answer));
        num1 = answer;
        }
    }
    
    @FXML
    private void clearText(ActionEvent event) {
        lblResult.setText("");
        num1 = 0;
        num2 = 0;
        operator = "";
    }
    
    @FXML
    private void deleteButton(ActionEvent event) {
        String text = lblResult.getText();
        lblResult.setText("");
        for(int i = 0; i < text.length()-1; i++){
            lblResult.setText(lblResult.getText() + text.charAt(i));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
