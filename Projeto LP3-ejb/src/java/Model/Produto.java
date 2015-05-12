/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByProdutoId", query = "SELECT p FROM Produto p WHERE p.produtoId = :produtoId"),
    @NamedQuery(name = "Produto.findByFoto", query = "SELECT p FROM Produto p WHERE p.foto = :foto"),
    @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByInformacoesTecnicas", query = "SELECT p FROM Produto p WHERE p.informacoesTecnicas = :informacoesTecnicas")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUTO_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal produtoId;
    @Size(max = 100)
    @Column(length = 100)
    private String foto;
    @Column(precision = 15, scale = 2)
    private BigDecimal preco;
    @Size(max = 100)
    @Column(length = 100)
    private String descricao;
    @Size(max = 100)
    @Column(name = "INFORMACOES_TECNICAS", length = 100)
    private String informacoesTecnicas;
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "CATEGORIA_ID", nullable = false)
    @ManyToOne(optional = false)
    private Categoria categoriaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Avaliacao> avaliacaoCollection;

    public Produto() {
    }

    public Produto(BigDecimal produtoId) {
        this.produtoId = produtoId;
    }

    public BigDecimal getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(BigDecimal produtoId) {
        this.produtoId = produtoId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInformacoesTecnicas() {
        return informacoesTecnicas;
    }

    public void setInformacoesTecnicas(String informacoesTecnicas) {
        this.informacoesTecnicas = informacoesTecnicas;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoId != null ? produtoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produtoId == null && other.produtoId != null) || (this.produtoId != null && !this.produtoId.equals(other.produtoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Produto[ produtoId=" + produtoId + " ]";
    }
    
}
