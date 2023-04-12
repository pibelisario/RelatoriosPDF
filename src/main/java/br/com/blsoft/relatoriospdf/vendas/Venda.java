package br.com.blsoft.relatoriospdf.vendas;

import java.time.LocalDate;
import java.util.List;

public class Venda {

    private LocalDate dataVenda;
    private String nomeCliente;
    private List<Produto> produtosVendidos;

    public Venda(String nomeCliente, List<Produto> produtosVendidos) {
        this.dataVenda = LocalDate.now();
        this.nomeCliente = nomeCliente;
        this.produtosVendidos = produtosVendidos;
    }

    public Double calcularValorTotalCarrinho() {
        double total = 0;
        for (Produto produto : produtosVendidos) {
            total += produto.valorTotal();
        }
        return total;
    }

    public void addValorCarrinho(Produto produto) {
        produtosVendidos.add(produto);
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

}
