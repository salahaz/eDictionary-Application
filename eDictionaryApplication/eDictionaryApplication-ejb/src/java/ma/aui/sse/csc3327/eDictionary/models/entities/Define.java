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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salahazekour
 */
@Entity
@Table(name = "define")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Define.findAll", query = "SELECT d FROM Define d")
    , @NamedQuery(name = "Define.findByWord", query = "SELECT d FROM Define d WHERE d.word = :word")
    , @NamedQuery(name = "Define.findByDefintion", query = "SELECT d FROM Define d WHERE d.defintion = :defintion")})
public class Define implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "word")
    private String word;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "defintion")
    private String defintion;

    public Define() {
    }

    public Define(String word) {
        this.word = word;
    }

    public Define(String word, String defintion) {
        this.word = word;
        this.defintion = defintion;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefintion() {
        return defintion;
    }

    public void setDefintion(String defintion) {
        this.defintion = defintion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (word != null ? word.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Define)) {
            return false;
        }
        Define other = (Define) object;
        if ((this.word == null && other.word != null) || (this.word != null && !this.word.equals(other.word))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.aui.sse.csc3327.eDictionary.models.entities.Define[ word=" + word + " ]";
    }
    
}
