package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;



@Table(name = "equipamento")
@Entity 


public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    public Equipamento() {

    }

    public Equipamento(String nome) {
     this.nome = nome;
    }

    public int getId() {
       return id;
    }

    public String geNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
