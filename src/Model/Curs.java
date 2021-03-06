
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name = "cercaModulCurs", query = "SELECT c FROM Modul c WHERE c.curs.id=:id"),
@NamedQuery(name = "cercaUFCurs", query = "SELECT c FROM UnitatFormativa c WHERE c.curs.id=:id")})
@Table(name = "curs")
public class Curs {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurs", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nomCurs", length = 5)
    private String nom;
    
    @OneToMany(mappedBy = "curs")
    private List<UnitatFormativa> listaUF;
    
    @ManyToOne
    @JoinColumn(name = "idCicle")
    private Cicle cicle;
    
    @OneToMany (mappedBy = "curs")
    private List<Modul> llistaModuls;

    public Curs(Long id, String nom, Cicle cicle) {
        this.id = id;
        this.nom = nom;
        this.cicle = cicle;
    }

    public Curs() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<UnitatFormativa> getListaUF() {
        return listaUF;
    }

    public void setListaUF(List<UnitatFormativa> listaUF) {
        this.listaUF = listaUF;
    }

    public Cicle getCicle() {
        return cicle;
    }

    public void setCicle(Cicle cicle) {
        this.cicle = cicle;
    }

    public List<Modul> getLlistaModuls() {
        return llistaModuls;
    }

    public void setLlistaModuls(List<Modul> llistaModuls) {
        this.llistaModuls = llistaModuls;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curs other = (Curs) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curs{" + "id=" + id + ", nom=" + nom + ", listaUF=" + listaUF + ", cicle=" + cicle + ", llistaModuls=" + llistaModuls + '}';
    }


    
}
