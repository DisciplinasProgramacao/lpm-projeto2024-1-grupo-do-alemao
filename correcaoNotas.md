# ALEMÃO

## Sprint 1 - Até 07/abril
  - Nota de grupo (8 pontos)
    - Modelo UML - restaurante, mesas, requisicoes, cliente (nota de grupo, 8 pontos)
	
  - Nota individual (12 pontos)
    - Implementações e testes + app
    - Documentação das classes.

### Commit f5ea07 (primeiro com tudo no master, em 27/04)	
Diagrama ok - Todos - 8

Cliente sem testes - Barbara 10 

Fila sem testes - Thais - 10

Main - Marcos - 12

Mesa sem testes - Maíra - 10

Reserva sem lógica de classes, sem testes - Rebecca - 6

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

Controller cliente, pedido - encontrado em commit posterior - Rebecca - 7

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
    
    Menu, com case repetido - gerar x retornar produto 
    Pedido ok
    Cliente controller com lista
    Pedido controller com lista

Diagrama com Pedido, sem relação com requisições - Todos - 5,5

Menu fechado em outro commit - getProduto x gerarProduto - Thais - 10

Produtos - Barbara - 14

Restaurante sem cardápio nem métodos para pedidos - Joao - 0 

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