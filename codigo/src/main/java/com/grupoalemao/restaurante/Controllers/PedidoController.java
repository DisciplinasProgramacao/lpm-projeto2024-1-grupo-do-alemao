import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupoalemao.restaurante.Models.Pedido;
import com.grupoalemao.restaurante.Models.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>(); * arrumar para BD

    @PostMapping
    public ResponseEntity<Pedido> criarPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable int id) {
        if (id < 0 || id >= pedidos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pedidos.get(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/produtos")
    public ResponseEntity<Void> adicionarProduto(@PathVariable int id, @RequestBody Produto produto) {
        if (id < 0 || id >= pedidos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedidos.get(id).addProduto(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/produtos")
    public ResponseEntity<Void> removerProduto(@PathVariable int id, @RequestBody Produto produto) {
        if (id < 0 || id >= pedidos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedidos.get(id).removerProduto(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/fechar/{pessoas}")
    public ResponseEntity<double[]> fecharPedido(@PathVariable int id, @PathVariable int pessoas) {
        if (id < 0 || id >= pedidos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        double[] resultado = pedidos.get(id).fecharPedido(pessoas);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
