# 🎵 Projeto Streaming de Música - Checkpoint 5

Este repositório apresenta a evolução do Sistema de Streaming, agora focado na consolidação do polimorfismo avançado, validações de tipo em tempo de execução e proteção estrutural de código.

## 🎯 Evoluções do CP5 (Polimorfismo Avançado e Casting)

Nesta etapa, o sistema deixou de ser mono-utilizador e passou a gerir múltiplas contas simultaneamente através de estruturas polimórficas:

- **Listas Polimórficas**: Implementação de um `ArrayList<br.com.streaming.modelo.Usuario>` que unifica todos os tipos de conta, permitindo iterações genéricas.
- **Validação de Tipos (`instanceof`)**: Mecanismo implementado para separar o comportamento e gerar estatísticas precisas consoante o tipo de conta (Free ou Premium) na lista genérica.
- **Casting (Downcasting)**: Conversão segura de tipos de dados genéricos para tipos específicos, permitindo acesso a métodos exclusivos (ex: verificar o plano de um utilizador Premium).
- **Proteção de Código (`final`)**: Blindagem de métodos críticos de negócio (validação de e-mail) e classes topo de hierarquia para impedir heranças indesejadas.

## 🛠️ Novas Funcionalidades

### **Sistema Multi-Utilizador**
- Login dinâmico que altera o estado do sistema consoante o nível de acesso do utilizador selecionado.
- Menu segregado que reconhece e exibe a patente da conta ativa.

### **Playlists Automáticas (Herança)**
- **Critérios Inteligentes**: Geração de listas baseadas em parâmetros como "Top Mais Tocadas", "Recomendadas" e "Recentes".
- Atualização dinâmica varrendo o acervo global e adicionando os itens consoante a regra de negócio.

### **Estatísticas Globais**
- Relatório em tempo real do sistema, contabilizando a percentagem de reproduções divididas entre contas Free e Premium, além da contagem total de anúncios exibidos.

## 🏗️ Estrutura do Código (Trechos Relevantes)

### ArrayList Polimórfico e `instanceof`
O cálculo de estatísticas exemplifica a iteração sobre uma lista genérica e a identificação do objeto real em memória:

```java
// Em StreamingMusica.java
for (br.com.streaming.modelo.Usuario u : usuarios) {
    if (u instanceof UsuarioPremium) {
        premiumUsers++;
        premiumRep += u.getTotalReproducoes();
    } else if (u instanceof br.com.streaming.modelo.UsuarioFree) {
        freeUsers++;
        freeRep += u.getTotalReproducoes();
    }
}

🚀 Como Executar
Certifique-se de ter o JDK instalado.

Compile todos os ficheiros: javac *.java

Inicie a aplicação: java StreamingMusica
