/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41381777
 */
@Entity
@Table(catalog = "", schema = "LP_4L12_02")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByAvaliacaoId", query = "SELECT a FROM Avaliacao a WHERE a.avaliacaoId = :avaliacaoId"),
    @NamedQuery(name = "Avaliacao.findByCliente", query = "SELECT a FROM Avaliacao a WHERE a.cliente = :cliente"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliacao.findByComentario", query = "SELECT a FROM Avaliacao a WHERE a.comentario = :comentario"),
    @NamedQuery(name = "Avaliacao.findByEmail", query = "SELECT a FROM Avaliacao a WHERE a.email = :email")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVALIACAO_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal avaliacaoId;
    @Size(max = 100)
    @Column(length = 100)
    private String cliente;
    @Column(precision = 2, scale = 2)
    private BigDecimal nota;
    @Size(max = 100)
    @Column(length = 100)
    private String comentario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(length = 100)
    private String email;
    @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "PRODUTO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoId;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Avaliacao() {
    }

    public Avaliacao(BigDecimal avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public BigDecimal getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(BigDecimal avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        hash += (avaliacaoId != null ? avaliacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.avaliacaoId == null && other.avaliacaoId != null) || (this.avaliacaoId != null && !this.avaliacaoId.equals(other.avaliacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Avaliacao[ avaliacaoId=" + avaliacaoId + " ]";
    }
    
}
