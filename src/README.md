# 🎵 Projeto Streaming de Música - Checkpoint 3

Este repositório apresenta o Sistema de Streaming refatorado com foco em **Encapsulamento** e **Integridade de Dados**.

## 🎯 Evoluções do CP3
- **Atributos Privados**: Garantia de que o estado interno das classes só seja acessado via métodos autorizados.
- **Validação de Setters**: Bloqueio de valores nulos, vazios ou fora do intervalo lógico (ex: duração > 1h).
- **Sobrecarga de Construtores**: Flexibilidade na criação de objetos utilizando a palavra-chave `this()`.
- **Tratamento de Exceções**: Uso de `IllegalArgumentException` para impedir a criação de objetos corrompidos.

## 🛠️ Regras de Validação Aplicadas
- **Musica**: Título/Artista obrigatórios; Duração entre 1 e 3599s; Gênero validado por lista predefinida.
- **Playlist/Usuario**: Nomes não podem ser nulos ou vazios.

## 🚀 Como Executar
1. Compile: `javac *.java`
2. Execute: `java StreamingMusica`