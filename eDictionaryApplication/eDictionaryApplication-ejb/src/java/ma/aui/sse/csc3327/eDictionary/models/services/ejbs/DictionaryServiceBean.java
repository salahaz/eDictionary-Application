/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.csc3327.eDictionary.models.services.ejbs;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.aui.sse.csc3327.eDictionary.models.entities.Define;
import ma.aui.sse.csc3327.eDictionary.models.entities.Match;
import ma.aui.sse.csc3327.eDictionary.models.services.pojos.DictionaryServiceImpl;

/**
 *
 * @author salahazekour
 */
@Singleton
public class DictionaryServiceBean extends DictionaryServiceImpl implements DictionaryServiceBeanLocal {
    
    /*@PersistenceContext
    EntityManager em;*/
    
    
    @Override
    public String define(String word) {
        String definitions = super.define(word);
        Define define = new Define(word);
        /*em.persist(define);*/
        
        return definitions;
    }
    
    @Override
    @RolesAllowed(value=("VIPUser"))
    public String match(String word, String strategy) {
        String definitions = super.match(word, strategy);
        Match match = new Match(word, definitions, strategy);
        /*em.persist(match);*/
        
        return definitions;
    }
}
