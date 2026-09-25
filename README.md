# Sistema de Assinaturas de Streaming

Trabalho da disciplina **Projeto e Arquitetura de Sistemas** — Prof. Américo Sampaio (UNIFOR).
Aluno: Gabriel Catter Figueiredo de Alencar (individual — 1 cadastro).

## Como executar

```bash
cd src
javac Main.java model/Plano.java factory/PlanoFactory.java repository/PlanoRepository.java controller/PlanoController.java -d ../bin
cd ../bin
java Main
```

## O que o sistema faz

Cadastro de **Planos de assinatura de streaming**, com as 4 operações de CRUD via menu no console:
1. Cadastrar (Create) — nome do plano, preço mensal, quantidade de assinantes
2. Listar (Read) — mostra todos os planos, com a receita mensal calculada
3. Atualizar (Update)
4. Remover (Delete)

## Estrutura do código

```
src/
├── Main.java                     -> interface (menu no console)
├── model/Plano.java              -> entidade Plano de assinatura
├── factory/PlanoFactory.java     -> criação/validação de Plano
├── repository/PlanoRepository.java -> armazenamento (Singleton) + CRUD
└── controller/PlanoController.java -> intermediário entre Main e Repository
```

## Padrões utilizados

### GRASP

**1. Creator (Criador)** — `PlanoRepository`
O Repository é quem agrega/armazena a coleção de planos, então, seguindo a regra do Creator
(quem contém os objetos deve criá-los), é ele quem é responsável por instanciar novos planos
através do método `criar()`.

**2. Controller** — `PlanoController`
Recebe as chamadas vindas da interface (`Main`) e as delega para o `PlanoRepository`. Isso
desacopla a camada de apresentação da lógica de acesso a dados — se a interface mudar de console
para web, por exemplo, o Controller não precisa mudar.

*(Bônus, também presente no código): Expert — `Plano.calcularReceitaMensal()`, onde o próprio
objeto que possui os dados (preço mensal e quantidade de assinantes) é responsável por calcular
sua receita mensal.)*

### GoF

**1. Singleton** — `PlanoRepository`
O construtor é privado e a única forma de obter a instância é via `getInstance()`, garantindo que
exista apenas um repositório de planos em toda a aplicação (uma única fonte de verdade dos dados).

**2. Factory Method** — `PlanoFactory`
Centraliza a criação e a validação dos objetos `Plano` (nome não vazio, preço mensal e quantidade
de assinantes não negativos) em um único ponto, em vez de espalhar essa lógica pelo Controller ou
pela interface.

## Prints de tela

As imagens em `/prints` mostram, em ordem: cadastro de planos (Create), listagem (Read) e
atualização + remoção (Update/Delete).
