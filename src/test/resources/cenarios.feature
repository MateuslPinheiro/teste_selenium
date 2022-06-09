#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada


  Cenário: Deve inserir uma conta com sucesso
    Dado que estou acessando a aplicação
    Quando informo o usuário "mateus@teste123.com"
    E a senha "teste123"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Então a conta é inserida com sucesso


  Cenário: Não deve inserir uma conta sem nome
    Dado que estou acessando a aplicação
    Quando informo o usuário "mateus@teste123.com"
    E a senha "teste123"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E seleciono Salvar
    Então sou notificado que o nome da conta é obrigatório


  Cenário: Não deve inserir uma conta com nome já existente
    Dado que estou acessando a aplicação
    Quando informo o usuário "mateus@teste123.com"
    E a senha "teste123"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Então sou notificado que já existe uma conta com esse nome

#    mateus@teste123.com || teste123