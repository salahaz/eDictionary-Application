/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.csc3327.eDictionary.models.services.pojos;

import com.aonaware.services.webservices.ArrayOfDictionaryWord;
import com.aonaware.services.webservices.DictService;
import com.aonaware.services.webservices.DictServiceSoap;
import com.aonaware.services.webservices.WordDefinition;
import ma.aui.sse.csc3327.eDictionary.models.entities.Define;
import ma.aui.sse.csc3327.eDictionary.models.entities.Match;


/**
 *
 * @author salahazekour
 */
public class DictionaryServiceImpl implements DictionaryService {

    StringBuilder finalDefinitions;
    DictService dictionaryService = new DictService();
    DictServiceSoap port = dictionaryService.getDictServiceSoap();

    public String define(String word) {
        
        StringBuilder finalDefinitions = new StringBuilder(" ");
        
        try {
            DictService dictionaryService = new DictService();
            DictServiceSoap port = dictionaryService.getDictServiceSoap();
            WordDefinition result = port.define(word);

            for (int i = 0; i < result.getDefinitions().getDefinition().size(); i++) {
                finalDefinitions.append(result.getDefinitions().getDefinition().get(i).getWordDefinition());
                finalDefinitions.append(System.getProperty("line.separator"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return finalDefinitions.toString();

    }

    public String match(String word, String strategy) {
        StringBuilder finalDefinitions = new StringBuilder("\n");
        
        try {
            
            DictService dictionaryService = new DictService();
            DictServiceSoap port = dictionaryService.getDictServiceSoap();
            ArrayOfDictionaryWord result = port.match(word, strategy);
            
            for (int i = 0; i < result.getDictionaryWord().size(); i++) {
                finalDefinitions.append(result.getDictionaryWord().get(i).getWord());
                finalDefinitions.append(System.getProperty("line.separator"));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return finalDefinitions.toString();

    }
}
