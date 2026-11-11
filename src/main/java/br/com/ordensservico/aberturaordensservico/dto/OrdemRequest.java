package br.com.ordensservico.aberturaordensservico.dto;


public class OrdemRequest {
    
    private String descricao;
    private Integer equipamentoId;

  
    public OrdemRequest() {
    }

    public OrdemRequest(String descricao, Integer equipamentoId) {
        this.descricao = descricao;
        this.equipamentoId = equipamentoId;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }
}
