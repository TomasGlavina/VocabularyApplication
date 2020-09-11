package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PracticeView {
    
    private Dictionary dictionary;
    private String word;
    
    public PracticeView(Dictionary dictionary){
        this.dictionary = dictionary;
        this.word = this.dictionary.getRandomWord();
    }
    
    public Parent getView(){
        GridPane layout =  new GridPane();
        
        Label text = new Label("Translate the word '" + this.word + "'");
        TextField input  = new TextField();
        Label feedback = new Label("");
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        Button check = new Button("Check");
        
        layout.add(text, 0, 0);
        layout.add(input, 0, 1);
        layout.add(check, 0, 2);
        layout.add(feedback, 0, 3);
        
        check.setOnMouseClicked((event) ->{
            String translation = input.getText();
            if(this.dictionary.get(this.word).equals(translation)){
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The correct translation of " + this.word + "is " + this.dictionary.get(this.word));
                
            }
            
            this.word = this.dictionary.getRandomWord();
            text.setText("Translate the word '" + this.word + "'");
            input.clear();
            
        });
        
        return layout;
        
    }
}
