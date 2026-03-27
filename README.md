# 🎵 Projeto Streaming de Música - Checkpoint 2

Este repositório contém a evolução do Sistema de Streaming, agora reestruturado utilizando o paradigma de **Programação Orientada a Objetos (POO)**. A versão anterior (estruturada) foi substituída por uma arquitetura modular baseada em classes e objetos.

## 🎯 Objetivos do CP2
- Substituir o uso de múltiplos `ArrayList` paralelos por coleções de objetos.
- Implementar os pilares de **Encapsulamento** e **Composição**.
- Criar uma hierarquia lógica entre Usuário, Playlists e Músicas.

## 🏗️ Modelagem das Classes

O projeto agora é composto por quatro classes principais:

1.  **`Musica.java`**:
    * **Atributos**: `titulo`, `artista`, `duracaoSegundos` e `genero`.
    * **Responsabilidade**: Gerencia os dados da faixa e fornece métodos de formatação (ex: converter segundos para `MM:SS`) e filtros de busca *case-insensitive*.

2.  **`Playlist.java`**:
    * **Atributos**: `nome` e uma lista (`ArrayList`) de objetos `Musica`.
    * **Responsabilidade**: Permite a agregação de músicas, remoção por índice e cálculo da duração total da lista.

3.  **`Usuario.java`**:
    * **Atributos**: `nome` e uma lista de objetos `Playlist`.
    * **Responsabilidade**: Representa o perfil do cliente, permitindo a criação e o gerenciamento de múltiplas playlists personalizadas.

4.  **`StreamingMusica.java`**:
    * **Responsabilidade**: Ponto de entrada do sistema (`main`). Orquestra o menu, o acervo geral de músicas e a interação com o usuário.

## 🛠️ Funcionalidades Implementadas
- **Cadastro de Acervo**: Adição de novas músicas ao banco de dados global.
- **Busca por Termo**: Localização de faixas por título ou artista (ignorando maiúsculas/minúsculas).
- **Gestão de Playlists**: Criação de listas, adição de músicas do acervo e exibição de detalhes.
- **Estatísticas de Áudio**: Cálculo de tempo total e identificação de gêneros.

## 🚀 Como Executar
1. Compile todos os arquivos:
   ```bash
   javac *.java
   ```
2. Execute a classe principal:
   ```bash
   java StreamingMusica
   ```
