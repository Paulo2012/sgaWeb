/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos.dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iron
 */
@Entity
@Table(name = "domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
    , @NamedQuery(name = "Domicilio.findByIdDomicilio", query = "SELECT d FROM Domicilio d WHERE d.idDomicilio = :idDomicilio")
    , @NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle")
    , @NamedQuery(name = "Domicilio.findByNoExterno", query = "SELECT d FROM Domicilio d WHERE d.noExterno = :noExterno")
    , @NamedQuery(name = "Domicilio.findByNoInterno", query = "SELECT d FROM Domicilio d WHERE d.noInterno = :noInterno")
    , @NamedQuery(name = "Domicilio.findByCp", query = "SELECT d FROM Domicilio d WHERE d.cp = :cp")
    , @NamedQuery(name = "Domicilio.findByMunicipio", query = "SELECT d FROM Domicilio d WHERE d.municipio = :municipio")
    , @NamedQuery(name = "Domicilio.findByEstado", query = "SELECT d FROM Domicilio d WHERE d.estado = :estado")
    , @NamedQuery(name = "Domicilio.findByPais", query = "SELECT d FROM Domicilio d WHERE d.pais = :pais")
    , @NamedQuery(name = "Domicilio.findByVersion", query = "SELECT d FROM Domicilio d WHERE d.version = :version")
    , @NamedQuery(name = "Domicilio.findByDeleted", query = "SELECT d FROM Domicilio d WHERE d.deleted = :deleted")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle")
    private String calle;
    @Size(max = 45)
    @Column(name = "no_externo")
    private String noExterno;
    @Size(max = 45)
    @Column(name = "no_interno")
    private String noInterno;
    @Column(name = "cp")
    private Integer cp;
    @Size(max = 45)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @Column(name = "version")
    private Integer version;
    @Column(name = "deleted")
    private Integer deleted;
    @OneToMany(mappedBy = "idDomicilio")
    private Collection<Instructor> instructorCollection;
    @OneToMany(mappedBy = "idDomicilio")
    private Collection<Alumno> alumnoCollection;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(Integer idDomicilio, String calle) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterno() {
        return noExterno;
    }

    public void setNoExterno(String noExterno) {
        this.noExterno = noExterno;
    }

    public String getNoInterno() {
        return noInterno;
    }

    public void setNoInterno(String noInterno) {
        this.noInterno = noInterno;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capaDatos.dominio.Domicilio[ idDomicilio=" + idDomicilio + " ]";
    }
    
}
