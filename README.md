# appcontroledevencimentos

Aplicação para o controle de vencimentos de documentos e licenças. Usado para o controle de veículos e motoristas.

----------------------------------------------------
MELHORIAS PARA O FUTURO:

- Atualizar o sistema de criptografia, trocando o MD5 por outro mais efetivo.


----------------------------------------------------
Atualizações:

01/02/2023

- Criado o banco de dados
- Criada a aplicação no netbeans

**********
02/02/2023

- Criada a tela de login e tela principal
- Criadas funções para essas duas telas. 
- Criada função para codificar senhas para comparação no login.
DIA DE GRANDE APRENDIZADO.

**********
03/02/2023

- Criada tela de cadastro e consulta de usuarios
- Criadas funções novas

**********
06/02/2023

- Alteradas tabelas do banco de dados, colocado o usuario_id nas tabelas que registram
as alterações de documentos e licenças.
- Criada tela para alteração de endereço e porta do servidor na tela de login.

**********
07/02/2023
- Criado método para mostrar os usuarios ativos
- Criado método para alterar o status do usuario no banco de dados, de acordo
com o login/fechamento do sistema.
- Alterado método para salvar os dados do usuario
- Adicionados novos itens ao menu
- Alterados nomes de alguns métodos
- Inserido comando para fechar a tela de login após ser acessada a tela principal.
- Criada a tela de cadastro de perfil 
- Criada a tela de cadastro de emissor.

**********
08/02/2023
- Criadas telas de cadastro de motoristas e licenças.
- Criado método que preenche o combobox emissor da tela licenças com as informações do banco de dados.

**********
09/02/2023
- Alterado código de atualização do combobox emissor da tela de cadastro de licenças.
- Melhorado o código de crud da licença.
- Agora ao abrir o sistema, aparece automaticamente os usuários ativos.
- Alterado posicionamento inicial do form de alterar endereço e porta do servidor.
- Criada classe Perfil.
- Alterando classes para o padrão DAO.
- Alterado select sql do MotoristaVeiculoDAO, puxando a data formatada direto do banco.

