# Otimização Estratégica de Performance: Rede Alura Store
---

Este projeto foi desenvolvido como parte do **Challenge 1 de Data Science** do programa **Alura + Oracle Next Education (ONE)**. O objetivo consiste em analisar os dados de vendas, métricas de eficiência logística e índices de satisfação de quatro unidades operacionais da rede *Alura Store*. O intuito é fornecer uma recomendação estratégica fundamentada sobre qual filial deve ser alienada para viabilizar um novo empreendimento para o investidor, o Senhor João.

---

## Tecnologias e Ferramentas Utilizadas

* **Python** (Ambiente gerenciado e isolado via Anaconda)
* **Pandas**: Engenharia de atributos, consolidação de matrizes de dados e agregações estatísticas.
* **Matplotlib**: Construção de visualizações de séries temporais, dispersão com densidade, barras e setores.
* **Jupyter Notebook / VS Code**: Ecossistema de desenvolvimento e documentação.

---

## Metodologia e Boas Práticas (Refatoração de Código)

O projeto original foi completamente refatorado para incorporar padrões profissionais de Engenharia de Dados:
* **Princípio DRY (*Don't Repeat Yourself*):** Substituição de estruturas de leitura repetitivas por loops automatizados e mapeamento dinâmico de strings.
* **Consolidação Imparcial:** Injeção de identificadores exclusivos por unidade antes da unificação dos DataFrames (`pd.concat`), mitigando distorções geográficas de faturamento e isolando a performance real de cada loja.
* **Estatística Descritiva Avançada:** Implementação de cálculos de desvio padrão e análise de dispersão para avaliar a volatilidade da experiência do usuário, indo além de médias aritméticas simples.

---

## Relatório Executivo de Negócios

### 1. Resumo Macroeconômico da Rede
A rede varejista consolidou um faturamento bruto histórico de **R$ 5.871.490,79**. As divisões de *Eletrônicos* e *Eletrodomésticos* representam a maior fatia das receitas agregadas da holding, enquanto a categoria de *Móveis* retém o maior volume absoluto em unidades comercializadas.

### 2. Diagnóstico Técnico de Ineficiência: O Caso da Loja 1
A análise cruzada de dados aponta que a **Loja 1** é a unidade de menor eficiência sistêmica e de maior risco de manutenção para a holding devido a três vulnerabilidades críticas:

#### A. Estagnação Temporal de Receita
O estudo cronológico mensal evidenciou uma linha de tendência descendente e estagnada para a Loja 1 nos trimestres de fechamento, carecendo do mesmo vigor de recuperação sazonal ou picos de crescimento manifestados pelas Lojas 2, 3 e 4.

![Evolução Temporal do Faturamento](evolucao_temporal.png)

#### B. Fricção Logística Extrema (Custo do Frete)
A Loja 1 opera com o maior frete médio nominal da rede (**R$ 34,69**). A análise de dispersão e densidade estatística provou que esta unidade possui a maior concentração de custos logísticos abusivos em relação ao preço de face do produto, gerando uma severa barreira de conversão e insatisfação no fechamento da compra.

![Impacto do Frete na Avaliação](dispersao_frete_avaliacao.png)

#### C. Instabilidade de Satisfação (Volatilidade de Notas)
Além de registrar a menor nota média da rede (**3.98**), a aplicação do cálculo de desvio padrão revelou forte dispersão nas avaliações. Como demonstrado pelas linhas de erro no gráfico abaixo, isso indica alta volatilidade na jornada do consumidor (atendimentos severamente ruins misturados a ótimos), sinalizando gargalos operacionais ou logísticos crônicos na consistência da operação.

![Estabilidade e Média de Avaliação por Loja](estabilidade_avaliacoes.png)

---

### 3. Parecer Estratégico Final

> **Direcionamento:** Orientação técnica para prosseguir com a **venda imediata da Loja 1**.

A desmobilização do ativo estanca o dreno de eficiência logística da rede, remove a operação com pior índice de fidelização de clientes e converte ativos estagnados em liquidez financeira imediata. Esse capital liberado fornecerá o lastro ideal e seguro para a fundação do novo empreendimento do investidor, sem comprometer a saúde das demais unidades que sustentam trações saudáveis.

---
*Relatório técnico gerado para subsídio de tomada de decisão executiva.*


## ✨ Autora

**Leticia Heeren**
Estudante de tecnologia | Formação Oracle Next Education (ONE) + Alura

[![GitHub](https://img.shields.io/badge/GitHub-LeticiaHeeren-181717?style=flat&logo=github)](https://github.com/LeticiaHeeren)

---

*Projeto desenvolvido para fins educacionais como parte do programa Oracle Next Education.*