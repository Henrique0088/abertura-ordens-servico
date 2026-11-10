package br.com.ordensservico.aberturaordensservico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipamentoRequest {

    private  String nome;
    private String numeroPatrimonio;
    private Integer setorId;

    public EquipamentoRequest() {
    }

    @NotBlank(message = "O nome é obrigatório")
    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    @NotBlank (message = "O numero é obrigatorio")
    public String getNumeroPatrimonio (){
        return numeroPatrimonio;
    }

    public  void numeroPatrimonio (String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    @NotNull (message = "Setor não existia")
    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }
}