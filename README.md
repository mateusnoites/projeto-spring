# 📦 Projeto API Web com Spring Boot + PostgreSQL

Este projeto é uma **API REST** construída com Spring Boot, utilizando PostgreSQL como banco de dados e Maven como gerenciador de dependências, utilizando a arquitetura **orientada a serviços**. Este guia serve como **base reutilizável** para projetos futuros. Para outros projetos, qualquer **SGBD** pode ser utilizado.

---

## 🔧 Configurações do Spring Initializr

Para iniciar um novo projeto, configure o [Spring Initializr](https://start.spring.io/) da seguinte forma:

- **Project**: Maven
- **Language**: Java
- **Spring Boot**: Última versão estável (preferencialmente LTS)
- **Packaging**: Jar
- **Java**: Última versão LTS disponível (ex: Java 17 ou 21)

### 📦 Dependências
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Boot DevTools

---

## 🏗️ Estrutura do Projeto

### 🔁 Camadas da aplicação

- **Controller**: recebe requisições HTTP e envia respostas.
- **Service**: contém as regras de negócio e o processamento dos dados.
- **Repository**: responsável pela comunicação com o banco de dados.

### 💾 Tipos de modelos
- **Entity**: representa uma tabela no banco de dados.
- **DTO (Data Transfer Object)**: utilizado para trafegar dados entre o backend e o frontend, sem expor diretamente as entidades.

### ✅ Ordem recomendada de criação:
1. `Entity`
2. `DTO`
3. `Repository`
4. `Service`
5. `Controller`

---

## 🛠️ Configuração do `application.properties`

Crie ou atualize o arquivo `src/main/resources/application.properties` com o seguinte conteúdo (personalize os campos entre colchetes):

```properties
spring.application.name=[Nome do Projeto]
spring.datasource.url=[URL do banco de dados do projeto (usando JDBC)]
spring.datasource.username=[Usuário do banco de dados]
spring.datasource.password=[Senha do banco de dados]
spring.jpa.database-platform=[Dialeto do banco (org.hibernate.dialect.nomeDoBanco)]
spring.jpa.hibernate.ddl-auto=create-drop (recomendável deixar assim em ambientes de testes)
spring.jpa.show-sql=true (escolher se vai ou não mostrar o código SQL executado.
```



### ℹ️ Sobre o `spring.jpa.hibernate.ddl-auto`

Essa propriedade define como o Hibernate vai lidar com a criação e atualização das tabelas do banco. Os valores mais comuns são:

-   **`create-drop`**: cria as tabelas ao iniciar a aplicação e **apaga** ao encerrar. Ideal para **testes locais**, já que os dados são descartados.
    
-   **`update`**: atualiza o esquema do banco conforme as entidades, **mantendo os dados existentes**. Útil em desenvolvimento.
    
-   **`validate`**: verifica se o esquema do banco **corresponde às entidades**, sem alterá-lo. Usado em produção para garantir integridade.
    
-   **`none`**: não faz nada. O controle total fica por conta do desenvolvedor.
    

----------

## 🚀 Executando o Projeto

### 📌 Requisitos:

-   Java (LTS) instalado
    
-   SGBD escolhido em execução
    
-   IntelliJ IDEA (ou outro IDE de sua preferência)
    
-   Maven instalado (ou via IntelliJ)
    

### 🧭 Passo a passo no IntelliJ:

1.  Abra o IntelliJ IDEA.
    
2.  Vá em **File > Open** e selecione a pasta do projeto.
    
3.  O IntelliJ detectará automaticamente o `pom.xml` e perguntará se deseja importar como projeto Maven. Clique em **Yes**.
    
4.  Espere o Maven baixar todas as dependências.
    
5.  Crie o banco de dados no SGBD escolhido com o mesmo nome usado em `application.properties`.
    
6.  Rode a aplicação através da classe que possui `@SpringBootApplication`.
    

----------

### 🌐 Porta padrão

A aplicação Spring Boot roda, por padrão, na porta `http://localhost:8080` 

----------

## 🧠 Dicas úteis

-   Usar `@RestController` nas classes controller para expor endpoints REST.
    
-   Manter DTOs enxutos e específicos para cada necessidade.

----------

## 📁 Estrutura de pacotes sugerida
```
src/main/java/seu.pacote/
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
└── SeuProjetoApplication.java
``` 

----------

## 🗃️ Versionamento com Git

Este projeto utiliza **GitHub** para versionamento. Para iniciar o controle de versão:

```bash
git init
git add .
git commit -m "Commit inicial"
git remote add origin https://github.com/seu-usuario/seu-repo.git
git push -u origin main
``` 

----------

## 🔎 Testando a API

Utilizar ferramentas como:

-   [Postman](https://www.postman.com/)
    
-   [Insomnia](https://insomnia.rest/)
    

Essas ferramentas permitem enviar requisições HTTP (GET, POST, PUT, DELETE) para testar os endpoints.

----------

## 📌 Conclusão

Este guia oferece um modelo padrão para a criação de APIs REST com Spring Boot e PostgreSQL. Ele é ideal para padronizar projetos futuros, economizando tempo e mantendo a organização. Basta seguir este fluxo e adaptar conforme a necessidade da aplicação.
