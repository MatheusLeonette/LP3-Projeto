package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
@Entity
public class Usuario implements Serializable{
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal usuarioId;
    @Size(max = 100)
    @Column(length = 100)
    private String nome;
    @Size(max = 100)
    @Column(length = 100)
    private String cpf;
    @Size(max = 100)
    @Column(length = 100)
    private String cidade;
    @Size(max = 100)
    @Column(length = 100)
    private String estado;
    @Size(max = 100)
    @Column(length = 100)
    private String cep;
    @Size(max = 15)
    @Column(name = "TELEFONE_RESIDENCIAL", length = 15)
    private String telefoneResidencial;
    @Size(max = 15)
    @Column(name = "TELEFONE_COMERCIA", length = 15)
    private String telefoneComercia;
    @Size(max = 15)
    @Column(name = "TELEFONE_MOVEL", length = 15)
    private String telefoneMovel;
    @Size(max = 20)
    @Column(length = 20)
    private String senha;
    @Size(max = 100)
    @Column(length = 100)
    private String endereco;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(length = 100)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Avaliacao> avaliacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<ListaDeCompra> listaDeCompraCollection;
    

    public Usuario(){};

    public Usuario(BigDecimal usuarioId, String nome, String cpf, String cidade, String estado, String cep, String telefoneResidencial, String telefoneComercia, String telefoneMovel, String senha, String endereco, String email, Collection<Avaliacao> avaliacaoCollection, Collection<ListaDeCompra> listaDeCompraCollection) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercia = telefoneComercia;
        this.telefoneMovel = telefoneMovel;
        this.senha = senha;
        this.endereco = endereco;
        this.email = email;
        this.avaliacaoCollection = avaliacaoCollection;
        this.listaDeCompraCollection = listaDeCompraCollection;
    }

    public BigDecimal getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigDecimal usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercia() {
        return telefoneComercia;
    }

    public void setTelefoneComercia(String telefoneComercia) {
        this.telefoneComercia = telefoneComercia;
    }

    public String getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @XmlTransient
    public Collection<ListaDeCompra> getListaDeCompraCollection() {
        return listaDeCompraCollection;
    }

    public void setListaDeCompraCollection(Collection<ListaDeCompra> listaDeCompraCollection) {
        this.listaDeCompraCollection = listaDeCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
    
}
