/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 41381777
 */
@Entity
@Table(name = "LISTA_DE_COMPRA", catalog = "", schema = "LP_4L12_02")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaDeCompra.findAll", query = "SELECT l FROM ListaDeCompra l"),
    @NamedQuery(name = "ListaDeCompra.findByListaDeCompraId", query = "SELECT l FROM ListaDeCompra l WHERE l.listaDeCompraId = :listaDeCompraId")})
public class ListaDeCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LISTA_DE_COMPRA_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal listaDeCompraId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaDeCompraId")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public ListaDeCompra() {
    }

    public ListaDeCompra(BigDecimal listaDeCompraId) {
        this.listaDeCompraId = listaDeCompraId;
    }

    public BigDecimal getListaDeCompraId() {
        return listaDeCompraId;
    }

    public void setListaDeCompraId(BigDecimal listaDeCompraId) {
        this.listaDeCompraId = listaDeCompraId;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaDeCompraId != null ? listaDeCompraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaDeCompra)) {
            return false;
        }
        ListaDeCompra other = (ListaDeCompra) object;
        if ((this.listaDeCompraId == null && other.listaDeCompraId != null) || (this.listaDeCompraId != null && !this.listaDeCompraId.equals(other.listaDeCompraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ListaDeCompra[ listaDeCompraId=" + listaDeCompraId + " ]";
    }
    
}
