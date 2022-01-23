package br.uff.id.ProjetoDAC_Api.model;

import java.io.Serializable;;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;


/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "colecao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Colecao implements Serializable {
    @Id
    @SequenceGenerator(
            name = "seq_colecao", 
            sequenceName = "seq_colecao_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_colecao", strategy = GenerationType.SEQUENCE)
    private long id;
    
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
    
    @Lob
    @Column(name = "imagem", nullable = true)
    private byte[] imagem;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name="colecao_recursos",
             joinColumns = @JoinColumn(name = "colecao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_colecao_id")),
             inverseJoinColumns= @JoinColumn(name = "recursos_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_recursos_id")))
    @OrderBy("titulo ASC")
    private Set<Recurso> recursos;
    
    public Colecao() {
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
     * @return the recursos
     */
    public Set<Recurso> getRecurso() {
        return recursos;
    }
    
    /**
     * @param recursos the recursos to set
     */
    public void setRecurso(Set<Recurso> recursos) {
        this.recursos = recursos;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", imagem=" + imagem + ", recursos=" + recursos;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Colecao other = (Colecao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
