package br.com.lojavirtual.beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "servico")
public class Servico implements Serializable {

    private Long ID;

    private int id;
    private String nome;
    private String descricao;
    private String und;
    private float valor;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ser_id")
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ser_nome", length = 20, nullable = true)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "ser_descricao", length = 60, nullable = true)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "ser_und", length = 60, nullable = true)
    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    @Column(name = "ser_valor", nullable = true)
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Id
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
