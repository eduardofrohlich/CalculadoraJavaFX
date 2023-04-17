package projetocalculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lblOperation;
    
    @FXML
    private Label lblResult;
    private double num1=0,num2=0,answer=0;
    private String operator = "";
    private boolean error;
    private String operation = "";

    @FXML
    private void numberCalc(ActionEvent event) {
        if (error) {
            return;
        }

        String value = ((Button)event.getSource()).getText();
        if (lblResult.getText().equals(String.valueOf(answer))) {
            lblResult.setText(value);
            operation = "";
        } else {
            lblResult.setText(lblResult.getText() + value);
        }
        operation += value;
        lblOperation.setText(operation);
    }

    @FXML
    private void operatorCalc(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (lblResult.getText().equals("ERROR")) {
            return;
        }

        switch (value) {
            case "+":
            case "-":
            case "*":
            case "/":
                if (!operator.equals("")) {
                    calculate(null);
                    if (error) {
                        return;
                    }
                    num1 = answer;
                } else {
                    num1 = Double.parseDouble(lblResult.getText());
                }
                operator = value;
                lblResult.setText("");
                operation += " " + value + " ";
                break;

            case ".":
                if (!lblResult.getText().contains(".")) {
                    lblResult.setText(lblResult.getText() + ".");
                    operation += ".";
                }
                break;

            case "(-)":
                if (!error) {
                    double temp = Double.parseDouble(lblResult.getText());
                    temp *= -1;
                    lblResult.setText(String.valueOf(temp));
                    operation += "(-" + 1 + ")";
                }
                break;
        }
        lblOperation.setText(operation);
    }

    @FXML
    private void calculate(ActionEvent event) {
        if (!operator.equals("")) {
            if (lblResult.getText().equals("0") && operator.equals("/")) {
                lblResult.setText("ERROR");
                error = true;
                return;
            }
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
            operator = "";
            operation += " = " + String.valueOf(answer);
            lblOperation.setText(operation); 
        }
    }

    @FXML
    private void clearText(ActionEvent event) {
        lblResult.setText("");
        num1 = 0;
        num2 = 0;
        operator = "";
        error = false;
        operation = "";
        lblOperation.setText("");
    }

    @FXML
    private void deleteButton(ActionEvent event) {
        if (!error) {
            String text = lblResult.getText();
            if (text.length() > 0) {
                lblResult.setText(text.substring(0, text.length() - 1));
                operation = lblOperation.getText();
                operation = operation.substring(0, operation.length() - 1);
                lblOperation.setText(operation);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
