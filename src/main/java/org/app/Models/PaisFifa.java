package org.app.Models;

public class PaisFifa {
    private String _pais;
    private String _conferacao;
    private double _percentualPopulacao;
    private double _percentualAudiencia;
    private double _participacaoPIB;

    public PaisFifa(String pais, String conferecao, double percentualPopulacao, double percentualAudiencia, double participacaoPIB){
        this._pais = pais;
        this._percentualAudiencia = percentualAudiencia;
        this._percentualPopulacao = percentualPopulacao;
        this._participacaoPIB = participacaoPIB;
        this._conferacao = conferecao;
    }

    public String get_pais() {
        return _pais;
    }

    public void set_pais(String _pais) {
        this._pais = _pais;
    }

    public String get_conferacao() {
        return _conferacao;
    }

    public void set_conferacao(String _conferacao) {
        this._conferacao = _conferacao;
    }

    public double get_percentualPopulacao() {
        return _percentualPopulacao;
    }

    public void set_percentualPopulacao(double _percentualPopulacao) {
        this._percentualPopulacao = _percentualPopulacao;
    }

    public double get_participacaoPIB() {
        return _participacaoPIB;
    }

    public void set_participacaoPIB(double _participacaoPIB) {
        this._participacaoPIB = _participacaoPIB;
    }

    public double get_percentualAudiencia() {
        return _percentualAudiencia;
    }

    public void set_percentualAudiencia(double _percentualAudiencia) {
        this._percentualAudiencia = _percentualAudiencia;
    }

    @Override
    public String toString(){
        return "País: " + this._pais + ", Confederação: " + this._conferacao + ", Participação PIB: " + this._participacaoPIB + ", Percentual audiência: " + this._percentualAudiencia +  ", Percentual população: " + this._percentualPopulacao;
    }
}
