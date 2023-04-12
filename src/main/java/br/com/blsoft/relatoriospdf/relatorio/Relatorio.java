package br.com.blsoft.relatoriospdf.relatorio;

public interface Relatorio {
    public void gerarCabecalho();

    public void gerarCorpo();

    public void gerarRodape();

    public void imprimir();

}
