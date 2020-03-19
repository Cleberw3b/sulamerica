## Test Sulamerica

Gostaria de ter adicionado Testes e Documentação além de desenvolver a parte de Segurança, mas acabei perdendo tempo relambrando como desenvolver aplicação Java.

Essa é uma aplicação Rest utilizando Spring Boot web, h2 database e JPA

### Cenário 1 - API REST para gerenciamento de usuários (Obrigatório):
- [x] Crie uma API para cadastro, atualização, remoção e listagem de usuários.
- [x] Características dos usuários: nome, CPF, sexo, data de nascimento, cargo (Gerente, Supervisor,
Administrativo...), perfil (Administrador, Comum...) e status (Ativo e Inativo).
- [x] Considere também a criação de um serviço para cadastrar novos cargos e novos perfis.
- [x] Deve ser possível realizar buscas por nome, CPF, cargo, perfil ou/e status.
- [x] Crie um serviço para inativar os usuários ativos.
- [x] Crie um serviço que retorne os usuários do sexo feminino e que sejam maiores de 18 anos.
- [x] Crie um serviço que retorne os CPF’s que iniciem com dígito zero.

### Regras de validação:
- [x] Não será permitido o cadastro de usuários com o mesmo CPF e Nome.
- [x] Ao cadastrar, todos os dados de usuários são obrigatórios.
- [x] Verificar se é um CPF válido.
- [x] Formatar a data para o padrão (dia/Mês/Ano)
- [x] Nas buscas e listagens, exibir as descrições de cargo, perfil e status.
- [x] Ao inativar um usuário, validar se o mesmo se encontra ativo.

### Cenário 2 - Segurança (Opcional, mas será um diferencial)
- [ ] Proteja os serviços de acessos não autorizados com Spring Security (Stateless) e JWT.
- [ ] Crie um serviço de autenticação que retorne o token JWT a ser utilizado no (header http) de cada serviço do
cenário 1, caso as credenciais estejam válidas.
- [ ] Relacione as credenciais de acesso aos usuários cadastrados pelo serviço do cenário 1.
- [ ] Na classe de configuração do Spring Security, defina as regras de acesso baseado no perfil do usuário onde o
administrador terá acesso a todos os serviços e o usuário comum só terá acesso ao serviço que retorne as
suas próprias informações (Crie este novo serviço).
- [ ] No provedor de autenticação do Spring Security, obter o usuário pelo login e autorizar apenas se o status for
ativo. Não esqueça de dizer para o Spring, qual o perfil do usuário autorizado.
- [ ] Crie um filtro do Spring para autorizar as requisições dos serviços onde será esperando (Bearer + token) ao
obter do cabeçalho http.
- [ ] Garanta que todos os serviços estejam protegidos pelo contexto de segurança do Spring.

### Requisitos técnicos:
- [x] Utilizar o H2 (Embedded Database).
- [x] Utilizar o arquivo data.sql para definir o script de criação da base de dados e suas cargas iniciais.
- [x] Utilizar Spring Data JPA na sua solução.
- [x] Criar pelo menos uma operação de busca e inclusão utilizando Spring JDBC Template.
- [x] Tratar as exceções e implementar logs onde for necessário.