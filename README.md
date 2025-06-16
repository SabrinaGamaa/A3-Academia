# 💪 Sistema de Gerenciamento de Academia - A3 (Java + SQLite)

Este projeto foi desenvolvido como parte da **Avaliação A3** da disciplina de Programação de soluções computacionais, com o objetivo de criar um sistema completo de gerenciamento de alunos e seus treinos em uma academia.

> ⚠️ Trabalho em grupo com 5 integrantes.

---

## 🧠 Objetivo

Criar um sistema com as funcionalidades de **cadastro, consulta, atualização e exclusão (CRUD)** de alunos e treinos, com persistência em banco de dados e interface amigável.

---

## ✅ Funcionalidades Implementadas

### 👤 Módulo de Alunos

| Requisito | Descrição |
|----------|-----------|
| RF01 | Cadastrar novo aluno (nome, CPF, data de nascimento, telefone, e-mail) |
| RF02 | Listar todos os alunos |
| RF03 | Editar informações de um aluno |
| RF04 | Excluir um aluno |
| RF05 | Buscar aluno por nome ou ID |

### 🏋️‍♀️ Módulo de Treinos

| Requisito | Descrição |
|----------|-----------|
| RF06 | Cadastrar treino (tipo, descrição, duração, data início, aluno vinculado) |
| RF07 | Listar todos os treinos de um aluno |
| RF08 | Editar treino |
| RF09 | Excluir treino |

### ⚙️ Funcionalidades Gerais

| Requisito | Descrição |
|----------|-----------|
| RF10 | Persistência com SQLite usando JDBC |
| RF11 | Interface gráfica com **Swing (GUI)** construída no NetBeans |

---

## 🛠 Tecnologias Utilizadas

- **Java OpenJDK 21.0.6**
- **NetBeans 20** (interface gráfica via GUI builder)
- **IntelliJ IDEA** (desenvolvimento inicial em linha de comando)
- **SQLite** (banco de dados local)
- **SQLite JDBC 3.36.0.3**
- **JDBC** (conexão Java + SQL)
- **Maven** (gerenciador de dependências)
- **Git & GitHub** (controle de versão)

---

## 🧩 Estrutura do Projeto

```bash
   A3-Academia/
      ├── database/        # Arquivos do banco SQLite
      ├── modelos/         # Classes de modelo (Aluno, Treino)
      ├── repositorio/     # Acesso a dados (DAO)
      ├── servicos/        # Lógica de negócio
      ├── telas/           # Interface gráfica (Swing)
      ├── util/            # Classes utilitárias (conexão)
      ├── imagens/         # Ícones e logos do sistema
      └── README.md
```

---

## 🗄️ Estrutura do Banco de Dados (SQLite)

O sistema utiliza um banco de dados local SQLite, gerenciado via JDBC, com duas tabelas principais:

### 📋 Tabela: `Aluno`

| Campo            | Tipo        | Descrição                                           |
|------------------|-------------|-----------------------------------------------------|
| `id`             | INTEGER     | Identificador único do aluno (PK, auto-incremento) |
| `nome`           | TEXT        | Nome completo do aluno                             |
| `cpf`            | TEXT        | CPF do aluno                                       |
| `data_nascimento`| DATE        | Data de nascimento do aluno (dd/MM/yyyy)           |
| `telefone`       | TEXT        | Telefone para contato                              |
| `email`          | TEXT        | E-mail do aluno                                    |

---

### 📋 Tabela: `Treino`

| Campo         | Tipo        | Descrição                                           |
|---------------|-------------|-----------------------------------------------------|
| `id`          | INTEGER     | Identificador único do treino (PK, auto-incremento) |
| `aluno_id`    | INTEGER     | ID do aluno associado (FK → `Aluno.id`)             |
| `tipo_treino` | TEXT        | Tipo do treino (ex: musculação, aeróbico)           |
| `descricao`   | TEXT        | Detalhamento do treino                              |
| `duracao`     | TEXT        | Duração do treino (ex: "45 minutos")                |
| `data_inicio` | TEXT        | Data e hora de início do treino (dd/MM/yyyy HH:mm:ss) |

