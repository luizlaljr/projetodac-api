package br.uff.id.ProjetoDAC_Api.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{
    
    @Id
    @SequenceGenerator(
            name = "seq_recurso", 
            sequenceName = "seq_recurso_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Length(max = 1024, message = "O titulo não pode ter mais de {max} caracteres")
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O titulo deve ser informado")
    @Column(name = "titulo", nullable = false, length = 1024)
    private String titulo;
    
    @Length(max = 4096, message = "A descricao não pode ter mais de {max} caracteres")
    @NotNull(message = "A descricao não pode ser nula")
    @NotBlank(message = "A descricao deve ser informada")
    @Column(name = "descricao", nullable = false, length = 4096)
    private String descricao;
    
    @URL(message = "O link deve ser informadao")
    @NotNull(message = "O link não pode ser nulo")
    @NotBlank(message = "O link deve ser informado")
    @Column(name = "link", nullable = false)
    private String link;
    
    @Lob
    @Column(name = "imagem", nullable = true)
    private byte[] imagem;
    
    @NotNull(message = "A data de criação não pode ser nula")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "criacao", nullable = false)
    private Calendar criacao;
    
    @NotNull(message = "A data de registro não pode ser nula")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "registro", nullable = false)
    private Calendar registro;
    
    @NotNull(message = "Palavras não podem ser nulas")
    @NotBlank(message = "As palavras devem ser informadas")
    @Column(name = "palavras", nullable = false, length = 4096)
    private String palavras;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name="autor_recurso",
      joinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_autor_id")), 
      inverseJoinColumns = @JoinColumn(name = "recurso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_recurso_id")))
    private Set<Autor> autores;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name="colecao_recursos",
             joinColumns = @JoinColumn(name = "recursos_id", insertable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_recursos_id")),
             inverseJoinColumns= @JoinColumn(name = "colecao_id", insertable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_colecao_id")))
    @OrderBy("titulo ASC")
    private Colecao colecao;
    
    public Recurso() {
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    /**
     * @return the imagem
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the criacao
     */
    public Calendar getCriacao() {
        return criacao;
    }

    /**
     * @param criacao the criacao to set
     */
    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    /**
     * @return the registro
     */
    public Calendar getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }
    
    /**
     * @return the palavras
     */
    public String getPalavras() {
        return palavras;
    }

    /**
     * @param palavras the palavras to set
     */
    public void setPalavras(String palavras) {
        this.palavras = palavras;
    }
    
    /**
     * @return the autores
     */
    public Set<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
    
    /**
     * @return the colecao
     */
    public Colecao getColecao() {
        return colecao;
    }
    
    /**
     * @param colecao the colecao to set
     */
    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    @Override
    public String toString() {
        return "Recurso{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", link=" + link + ", imagem=" + imagem + ", criacao=" + criacao + ", registro=" + registro + ", palavras=" + palavras + ", autores=" + autores + ", colecao=" + colecao + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
