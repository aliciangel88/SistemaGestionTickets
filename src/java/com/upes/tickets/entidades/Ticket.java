/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upes.tickets.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alici
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id")
    , @NamedQuery(name = "Ticket.findByTitulo", query = "SELECT t FROM Ticket t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "Ticket.findByFechaActualizacion", query = "SELECT t FROM Ticket t WHERE t.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Ticket.findByFechaCreacion", query = "SELECT t FROM Ticket t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Ticket.findByAsignadoId", query = "SELECT t FROM Ticket t WHERE t.asignadoId = :asignadoId")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "titulo", length = 100)
    private String titulo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "asignado_id")
    private Integer asignadoId;
    @JoinColumn(name = "prioridad_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Prioridad prioridadId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "tipo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tipo tipoId;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoriaId;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id")
    @ManyToOne
    private Proyecto proyectoId;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getAsignadoId() {
        return asignadoId;
    }

    public void setAsignadoId(Integer asignadoId) {
        this.asignadoId = asignadoId;
    }

    public Prioridad getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Prioridad prioridadId) {
        this.prioridadId = prioridadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tipo getTipoId() {
        return tipoId;
    }

    public void setTipoId(Tipo tipoId) {
        this.tipoId = tipoId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Proyecto getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Proyecto proyectoId) {
        this.proyectoId = proyectoId;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.upes.tickets.entidades.Ticket[ id=" + id + " ]";
    }
    
}
