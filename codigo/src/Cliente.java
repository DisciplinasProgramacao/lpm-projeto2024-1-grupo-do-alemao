package src;
class Cliente {
    private static int cod = 0;
    private String nome;
    private String telefone;

    /*
     * Construtor da classe Cliente recebe como parâmetro uma string nome
     * e uma com o telefone do Cliente. E também, gera um código inteiro para
     * o cliente.
     */
    public Cliente(String n, String tel) {
        if (n != null && tel != null) {
            setNome(n);
            setTelefone(tel);
            Cliente.cod = Cliente.cod + 1;
        }
    }

    /*
     * Método recebe uma string nome do cliente como parâmetro e atribui
     * o valor recebido à variável Nome, se este tiver mais que 3
     * caracteres.
     */
    public void setNome(String nome) {
        if (nome.length() > 3) {
            this.nome = nome;
        }
    }

    /*
     * Método recebe uma string telefone do cliente como parâmetro e atribui
     * o valor recebido à variável Telefone, se este tiver 8 ou mais
     * caracteres.
     */
    public void setTelefone(String telefone) {
        if (telefone.length() >= 8) {
            this.telefone = telefone;
        }
    }

    // Método retorna um número inteiro que é o código do Cliente.
    public int getCod() {
        return cod;
    }

    // Método retorna uma cadeia de caracteres que é o nome do Cliente.
    public String getNome() {
        return nome;
    }

    // Método retorna uma cadeia de caracteres que é o telefone do Cliente.
    public String getTelefone() {
        return telefone;
    }
}