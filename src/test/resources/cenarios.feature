#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  #    mateus@teste123.com || teste123

  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "mateus@teste123.com"
    E a senha "teste123"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar

  Esquema do Cenario: Deve validar regras cadastro contas
    E informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem>"

  Exemplos:
    | conta            | mensagem                           |
    | Conta de Teste   | Conta adicionada com sucesso!      |
    |                  | Informe o nome da conta            |
    | Conta mesmo nome | Já existe uma conta com esse nome! |