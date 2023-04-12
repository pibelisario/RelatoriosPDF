package br.com.blsoft.relatoriospdf.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.com.blsoft.relatoriospdf.vendas.Produto;
import br.com.blsoft.relatoriospdf.vendas.Venda;

public class RelatorioPdfSimples implements Relatorio {

    private Venda venda;
    private Document documentoPdf;
    private String caminhoRelatorio = "RelatorioSimples.pdf";

    public RelatorioPdfSimples(Venda venda) throws DocumentException, FileNotFoundException {
        this.venda = venda;
        this.documentoPdf = new Document();
        PdfWriter.getInstance(documentoPdf, new FileOutputStream(caminhoRelatorio));
        this.documentoPdf.open();
    }

    @Override
    public void gerarCabecalho() {
        Paragraph paragraphTitulo = new Paragraph();
        paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
        paragraphTitulo.add(new Chunk(
                "Relatório de Vendas Simples",
                new Font(Font.HELVETICA, 24)));
        this.documentoPdf.add(paragraphTitulo);
        this.documentoPdf.add(new Paragraph(" "));

        Paragraph paragraphData = new Paragraph();
        paragraphData.setAlignment(Element.ALIGN_CENTER);
        paragraphData.add(new Chunk(this.venda.getDataVenda().toString()));
        this.documentoPdf.add(paragraphData);
        this.documentoPdf.add(new Paragraph(" "));
        this.documentoPdf.add(new Paragraph(" "));

        Paragraph paragraphCliente = new Paragraph();
        paragraphCliente.add(
                new Chunk("Cliente: " + this.venda.getNomeCliente(), new Font(Font.BOLD, 16)));
        paragraphCliente.setAlignment(Element.ALIGN_CENTER);

        this.documentoPdf.add(paragraphCliente);

        Paragraph paragraphSessao = new Paragraph("----------------------------------------------------------------");
        paragraphSessao.setAlignment(Element.ALIGN_CENTER);
        this.documentoPdf.add(paragraphSessao);
        this.documentoPdf.add(new Paragraph(" "));

    }

    @Override
    public void gerarCorpo() {
        Paragraph paragraphItensVendidos = new Paragraph();
        paragraphItensVendidos.setAlignment(Element.ALIGN_CENTER);
        paragraphItensVendidos.add(new Chunk("Itens Vendidos", new Font(Font.TIMES_ROMAN, 16)));
        documentoPdf.add(new Paragraph(paragraphItensVendidos));

        for (Produto produto : this.venda.getProdutosVendidos()) {

            Paragraph paragraphNomeProduto = new Paragraph();
            paragraphNomeProduto.add(new Chunk(produto.getNome(), new Font(Font.COURIER, 20)));

            Paragraph paragraphProduto = new Paragraph();

            paragraphProduto.setAlignment(Element.ALIGN_LEFT);
            paragraphProduto.add(new Paragraph("Valor: " + produto.getValor()
                    + " - Qtd: " + produto.getQuantidade() + " - Total: " + produto.valorTotal()));
            paragraphProduto.add(new Paragraph(" "));
            this.documentoPdf.add(paragraphNomeProduto);
            this.documentoPdf.add(paragraphProduto);
            this.documentoPdf.add(new Paragraph(" --------------------------------- "));
        }
    }

    @Override
    public void gerarRodape() {
    }

    @Override
    public void imprimir() {
        if (this.documentoPdf != null && this.documentoPdf.isOpen()) {
            this.documentoPdf.close();
        }
    }

}
