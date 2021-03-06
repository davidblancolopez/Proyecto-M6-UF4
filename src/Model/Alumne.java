
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="alumneCognom", query="SELECT p FROM alumnes p WHERE p.cognom=:cognom")})
@Table(name = "alumnes")
public class Alumne implements Serializable{
    
    @Id
    @Column(name = "idAlumne", unique = true, nullable = false)
    private String nif;
    
    @Column(name = "nom", length = 20, nullable = false)
    private String nom;
    
    @Column(name = "cognom", length = 50, nullable = false)
    private String cognom;
    
    @Column(name = "correu", length = 100)
    private String correu;
    
    @Column(name = "telefon", length = 11)
    private int telefon;
    
    @OneToOne(mappedBy = "")
    private Matricula idMatricula;

    public Alumne(String nif, String nom, String cognom, String correu, int telefon) {
        this.nif = nif;
        this.nom = nom;
        this.cognom = cognom;
        this.correu = correu;
        this.telefon = telefon;
    }

    public Alumne() {
    }
    



    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nif);
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
        final Alumne other = (Alumne) obj;
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumne{" + "nif=" + nif + ", nom=" + nom + ", cognom=" + cognom + ", correu=" + correu + ", telefon=" + telefon + ", idMatricula=" + idMatricula + '}';
    }

    
    
}
