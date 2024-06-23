import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PutMapping("/{id}/produtos/{produtoId}")
    public ResponseEntity<Void> adicionarProduto(@PathVariable Integer id, @PathVariable Integer produtoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        Optional<Produto> optionalProduto = produtoRepository.findById(produtoId);

        if (optionalPedido.isPresent() && optionalProduto.isPresent()) {
            Pedido pedido = optionalPedido.get();
            Produto produto = optionalProduto.get();
            pedido.addProduto(produto);
            pedidoRepository.save(pedido);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/produtos/{produtoId}")
    public ResponseEntity<Void> removerProduto(@PathVariable Integer id, @PathVariable Integer produtoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.removerProdutoPeloId(produtoId); // Supondo que haja um método para remover pelo ID
            pedidoRepository.save(pedido);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/fechar/{pessoas}")
    public ResponseEntity<double[]> fecharPedido(@PathVariable Integer id, @PathVariable int pessoas) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        return optionalPedido.map(pedido -> {
            double[] resultado = pedido.fecharPedido(pessoas);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
