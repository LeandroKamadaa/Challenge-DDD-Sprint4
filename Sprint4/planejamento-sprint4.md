# Planejamento Completo - Sprint 4: Exposição das Regras de Negócio em JSON e Views

Este documento descreve o passo a passo completo para a realização e entrega da Sprint 4 do projeto de Domain Driven Design. O objetivo desta sprint é expor os serviços e regras de negócio construídos na Sprint 3 através de uma API REST (JSON) e de páginas Web Server-Side (Thymeleaf).

## Passo 1: Preparação do Ambiente e Dependências
1. **Configuração do POM:** Adicionar a dependência do `spring-boot-starter-thymeleaf` no arquivo `pom.xml` para permitir a renderização das páginas web (Views).
2. **Revisão da Sprint 3:** Analisar as entidades (`Paciente`, `Lead`, `Agendamento`) e as regras de negócio já implementadas nas classes de Serviço (`PacienteService`, `LeadService`, `AgendamentoService`) para entender quais métodos serão expostos.

## Passo 2: Implementação da API REST (JSON Controllers)
O objetivo aqui é criar os endpoints que retornarão dados puramente em JSON, utilizando os verbos HTTP e os status codes corretos.
* **Ação:** Criar o pacote `br.com.fiap.hospital_crm.controller.api`.
* **Endpoints a desenvolver:**
    * **PacienteApiController:** 
        * `GET /api/pacientes` (Listar todos)
        * `GET /api/pacientes/{id}` (Buscar específico)
        * `POST /api/pacientes` (Cadastrar)
        * `GET /api/pacientes/{id}/imc` (Calcular IMC via regra de negócio)
    * **LeadApiController:**
        * `GET /api/leads` (Listar todos)
        * `GET /api/leads/{id}` (Buscar específico)
        * `POST /api/leads` (Cadastrar)
    * **AgendamentoApiController:**
        * `GET /api/agendamentos` (Listar todos)
        * `GET /api/agendamentos/{id}` (Buscar específico)
        * `POST /api/agendamentos` (Agendar consulta)
        * `PATCH /api/agendamentos/{id}/status` (Atualizar status do agendamento)
* **Regra de Ouro:** Utilizar `@RestController`, anotações adequadas (`@GetMapping`, `@PostMapping`, etc) e retornar objetos `ResponseEntity` com status adequados (ex: `201 CREATED`, `200 OK`).

## Passo 3: Implementação das Rotas Visuais (View Controllers)
Criar os controladores clássicos do Spring MVC para interceptar rotas de navegação do navegador e renderizar as páginas HTML do Thymeleaf.
* **Ação:** Criar o pacote `br.com.fiap.hospital_crm.controller.view`.
* **Classes a desenvolver:**
    * **HomeController:** Intercepta `/` e retorna a página inicial.
    * **PacienteViewController:** Intercepta `/pacientes` e passa a lista de pacientes via objeto `Model` para a view.
    * **LeadViewController:** Intercepta `/leads` e passa a lista de leads via `Model` para a view.
    * **AgendamentoViewController:** Intercepta `/agendamentos` e passa a lista de agendamentos via `Model` para a view.

## Passo 4: Construção das Telas (Views em Thymeleaf)
Criar a interface visual da aplicação usando HTML, Thymeleaf e Bootstrap (para estilização). Além de mostrar os dados, a interface deve servir como documentação da API.
* **Ação:** Criar os arquivos HTML dentro da pasta `src/main/resources/templates/`.
* **Páginas a desenvolver:**
    * `index.html`: Página principal contendo as instruções de uso e links documentados para acessar as Views e os endpoints JSON.
    * `pacientes/index.html`: Tabela listando os pacientes e botões de atalho para acessar o JSON de cada registro.
    * `leads/index.html`: Tabela listando os leads com atalhos para a API.
    * `agendamentos/index.html`: Tabela listando os agendamentos com atalhos para a API.

## Passo 5: Testes Integrados na Máquina Local
1. Iniciar a aplicação na IDE (rodar o `HospitalCrmApplication.java`).
2. Abrir o navegador e acessar `http://localhost:8080/`.
3. Navegar pelas abas HTML para garantir que o Thymeleaf está sendo renderizado corretamente e que os dados do banco estão aparecendo.
4. Testar a API Rest usando o Postman, Insomnia ou clicando nos links disponíveis na tela inicial para confirmar o retorno do JSON.

## Passo 6: Criação do Documento PDF de Entrega
* **Requisito (10 pontos):** Criar um arquivo PDF simples.
* **Conteúdo Obrigatório:**
    1. Nome completo e RM de todos os integrantes do grupo.
    2. Uma breve descrição da solução e de suas principais funcionalidades, com no **mínimo 20 linhas de texto**. (Descrever como o sistema de CRM Hospitalar funciona, a separação de domínios e regras aplicadas).
    3. **Prints/Capturas de Tela:** Adicionar imagens das páginas rodando no navegador (Página Inicial, Lista de Pacientes, Leads e Agendamentos).

## Passo 7: Gravação do Vídeo Explicativo
* **Requisito (10 pontos):** Gravar um vídeo demonstrando o projeto.
* **Roteiro Sugerido:**
    1. Iniciar o vídeo apresentando o grupo e o sistema (CRM Hospital São Rafael).
    2. Mostrar o código rodando na IDE e demonstrar a divisão dos pacotes (JSON Controllers vs View Controllers).
    3. Mostrar as telas visuais (Thymeleaf) operando no navegador.
    4. Demonstrar a chamada de pelo menos uma ou duas rotas JSON (via navegador ou Postman) para mostrar que a API está comunicando corretamente com o Banco de Dados.
    5. Fazer upload do vídeo no YouTube (Não Listado), Google Drive ou salvar como MP4.

## Passo 8: Submissão da Tarefa
1. Criar um **Arquivo ZIP** com o projeto Java completo desenvolvido. (Dica: garanta que a pasta `target` e `node_modules`, se houver, não entrem no ZIP para não ficar muito pesado, deixe apenas os diretórios vitais como `src` e `pom.xml`).
2. Anexar o **PDF** gerado no Passo 6.
3. Inserir o **Link do Vídeo** no envio ou anexar o MP4, caso exigido.
4. Realizar o upload na plataforma de entregas antes do encerramento do prazo.
