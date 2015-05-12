/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41381777
 */
@Entity
@Table(catalog = "", schema = "LP_4L12_02")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByPagamentoId", query = "SELECT p FROM Pagamento p WHERE p.pagamentoId = :pagamentoId"),
    @NamedQuery(name = "Pagamento.findByStatus", query = "SELECT p FROM Pagamento p WHERE p.status = :status"),
    @NamedQuery(name = "Pagamento.findByValorPago", query = "SELECT p FROM Pagamento p WHERE p.valorPago = :valorPago"),
    @NamedQuery(name = "Pagamento.findByValorPendente", query = "SELECT p FROM Pagamento p WHERE p.valorPendente = :valorPendente")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGAMENTO_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal pagamentoId;
    private BigInteger status;
    @Column(name = "VALOR_PAGO", precision = 15, scale = 2)
    private BigDecimal valorPago;
    @Column(name = "VALOR_PENDENTE", precision = 15, scale = 2)
    private BigDecimal valorPendente;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "PEDIDO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Pedido pedidoId;

    public Pagamento() {
    }

    public Pagamento(BigDecimal pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public BigDecimal getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(BigDecimal pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorPendente() {
        return valorPendente;
    }

    public void setValorPendente(BigDecimal valorPendente) {
        this.valorPendente = valorPendente;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoId != null ? pagamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.pagamentoId == null && other.pagamentoId != null) || (this.pagamentoId != null && !this.pagamentoId.equals(other.pagamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Pagamento[ pagamentoId=" + pagamentoId + " ]";
    }
    
}
