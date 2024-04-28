import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> pedido;

    public Pedido() {
        this.pedido = new ArrayList<Produto>();
    }

    public void addProduto(Produto produto) {
        this.pedido.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.pedido.remove(produto);
    }

    public List<Produto> getPedido() {
        return this.pedido;
    }

    public double[] fecharPedido(int pessoas) {
        double totalSemTaxa = 0.0;
        for (Produto produto : this.pedido) {
            totalSemTaxa += produto.getPreco();
        }

        double taxaServico = totalSemTaxa * 0.10;
        double totalComTaxa = totalSemTaxa + taxaServico;

        double valorPorPessoa = totalComTaxa / pessoas;

        totalComTaxa = Math.round(totalComTaxa * 100.0) / 100.0;
        valorPorPessoa = Math.round(valorPorPessoa * 100.0) / 100.0;

        return new double[] { totalComTaxa, valorPorPessoa };
    }
}