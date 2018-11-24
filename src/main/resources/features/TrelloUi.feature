#language: pt
#encoding: UTF-8
@ui
Funcionalidade: Trello UI
  @ui
  Esquema do Cenario: Criando, comentando e deletando um card
    Dado que esteja logado no Trello
    E acesse o board
    Quando crio um card com o nome "<card name>"
    E comento "<comment>"
    Entao o card deve estar na lista
    Quando excluo o card
    Entao o card nao existe mais
    Exemplos:
      |card name  | comment  |
      |Alex Card  | Comentario do Alex Card  |
      |Alex 2 Card  | Comentario do Alex 2 Card  |