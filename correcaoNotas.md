# ALEMÃO

## Sprint 1 - Até 07/abril
  - Nota de grupo (8 pontos)
    - Modelo UML - restaurante, mesas, requisicoes, cliente (nota de grupo, 8 pontos)
	
  - Nota individual (12 pontos)
    - Implementações e testes + app
    - Documentação das classes.

### Commit f5ea07 (primeiro com tudo no master, em 27/04)	
Diagrama ok - Todos - 8

Cliente sem testes - Barbara 12 *revisado*

Fila sem testes - Thais - 10

Main - Marcos - 12

Mesa sem testes - Maíra - 10

**REVISADO** , commits 2139d18 e 9dc71d5
- Reserva sem lógica de classes, apenas atribuição de dados. Sem validação em construtor e métodos, sem documentação
- Reserva não tem pertiência com o projeto - nome do item?! Falta cliente, falta mesa...  
- Com a classe mal feita, os testes não teriam como ser bons. Testes para livro e computador?! Para além disso: um único teste para várias coisas e sem testar situações de validação (dados incorretos). A nota está mantida como 6 (50%) porque a entrega em atraso é melhor que esta (que daria no máximo 33% da nota) - Rebecca - 6

Restaurante sem testes - João - 8 

## Sprint 2 - Até 19/maio
  - Nota de grupo (6 pontos)
    - Modelo UML atualizado - cardápio e pedidos
	- Estrutura Spring
  
  - Nota individual (14 pontos)	
    - Implementações cardápio e pedidos
    - Controllers
    - Correções anteriores

### Commit 90880d3 (em 27/05)
Diagrama desatualizado - Todos - 3

Sem cardápio - encontrado em commit posterior - Thais - 9

Sem pedido - encontrado em commit posterior - Maíra - 10

**REVISADO** Controller cliente, pedido - encontrado em commit posterior (178ad5ddc e d70938b3) 
- Commits de 16/06, já dentro da data da Sprint 4. Nota considerada como entrega em atraso, portanto 50% - Rebecca - 7

Requisição em outro branch - Bárbara - 12

Restaurante em outro branch - sem atualizações  - Joao - 0 

Main - em outro branch - adicionando produto ao pedido mas não a requisições. fechar conta - Marcos 10

## Sprint 3 - Até 05/junho
  - Nota de grupo (6 pontos)
    - Modelo atualizado - menu fechado
  
  - Nota individual (14 pontos)	
    - Implementações menu fechado e app
    - Correções anteriores

### Commit 7aaa606 (em 10/06)
Correções:
  - Menu ok, com case repetido - gerar x retornar produto - Maíra
  - Pedido ok
  - Cliente controller com lista
  - Pedido controller com lista

Diagrama com Pedido, sem relação com requisições - Todos - 5,5

Menu fechado em outro commit - getProduto x gerarProduto - Thais - 10

Pedido - Bárbara - get desnecessário nos produtos - 12

**REVISADO**
Produtos - 
- A classe Produto era atribuição da Rebecca. Por decisão do grupo, foram feitas as heranças para os produtos (todas classes simples, apenas com construtor de cada produto). Por outra decisão própria, a tarefa foi dividida entre Rebecca e Bárbara (que tinha outra atribuição). Tratava-se de uma tarefa simples, que deveria ser realizada por uma pessoa. Assim, a decisão da revisão é por dividir os 14 pontos entre as alunas
- Rebecca: 7 // Bárbara: 7


Restaurante sem cardápio nem métodos para pedidos - Joao - 4 **REVISADO POR ENTREGA POSTERIOR** 

Mesa controller com set para tudo - Maira - 11

Requisicao controller com set para tudo - Maira - 11 

Main em commit posterior - duas variáveis para menu - adicionando produtos sem perguntar ao usuário - fazendo get para dados - Marcos - 9

## Sprint 4 - Apresentação em 24/06
  - Nota de grupo 3,6/6 pontos
	- Modelo - relação entre pedido e requisicoes. Sem classe abstrata.
	- Apresentação - muitos métodos com problemas.
	
  - Nota individual (14 pontos)
    - Ajustes do último quadro "Projeto GitHub"
    - Correções das sprints anteriores

### Commits SP4

PedidoFechado (Thais) - ok, porém "isComida" e "isBebida" não é uma boa solução modular. 8,5

MenuFechado (Barbara) - getcategoria ferindo modularidade. 'contem' deve ser feito usando colecoes 8,5

Requisicao (Rebecca) - lanca exceção sem fazer a operacao

Correcao Controllers (Rebecca) - ok 10 

Main (Marcos) - fazendo for em dados do restaurante. gets em sequencia. pedido sem ligação com a requisição. não mostra conta. 7

Controllers+Limpeza (maira) - ok 14

Cliente (Joao) - "GlobalExceptions", lançando exceção no main sem tratar. 

Restaurante (Joao) - executando logiva de mesa no restaurante (deve chamar requisicao). Ainda sem métodos para pedidos.

Controllers ok (Joao) 10