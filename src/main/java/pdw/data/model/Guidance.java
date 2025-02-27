/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdw.data.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandrelerario
 */
@Entity
@Table(name = "swguidance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guidance.findAll", query = "SELECT g FROM Guidance g"),
    @NamedQuery(name = "Guidance.findById", query = "SELECT g FROM Guidance g WHERE g.id = :id"),
    @NamedQuery(name = "Guidance.findByName", query = "SELECT g FROM Guidance g WHERE g.name = :name"),
    @NamedQuery(name = "Guidance.findByDescription", query = "SELECT g FROM Guidance g WHERE g.description = :description")})
public class Guidance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 400)
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "guidefile")
    private byte[] guidefile;
    @OneToMany(mappedBy = "swguidance")
    private Collection<Arctifact> arctifactCollection;
    @OneToMany(mappedBy = "swguidance")
    private Collection<Activity> activityCollection;

    public Guidance() {
    }

    public Guidance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getGuidefile() {
        return guidefile;
    }

    public void setGuidefile(byte[] guidefile) {
        this.guidefile = guidefile;
    }

    @XmlTransient
    public Collection<Arctifact> getArctifactCollection() {
        return arctifactCollection;
    }

    public void setArctifactCollection(Collection<Arctifact> arctifactCollection) {
        this.arctifactCollection = arctifactCollection;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guidance)) {
            return false;
        }
        Guidance other = (Guidance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pdw.data.model.Guidance[ id=" + id + " ]";
    }
    
}
