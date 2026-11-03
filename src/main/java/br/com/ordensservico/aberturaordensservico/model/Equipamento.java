package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Table(name = "equipamento")
@Entity 


public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeroPatrimonio;

    @NotNull(message = "Não pode ser vazio")
    @ManyToOne 
    @JoinColumn(name = "setor_id", nullable = false)
    private Setor setor;
    
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    public Equipamento() {
    }

    public Integer getId() {
       return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public Setor getSetor() {
        return setor;
    }

public  void setSetor(Setor setor) {
    this.setor = setor;}

   
    
}


