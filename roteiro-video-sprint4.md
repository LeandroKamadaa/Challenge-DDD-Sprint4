# Roteiro de Gravação - Vídeo da Sprint 4

Este é o roteiro estrutural para a gravação do vídeo exigido na entrega. Ele lista a ordem ideal do que mostrar na tela e os pontos técnicos que vocês devem abordar para o professor validar todos os critérios da rubrica.

---

### 1. Introdução (IDE - Mostrando a raiz do projeto)
* **O que mostrar na tela:** O projeto aberto no Eclipse/IntelliJ/VS Code com a estrutura de pastas visível ao lado.
* **O que abordar (Responsabilidade):** 
  * Apresentação rápida do grupo e do projeto (CRM Hospital São Rafael).
  * O objetivo desta Sprint 4: expor as regras de negócio criadas na Sprint 3 através de APIs e de Views documentadas.

### 2. Estrutura do Código: Pacote `controller.api`
* **O que mostrar na tela:** Abrir a pasta `src/main/java/.../controller/api` e mostrar rapidamente as classes (ex: `PacienteApiController.java` ou `AgendamentoApiController.java`).
* **O que abordar (Responsabilidade):** 
  * Explicar que este módulo é responsável pela comunicação **puramente JSON** da aplicação (para integrações com mobile ou front-ends externos).
  * Destacar o uso do `@RestController`.
  * Mostrar que os verbos HTTP corretos foram aplicados (`GET`, `POST`, `PATCH`).
  * Destacar os retornos padronizados com `ResponseEntity` e os status codes (200 OK, 201 Created, 204 No Content).

### 3. Estrutura do Código: Pacote `controller.view`
* **O que mostrar na tela:** Abrir a pasta `src/main/java/.../controller/view` e mostrar o `PacienteViewController.java` ou `LeadViewController.java`.
* **O que abordar (Responsabilidade):** 
  * Explicar que este módulo é o responsável por interceptar a navegação do usuário e devolver as páginas HTML.
  * Destacar o uso do `@Controller` clássico e a injeção do objeto `Model` para passar os dados do Banco de Dados para a tela.

### 4. Navegação Web: A Tela Home / Documentação
* **O que mostrar na tela:** Mudar a tela para o Navegador de internet rodando o `http://localhost:8080/`.
* **O que abordar (Responsabilidade):** 
  * Explicar que as páginas foram renderizadas no lado do servidor (Server-Side) usando a dependência do **Thymeleaf**.
  * Mostrar a página inicial e explicar a sua responsabilidade: ela atua como a **documentação de uso** exigida pela faculdade, listando todas as rotas visuais e as rotas JSON disponíveis no sistema.

### 5. Navegação Web: Telas de Entidades (Listagens)
* **O que mostrar na tela:** Clicar nos links para navegar pelas 3 entidades: Pacientes, Leads e Agendamentos.
* **O que abordar (Responsabilidade):** 
  * Mostrar que as Views estão operacionais e listando os dados vindos do banco.
  * Nas tabelas, dar ênfase à coluna de **"Ações API"**.
  * **Ponto alto do vídeo:** Clicar em botões como "Ver JSON" (para mostrar que a View tem atalho direto para a API REST e retorna o dado em JSON).
  * **Ponto alto do vídeo 2:** Em "Pacientes", clicar no botão "Ver IMC" para provar que a regra de negócio da Sprint 3 (cálculo de IMC) foi mantida e exposta na Sprint 4.

### 6. Encerramento
* **O que mostrar na tela:** Pode voltar para a Home ou para o código fonte.
* **O que abordar (Responsabilidade):** 
  * Resumo rápido: confirmar que a aplicação cumpriu todos os requisitos (separação de domínios em JSON e View, uso do Thymeleaf, páginas como documentação, e uso de padrões HTTP).
  * Agradecimento e finalização.
