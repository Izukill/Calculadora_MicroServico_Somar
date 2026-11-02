# Calculadora Distribuída — Microsserviço de Adição

**Disciplina:** Gerenciamento de Configuração e Mudança (GCM)  
**Equipe:** Time 1  
**Versão do Contrato:** v1.0.0  

Este repositório contém o **Microsserviço de Adição**, parte integrante do projeto de Calculadora Distribuída. Desenvolvido em **Java com Spring Boot**, o serviço expõe um endpoint REST dedicado exclusivamente a realizar operações de soma, seguindo rigorosamente o contrato de API preestabelecido entre as equipes.

---

## 🚀 Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Docker**

---

## 🐳 Como Executar localmente (Via Docker)

Para garantir a reprodutibilidade do ambiente, o projeto está preparado para ser executado via Docker. Nenhuma instalação local do Java ou do Maven é necessária para testar o serviço.

**1. Construir a imagem Docker:**

Na raiz do repositório (onde está localizado o arquivo `Dockerfile`), execute o comando abaixo para "buildar" a imagem:

```bash
docker build -t micro-somar:v1.0.0 .
```

**2. Iniciar o container:**

Execute o container mapeando a porta local para a porta interna do serviço:

```bash
docker run -p 8080:8080 micro-somar:v1.0.0
```

O serviço estará disponível em `http://localhost:8080`.

---

## 📖 Contrato da API

### `POST /somar`

Recebe dois operandos numéricos e retorna a soma exata deles.

**Headers exigidos:**

* `Content-Type: application/json`

**Corpo da Requisição (Entrada):**

```json
{
  "a": 10,
  "b": 5
}
```

> **Nota:** O serviço aceita valores inteiros, decimais e negativos. Strings numéricas não são aceitas.

### Respostas Mapeadas

🟢 **Sucesso (200 OK)**

```json
{
  "resultado": 15
}
```

🔴 **Erro de Validação de Input (400 Bad Request)**

Retornado quando campos obrigatórios estão ausentes ou possuem tipos inválidos (ex: string passada no lugar de número).

```json
{
  "erro": {
    "codigo": "INVALID_INPUT",
    "mensagem": "Os campos 'a' e 'b' devem ser números."
  }
}
```

🔴 **Erro de Sintaxe (400 Bad Request)**

Retornado quando a requisição envia um JSON malformado ou quebrado.

```json
{
  "erro": {
    "codigo": "INVALID_JSON",
    "mensagem": "O corpo da requisição não é um JSON válido."
  }
}
```

---

Documentação mantida sob o padrão de versionamento semântico exigido pela disciplina de GCMS.