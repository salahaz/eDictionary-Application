/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.csc3327.eDictionary.controllers.wc;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import ma.aui.sse.csc3327.eDictionary.models.services.ejbs.DictionaryServiceBeanLocal;

/**
 *
 * @author salahazekour
 */
@Named(value="dictionaryController")
@SessionScoped
public class DictionaryController implements Serializable {


    /**
     * Creates a new instance of DictionaryController
     */
    
    private String word; 
    private String result;
    private String strategy; 
    
    @EJB
    private DictionaryServiceBeanLocal dictionaryServiceProxy;
    
    public DictionaryController() {
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the strategy
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    
    public String define(){
        result = dictionaryServiceProxy.define(word);
        return "result";
    }
    
    public String match(){
        result = dictionaryServiceProxy.match(word, strategy);
        return "result";
    }
}