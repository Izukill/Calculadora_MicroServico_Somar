# Changelog

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

## [1.0.0] - 2026-11-02

### Adicionado
- **Endpoint de Adição (`POST /somar`):** Implementação base do microsserviço utilizando Spring Boot, recebendo dois operandos (`a` e `b`) e retornando a soma exata.
- **DTOs de Contrato:** Criação das classes `SomarRequestDTO`, `SomarResponseDTO` e `ErroResponseDTO` para espelhar rigidamente o contrato JSON acordado entre os times.
- **Documentação Base:** Elaboração do `README.md` contendo instruções de execução via Docker e documentação do contrato da API.
- **Tratamento de Exceções Global (`GlobalExceptionHandler`):**
  - Interceptação de falhas de tipagem ou campos obrigatórios ausentes, retornando HTTP `400 Bad Request` com o código `INVALID_INPUT`.
  - Interceptação de falhas de sintaxe no envio do JSON, retornando HTTP `400 Bad Request` com o código `INVALID_JSON`.
- **Conteinerização:** Criação do `Dockerfile` na raiz do projeto para empacotamento da aplicação Java, isolamento de ambiente e execução padronizada.
