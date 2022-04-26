/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
public class Competitor {

    /**
     *
     */
    @Entity
    @Table(name = "competitor")
    @XmlRootElement
    @NamedQueries({
        @NamedQuery(name = "Competitor.findAll", query = "SELECT c FROM Competitor c"),
        @NamedQuery(name = "Competitor.findByIdCompetitor", query = "SELECT c FROM Competitor c WHERE c.idCompetitor = :idCompetitor"),
        @NamedQuery(name = "Competitor.findByCreatedAt", query = "SELECT c FROM Competitor c WHERE c.createdAt = :createdAt"),
        @NamedQuery(name = "Competitor.findByUpdatedAt", query = "SELECT c FROM Competitor c WHERE c.updatedAt = :updatedAt"),
        @NamedQuery(name = "Competitor.findByName", query = "SELECT c FROM Competitor c WHERE c.name = :name"),
        @NamedQuery(name = "Competitor.findBySurname", query = "SELECT c FROM Competitor c WHERE c.surname = :surname"),
        @NamedQuery(name = "Competitor.findByAge", query = "SELECT c FROM Competitor c WHERE c.age = :age"),
        @NamedQuery(name = "Competitor.findByTelephone", query = "SELECT c FROM Competitor c WHERE c.telephone = :telephone"),
        @NamedQuery(name = "Competitor.findByCellphone", query = "SELECT c FROM Competitor c WHERE c.cellphone = :cellphone"),
        @NamedQuery(name = "Competitor.findByAddress", query = "SELECT c FROM Competitor c WHERE c.address = :address"),
        @NamedQuery(name = "Competitor.findByCity", query = "SELECT c FROM Competitor c WHERE c.city = :city"),
        @NamedQuery(name = "Competitor.findByCountry", query = "SELECT c FROM Competitor c WHERE c.country = :country"),
        @NamedQuery(name = "Competitor.findByWinner", query = "SELECT c FROM Competitor c WHERE c.winner = :winner")})
    public class Competitor implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "idCompetitor")
        private Integer idCompetitor;
        @Basic(optional = false)
        @Column(name = "createdAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdAt;
        @Basic(optional = false)
        @Column(name = "updatedAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date updatedAt;
        @Column(name = "name")
        private String name;
        @Column(name = "surname")
        private String surname;
        @Column(name = "age")
        private Integer age;
        @Column(name = "telephone")
        private String telephone;
        @Column(name = "cellphone")
        private String cellphone;
        @Column(name = "address")
        private String address;
        @Column(name = "city")
        private String city;
        @Column(name = "country")
        private String country;
        @Column(name = "winner")
        private Short winner;

        public Competitor() {
        }

        public Competitor(String name, String surname, Integer age, String telephone, String cellphone, String address, String city, String country, Short winner) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.telephone = telephone;
            this.cellphone = cellphone;
            this.address = address;
            this.city = city;
            this.country = country;
            this.winner = winner;
        }

        public Competitor(Integer idCompetitor) {
            this.idCompetitor = idCompetitor;
        }

        public Competitor(Integer idCompetitor, Date createdAt, Date updatedAt) {
            this.idCompetitor = idCompetitor;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        @PreUpdate
        private void updateTimestamp() {
            this.updatedAt = new Date();
        }

        @PrePersist
        private void creationTimestamp() {
            this.createdAt = this.updatedAt = new Date();
        }

        public Integer getIdCompetitor() {
            return idCompetitor;
        }

        public void setIdCompetitor(Integer idCompetitor) {
            this.idCompetitor = idCompetitor;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getCellphone() {
            return cellphone;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Short getWinner() {
            return winner;
        }

        public void setWinner(Short winner) {
            this.winner = winner;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (idCompetitor != null ? idCompetitor.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Competitor)) {
                return false;
            }
            Competitor other = (Competitor) object;
            if ((this.idCompetitor == null && other.idCompetitor != null) || (this.idCompetitor != null && !this.idCompetitor.equals(other.idCompetitor))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "com.example.models.Competitor[ idCompetitor=" + idCompetitor + " ]" + name + " " + surname;
        }
    }
}
