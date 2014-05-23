/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arthurfernandes
 */
@Entity
@Table(name = "aeroporto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeroporto.findAll", query = "SELECT a FROM Aeroporto a"),
    @NamedQuery(name = "Aeroporto.findByAeroportoSigla", query = "SELECT a FROM Aeroporto a WHERE a.aeroportoSigla = :aeroportoSigla"),
    @NamedQuery(name = "Aeroporto.findByAeroportoNome", query = "SELECT a FROM Aeroporto a WHERE a.aeroportoNome = :aeroportoNome")})
public class Aeroporto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aeroportoSigla")
    private String aeroportoSigla;
    @Basic(optional = false)
    @Column(name = "aeroportoNome")
    private String aeroportoNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeroporto")
    private Collection<Trecho> trechoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeroporto1")
    private Collection<Trecho> trechoCollection1;

    public Aeroporto() {
    }

    public Aeroporto(String aeroportoSigla) {
        this.aeroportoSigla = aeroportoSigla;
    }

    public Aeroporto(String aeroportoSigla, String aeroportoNome) {
        this.aeroportoSigla = aeroportoSigla;
        this.aeroportoNome = aeroportoNome;
    }

    public String getAeroportoSigla() {
        return aeroportoSigla;
    }

    public void setAeroportoSigla(String aeroportoSigla) {
        this.aeroportoSigla = aeroportoSigla;
    }

    public String getAeroportoNome() {
        return aeroportoNome;
    }

    public void setAeroportoNome(String aeroportoNome) {
        this.aeroportoNome = aeroportoNome;
    }

    @XmlTransient
    public Collection<Trecho> getTrechoCollection() {
        return trechoCollection;
    }

    public void setTrechoCollection(Collection<Trecho> trechoCollection) {
        this.trechoCollection = trechoCollection;
    }

    @XmlTransient
    public Collection<Trecho> getTrechoCollection1() {
        return trechoCollection1;
    }

    public void setTrechoCollection1(Collection<Trecho> trechoCollection1) {
        this.trechoCollection1 = trechoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeroportoSigla != null ? aeroportoSigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeroporto)) {
            return false;
        }
        Aeroporto other = (Aeroporto) object;
        if ((this.aeroportoSigla == null && other.aeroportoSigla != null) || (this.aeroportoSigla != null && !this.aeroportoSigla.equals(other.aeroportoSigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.eb.ime.labprog3.tam.Aeroporto[ aeroportoSigla=" + aeroportoSigla + " ]";
    }
    
}