🔗 **Relacionamento:**  
Cada treino pertence a **um único aluno**, mas um aluno pode ter **vários treinos**.  
Ou seja, é uma relação **1:N (Aluno → Treinos)**.

---

### 🛡️ Observações Técnicas

- O banco de dados é criado automaticamente em tempo de execução na pasta `database/` (arquivo `bancodados.db`).
- As tabelas são geradas se não existirem (`CREATE TABLE IF NOT EXISTS`).
- A conexão é feita utilizando a biblioteca [`sqlite-jdbc`](https://github.com/xerial/sqlite-jdbc).


---

## 📸 Prints e Demonstrações

![Tela Inicial](https://github.com/SabrinaGamaa/A3-Academia/blob/main/imagens/telaInicial.PNG)
> Tela inicial do sistema com navegação amigável

![Visualização de Alunos](https://github.com/SabrinaGamaa/A3-Academia/blob/main/imagens/deletarAluno.PNG)
> Deletar aluno do banco de dados

---

## 📌 Dificuldades e Soluções

### 1. **Migração de Ambiente**
> O projeto foi iniciado no IntelliJ IDEA em linha de comando e depois migrado para o NetBeans, aproveitando o GUI Builder para desenvolvimento da interface. Foi necessário adaptar o projeto para Maven e reorganizar os diretórios.

### 2. **Integração da Interface com o Banco de Dados**
> O maior desafio foi conectar os componentes da interface gráfica com os métodos de acesso ao banco de dados (DAO). Foi criada uma arquitetura separando bem as camadas: Model → DAO → Serviço → Interface (Swing). Criei camadas bem separadas (Model, DAO, Serviço e GUI) para facilitar a manutenção e reutilização.

### 3. **Tratamento de Erros**
> Implementado tratamento básico de erros, exibindo mensagens amigáveis ao usuário através do JOptionPane. Planeja-se futuramente criar uma classe centralizadora de exceções.

---

---

## ▷ Como Executar

1. Clone o projeto:

   Intellij:
    ```bash
    git clone https://github.com/SabrinaGamaa/A3-Academia.git
    ```
   NetBeans:
   ```bash
    git clone https://github.com/SabrinaGamaa/A3-Academia-NetBeans.git
    ```
   
2. Abra no NetBeans ou IntelliJ

    - No NetBeans, abra como projeto Maven
    - No IntelliJ, importe como projeto Maven e selecione JDK 21

   
3. Execute a classe TelaInicial.java ou qualquer JFrame desejado


4. Banco de dados será criado automaticamente na pasta database/

---

## 🧩 Observações sobre o Projeto no IntelliJ

O projeto também foi desenvolvido e testado inicialmente no IntelliJ IDEA, onde:

- A dependência `sqlite-jdbc` versão `3.36.0.3` foi adicionada manualmente via **External Libraries**.
- Por isso, **não há arquivo `pom.xml` no projeto original do IntelliJ**, mas a versão migrada para o NetBeans já utiliza o Maven com essa dependência corretamente configurada na versão `3.43.2.2`.



---

## 🔧 Pré-requisitos

- Java JDK 21 instalado
- NetBeans 20 (ou IntelliJ com suporte a Maven)
- Git instalado (opcional)

---

## 👩‍💻 Autoria

Projeto desenvolvido por 
 - [**Sabrina Gama**](https://github.com/SabrinaGamaa)
 - [**Vicenzzo Palma**](https://github.com/vicenzzopalma)
 - [**Raquel Silva**](https://github.com/RaquelSillva)
 - [**Paulo H. Oliveira**](https://github.com/PauloHOC818)
 - **Kauan** 

> como parte da disciplina A3 - 1º semestre de Programação de Soluções Computacionais.

---

## 📝Licença

- Este projeto foi desenvolvido apenas com fins educacionais como parte da faculdade. Não possui fins comerciais.
