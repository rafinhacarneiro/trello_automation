#language: pt
#encoding: UTF-8

@api
Funcionalidade: Trello API
    @api
    Esquema do Cenario: Cenario: Criando, comentando e deletando um card
      Dado que acesse aAPI com sucesso
      Quando crio um card com o nome "<Nome>" usando a API
      E comento "<Comentario>" no card gerado
      Entao o card deve ser criado com sucesso
      Quando excluo usando a API
      Entao eu tenho o resultado com status "404"
      Exemplos:
        |Nome  |Comentario  |
        |Rafael Carneiro | Exemplo de comentario  |
