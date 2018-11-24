#language: pt
#encoding: UTF-8
  @ui
  Funcionalidade: Trello UI
    @ui
    Esquema do Cenario: Criando, comentando e deletando um card
      Dado que eu esteja logado no Trello
      E acesse o board
      Quando crio um card com o nome "<card name>"
      E comento "<comment>"
      Entao o card deve estar na lista
      Quando excluo o card
      Entao o card não existe emais
      Exemplos:
        |card name  |comment  |
        |Alex Card  |Comentário do Alex Card  |
        |Alex 2 Card  |Comentário do Alex 2 Card  |