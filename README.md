# 🎵 Projeto Streaming de Música - Checkpoint 4

Este repositório apresenta a evolução do Sistema de Streaming, agora integrando conceitos avançados de Programação Orientada a Objetos para gerenciar diferentes tipos de usuários e experiências de reprodução.

## 🎯 Evoluções do CP4 (Herança e Polimorfismo)

Nesta etapa, o foco foi a especialização das classes e a reutilização de código:

- **Herança**: Implementação da classe base `Usuario` e suas subclasses `UsuarioFree` e `UsuarioPremium`.
- **Polimorfismo**: O método `reproduzirMusica()` foi sobrescrito para oferecer comportamentos distintos (anúncios para Free vs. Alta Qualidade para Premium).
- **Gestão de Acervo**: Melhorias na busca de músicas e gerenciamento de playlists por usuário.
- **Robustez**: Implementação de blocos `try-catch` no `main` para lidar com entradas inválidas do usuário durante o cadastro.

## 🛠️ Funcionalidades por Nível de Conta

### **Usuário Free**
- **Publicidade**: Exibe um anúncio a cada 3 músicas reproduzidas.
- **Limite de Playlists**: Restrito à criação de no máximo 3 playlists.

### **Usuário Premium**
- **Qualidade Superior**: Reprodução de áudio em alta fidelidade.
- **Download**: Funcionalidade exclusiva para baixar músicas para audição offline.
- **Sem Limites**: Criação ilimitada de playlists e sem interrupções publicitárias.

## 🏗️ Estrutura do Código (Trechos Relevantes)

### Polimorfismo na Prática
O método `reproduzirMusica` exemplifica como o sistema se comporta de forma diferente dependendo do objeto real em memória:

```java
// Em UsuarioFree.java
@Override
public void reproduzirMusica(Musica musica) {
    contadorReproducoes++;
    if (contadorReproducoes % 3 == 0) {
        exibirAnuncio(); 
    }
    super.reproduzirMusica(musica);
}

// Em UsuarioPremium.java
@Override
public void reproduzirMusica(Musica musica) {
    System.out.println("🎵 Reproduzindo em ALTA QUALIDADE: " + musica.getTitulo());
    this.historicoReproducao.add(musica);
}
