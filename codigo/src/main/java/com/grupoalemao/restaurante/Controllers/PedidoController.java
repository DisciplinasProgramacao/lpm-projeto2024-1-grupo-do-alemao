import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido() {
        Pedido pedido = new Pedido();
        Pedido savedPedido = pedidoRepository.save(pedido);
        return new ResponseEntity<>(savedPedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Integer id) {
        return pedidoRepository.findById(id)
                .map(pedido -> new ResponseEntity<>(pedido, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/produtos")
    public ResponseEntity<Void> adicionarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    Produto savedProduto = produtoRepository.save(produto);
                    pedido.addProduto(savedProduto);
                    pedidoRepository.save(pedido);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}/produtos")
    public ResponseEntity<Void> removerProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.removerProduto(produto);
                    pedidoRepository.save(pedido);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/fechar/{pessoas}")
    public ResponseEntity<double[]> fecharPedido(@PathVariable Integer id, @PathVariable int pessoas) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    double[] resultado = pedido.fecharPedido(pessoas);
                    return new ResponseEntity<>(resultado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
