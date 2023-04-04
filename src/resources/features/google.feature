#language:pt
@google

Funcionalidade: Acessar o google e fazer uma pesquisa

  Cenario: Usuario acessa ao google e faz uma pesquisa
    Dado o usuario acessa "http://google.com"
    E faz uma pesquisa pelo produto "batata frita"
    Entao verifica se o produto retornado

