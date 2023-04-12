package br.com.blsoft.relatoriospdf;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.DocumentException;

import br.com.blsoft.relatoriospdf.relatorio.RelatorioPdfSimples;
import br.com.blsoft.relatoriospdf.vendas.Produto;
import br.com.blsoft.relatoriospdf.vendas.Venda;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {

        List<Produto> produtos = new ArrayList<>();

        Produto p1 = new Produto("Mouse", 2, 10.5);
        Produto p2 = new Produto("Teclado", 3, 22.9);

        Venda venda = new Venda("Paulo Inácio", produtos);

        venda.addValorCarrinho(p1);
        venda.addValorCarrinho(p2);

        RelatorioPdfSimples relatorio = new RelatorioPdfSimples(venda);
        relatorio.gerarCabecalho();
        relatorio.gerarCorpo();
        relatorio.gerarRodape();
        relatorio.imprimir();

    }
}
