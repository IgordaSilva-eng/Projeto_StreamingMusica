# 🎵 Sistema de Streaming de Música

Este projeto consiste num sistema de gestão de streaming de música desenvolvido em Java, focado na aplicação prática de conceitos de Programação Orientada a Objetos (POO) e arquitetura de software profissional.

## 📋 Funcionalidades

- **Gestão de Utilizadores**: Cadastro e login de utilizadores com distinção entre contas **Free** (com anúncios) e **Premium** (sem anúncios e com suporte a downloads).
- **Reprodução de Conteúdo**: Sistema de reprodução para músicas e playlists com suporte a pausa e paragem.
- **Sistema de Playlists**: Criação de playlists manuais pelos utilizadores e geração de playlists automáticas (Top 10 e Recomendadas).
- **Interação**: Funcionalidade para curtir itens de reprodução e acompanhar o total de curtidas.
- **Serviços Inteligentes**: Gerador de recomendações que sugere conteúdos com base no perfil do utilizador.
- **Utilitários**: Validação rigorosa de e-mails e formatação de tempo (segundos para MM:SS).

## 🏗️ Arquitetura

O projeto segue uma estrutura de pacotes organizada por responsabilidades:

- **`br.com.streaming.modelo`**: Contém as entidades principais como `ItemReproducao` (Classe Abstrata), `Musica`, `Playlist`, `Usuario`, `UsuarioFree` e `UsuarioPremium`.
- **`br.com.streaming.servico`**: Define os contratos através das interfaces `Reproduzivel` e `Baixavel`, além da lógica de negócio em `GeradorRecomendacoes`.
- **`br.com.streaming.util`**: Inclui as classes utilitárias `Validador` e `FormatadorTempo`.
- **`br.com.streaming.principal`**: Contém a classe `StreamingMusica`, ponto de entrada do sistema.

### Conceitos de POO Aplicados:
- **Abstração**: Uso de classes abstratas e interfaces para definir comportamentos base.
- **Herança**: Especialização de utilizadores e itens de reprodução.
- **Polimorfismo**: Sobrescrita de métodos para comportamentos específicos (ex: anúncios no utilizador Free).
- **Encapsulamento**: Proteção de atributos com modificadores de acesso adequados.

## 🚀 Como Executar

1. **Requisitos**: Certifique-se de ter o Java JDK 17 ou superior instalado.
2. **Organização**: Mantenha os arquivos dentro da estrutura de pastas correspondente aos pacotes (ex: `src/br/com/streaming/modelo/...`).
3. **Compilação**: Compile o projeto a partir da pasta raiz utilizando `javac br/com/streaming/principal/StreamingMusica.java`.
4. **Execução**: Execute o sistema com o comando `java br.com.streaming.principal.StreamingMusica`.

## 👤 Autor
- **Nome**: Igor da Silva Alves Correa
- **RGM**: 41885163

## 🗓️ Histórico

- **Checkpoint 1**: Criação da base do sistema de streaming e fundamentos de programação.
    - **Tópicos Praticados**: Estruturas de controle (if/else, switch, loops), declaração de métodos (parâmetros e retorno), manipulação e validação de Strings, armazenamento de dados com Arrays e ArrayList.
- **Checkpoint 2**: Definição de classes base, atributos e modelagem inicial.
    - **Tópicos Praticados**: Criação de classes personalizadas, atributos e métodos de instância, uso da palavra-chave `this`, instanciação de objetos e modelagem orientada a objetos.
- **Checkpoint 3**: Implementação de sistema de playlists, acervo e proteção de dados.
    - **Tópicos Praticados**: Modificadores de acesso (private, public, protected), Getters e Setters, validações em métodos, construtores (padrão, parametrizados e sobrecarga), palavra-chave `this()` e inicialização robusta de objetos.
- **Checkpoint 4**: Implementação de herança entre utilizadores e interface via consola.
    - **Tópicos Praticados**: Conceito de herança, palavras-chave `extends` e `super`, hierarquias de classes, reutilização de código, sobrecarga de métodos (overloading) e sobrescrita de métodos (overriding).
- **Checkpoint 5**: Refatoração para arquitetura de pacotes profissional e aplicação de polimorfismo.
    - **Tópicos Praticados**: Sobrescrita de métodos com `@Override`, polimorfismo em ação, casting (upcasting e downcasting), operador `instanceof`, palavra-chave `final` e uso de listas polimórficas.
- **Checkpoint 6**: Implementação final de interfaces, serviços de recomendação e polimorfismo avançado.
