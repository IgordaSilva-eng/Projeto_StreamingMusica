# 🎵 Projeto Streaming de Música - Checkpoint 1

Este repositório contém a versão inicial do Sistema de Streaming de Música, desenvolvida utilizando o paradigma de **Programação Estruturada** em Java. O foco desta etapa foi a manipulação de coleções dinâmicas e lógica de repetição e condicionais.

## 🎯 Objetivos do CP1
- Implementar um sistema de CRUD básico (Criar, Ler, Buscar) em memória.
- Utilizar `ArrayList` para armazenamento dinâmico de dados.
- Praticar a modularização através de métodos estáticos.
- Aplicar validações de dados e tratamento de exceções simples.

## 🏗️ Estrutura de Dados
Nesta versão inicial, os dados são gerenciados através de **ArrayLists paralelos**, onde o índice `i` correlaciona as informações em todas as listas:
- `titulos`: Armazena o nome das músicas (String).
- `artistas`: Armazena o nome dos artistas (String).
- `duracoes`: Armazena o tempo em segundos (Integer).
- `generos`: Armazena a categoria musical (String).

## 🛠️ Funcionalidades Implementadas
- **Cadastro com Validação**: Entrada de dados com verificação de campos vazios, durações negativas e validação de gênero contra uma lista fixa de opções permitidas.
- **Listagem Formatada**: Exibição de todas as músicas cadastradas com conversão de segundos para o formato `MM:SS`.
- **Busca Multicritério**:
  - Busca por título (Contendo o termo e ignorando maiúsculas/minúsculas).
  - Busca por artista (Contendo o termo e ignorando maiúsculas/minúsculas).
  - Busca por gênero (Comparação exata).
- **Módulo de Estatísticas**:
  - Cálculo de média de duração do acervo.
  - Identificação do gênero predominante (mais frequente) no sistema.

## 🚀 Como Executar
1. Certifique-se de ter o Java instalado.
2. Compile o arquivo:
   ```bash
   javac StreamingMusicaAluno.java
   ```
3. Execute a aplicação:
   ```bash
   java StreamingMusicaAluno
   ```

## 📝 Lições Aprendidas
- Dificuldade de manutenção ao utilizar múltiplos arrays para representar uma única entidade.
- Importância do tratamento de `NumberFormatException` ao ler entradas numéricas do usuário.
- Uso de `StringBuilder` e métodos de String como `.repeat()` para formatação de interface no console.

**Status do Projeto:** Finalizado (Checkpoint 1)
*Nota: Este código servirá de base para a refatoração para POO no próximo checkpoint.*

### 💡 Próximo Passo:
Se você já estiver movendo para o CP2, lembre-se de que a principal mudança será criar uma classe `Musica` para substituir esses quatro `ArrayList` por apenas um: `ArrayList<Musica>`.
