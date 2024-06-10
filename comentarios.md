# Comentários - Revisão de 09/06 (fim da Sprint 3)

Todos os comentários referem-se ao código do ramo "master" ou "main". É obrigação do grupo manter o código principal neste ramo. Problemas relatados podem ser:

  - ⚠️ - médios. Erros de lógica, regras mal implementadas... Descontos de até 1 ponto.
  - 🚨 - sérios. Regras faltando, problemas de modularidade... Descontos de até 3 pontos.
  - 💣 - graves. Falta de classes, requisitos ignorados ... Descontos de 5 ou mais pontos.


## Revisão

1. ⚠️ Controller da Reserva não parece ter método para atualizar pedido, atualizar estado. O "Update" é genérico e não verifica o que está sendo atualizado.
1. 🚨 Sem controllers para cliente e pedido.
1. 🚨 "Adicionar Produtos" no main está gerando um pedido vazio novo a cada vez. Este pedido não está sendo associado a uma reserva.
1. 🚨 Programa principal pedindo dados sem sentido como telefone do cliente e data da reserva (sempre é para hoje)
1. 💣 Programa principal não aceita reserva de mesa para 3 pessoas. Não consigo testar nada mais a partir disso. 
