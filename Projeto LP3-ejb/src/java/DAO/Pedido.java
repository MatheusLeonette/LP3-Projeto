/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 41381777
 */
@Entity
@Table(catalog = "", schema = "LP_4L12_02")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByPedidoId", query = "SELECT p FROM Pedido p WHERE p.pedidoId = :pedidoId"),
    @NamedQuery(name = "Pedido.findByStatus", query = "SELECT p FROM Pedido p WHERE p.status = :status"),
    @NamedQuery(name = "Pedido.findByIdentificador", query = "SELECT p FROM Pedido p WHERE p.identificador = :identificador"),
    @NamedQuery(name = "Pedido.findByPrecoTotal", query = "SELECT p FROM Pedido p WHERE p.precoTotal = :precoTotal"),
    @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pedido.findByDataDoPedido", query = "SELECT p FROM Pedido p WHERE p.dataDoPedido = :dataDoPedido"),
    @NamedQuery(name = "Pedido.findByDataDeEntrega", query = "SELECT p FROM Pedido p WHERE p.dataDeEntrega = :dataDeEntrega")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDIDO_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal pedidoId;
    private BigInteger status;
    @Size(max = 20)
    @Column(length = 20)
    private String identificador;
    @Column(name = "PRECO_TOTAL", precision = 15, scale = 2)
    private BigDecimal precoTotal;
    @Size(max = 20)
    @Column(length = 20)
    private String numero;
    @Size(max = 8)
    @Column(name = "DATA_DO_PEDIDO", length = 8)
    private String dataDoPedido;
    @Size(max = 8)
    @Column(name = "DATA_DE_ENTREGA", length = 8)
    private String dataDeEntrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId")
    private Collection<Pagamento> pagamentoCollection;
    @JoinColumn(name = "LISTA_DE_COMPRA_ID", referencedColumnName = "LISTA_DE_COMPRA_ID", nullable = false)
    @ManyToOne(optional = false)
    private ListaDeCompra listaDeCompraId;

    public Pedido() {
    }

    public Pedido(BigDecimal pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(BigDecimal pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(String dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    public ListaDeCompra getListaDeCompraId() {
        return listaDeCompraId;
    }

    public void setListaDeCompraId(ListaDeCompra listaDeCompraId) {
        this.listaDeCompraId = listaDeCompraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoId != null ? pedidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoId == null && other.pedidoId != null) || (this.pedidoId != null && !this.pedidoId.equals(other.pedidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Pedido[ pedidoId=" + pedidoId + " ]";
    }
    
}
