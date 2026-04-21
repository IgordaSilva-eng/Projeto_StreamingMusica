# 🎵 Projeto Streaming de Música - Checkpoint 4

Este repositório apresenta a evolução do Sistema de Streaming, agora focado em **Herança**, **Polimorfismo** e **Reutilização de Código**.

## 🎯 Evoluções do CP4

Nesta etapa, o sistema foi refatorado para suportar diferentes tipos de usuários, utilizando os conceitos avançados de POO:

- **Herança (`extends`)**: A classe `Usuario` agora serve como superclasse para `UsuarioFree` e `UsuarioPremium`, permitindo o compartilhamento de atributos (nome, email) e métodos (criar playlist) sem duplicidade de código.
- **Polimorfismo de Sobrescrita (`@Override`)**: O método `reproduzirMusica` possui comportamentos distintos dependendo do tipo de conta:
    - **Usuario Free**: Exibe anúncios a cada 3 músicas reproduzidas.
    - **Usuario Premium**: Reproduz músicas em alta qualidade e permite funcionalidades exclusivas.
- **Modificadores de Acesso (`protected`)**: Uso do modificador `protected` na classe base para permitir que as subclasses acessem diretamente atributos como o `historicoReproducao`.

## 🛠️ Estrutura de Classes

### 1. Usuario (Base)
Define as regras comuns a todos os usuários, como validação de nome e gestão de playlists.

### 2. UsuarioFree (Subclasse)
Implementa a lógica de monetização por anúncios. Possui um contador interno de reproduções.

### 3. UsuarioPremium (Subclasse)
Focada em experiência superior. Inclui o atributo de `plano` e o método exclusivo `baixarMusica`.

### 4. Musica e Playlist
Classes de suporte com encapsulamento rigoroso e métodos de busca/exibição formatada.

## 🚀 Novas Funcionalidades na Main
- **Configuração de Perfil**: Ao iniciar, o sistema solicita o tipo de conta para instanciar o objeto correto.
- **Ouvir Música**: Implementação de um fluxo de reprodução que dispara o comportamento polimórfico definido nas subclasses.

## 🛠️ Como Executar
1. Certifique-se de ter todos os arquivos `.java` na mesma pasta.
2. Compile: `javac *.java`
3. Execute: `java StreamingMusica`