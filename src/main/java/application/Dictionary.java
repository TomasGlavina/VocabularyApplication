package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Dictionary {
    private List<String> list;
    private Map<String, String> dictionary;
    
    public Dictionary(){
        this.dictionary = new HashMap<>();
        this.list = new ArrayList<>();              
        
        add("sana", "word");

    }
    
    public String get(String word){
        return this.dictionary.get(word);
    }
    
    public void add(String word, String translation){
        if(!this.list.contains(word)){
            this.list.add(word);
        }
        
        this.dictionary.put(word, translation);
    }
    
    public String getRandomWord(){
        Random r = new Random();
        
        return this.list.get(r.nextInt(this.list.size()));
    }
    
}
