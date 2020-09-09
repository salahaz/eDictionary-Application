/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.aui.sse.csc3327.eDictionary.models.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.SecureRandom;

/**
 *
 * @author salahazekour
 */
@Entity
@Table(name = "match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Match.findAll", query = "SELECT m FROM Match m")
    , @NamedQuery(name = "Match.findByMatchid", query = "SELECT m FROM Match m WHERE m.matchid = :matchid")
    , @NamedQuery(name = "Match.findByWord", query = "SELECT m FROM Match m WHERE m.word = :word")
    , @NamedQuery(name = "Match.findByDefinition", query = "SELECT m FROM Match m WHERE m.definition = :definition")
    , @NamedQuery(name = "Match.findByStrategy", query = "SELECT m FROM Match m WHERE m.strategy = :strategy")})
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matchid")
    private Integer matchid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "word")
    private String word;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "definition")
    private String definition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "strategy")
    private String strategy;

    public Match() {
    }

    public Match(Integer matchid) {
        this.matchid = matchid;
    }

    public Match(Integer matchid, String word, String definition, String strategy) {
        this.matchid = matchid;
        this.word = word;
        this.definition = definition;
        this.strategy = strategy;
    }
    
    public Match(String word, String definition, String strategy) {
        SecureRandom random = new SecureRandom();
        this.matchid = random.nextInt();
        this.word = word;
        this.definition = definition;
        this.strategy = strategy;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matchid != null ? matchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.matchid == null && other.matchid != null) || (this.matchid != null && !this.matchid.equals(other.matchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.aui.sse.csc3327.eDictionary.models.entities.Match[ matchid=" + matchid + " ]";
    }
    
}
