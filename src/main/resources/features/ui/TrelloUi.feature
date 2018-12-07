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
      |Rafael Card  | Comentario do Rafael Card  |
      |Rafael 2 Card  | Comentario do Rafael 2 Card  |