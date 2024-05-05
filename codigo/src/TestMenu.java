import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMenu {
   
    /*Teste para verificar se o produto está sendo acessado corretamente*/
    @Test
    public void testGetProdutoValido(){
        Menu menu = new Menu();
        assertEquals("Falafel Assado", menu.getProduto(2));
    }

    /*Teste para verificar se a função getProduto retorna null caso haja uma tentativa de acessar uma posição inexistente no array de produtos*/
    @Test
    public void testGetProdutoInvalido(){
        Menu menu = new Menu();
        assertEquals(null, menu.getProduto(12));
    }

    /*Teste para verificar se um produto está sendo gerado corretamente*/
    @Test
    public void testGerarProduto() {
        Menu menu = new Menu();
        menu.gerarProduto(4);
        assertEquals("Escondidinho de Inhame", menu.getProduto(4));
    }
}
