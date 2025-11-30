# 🧶 Artes da Dell - E-commerce Orientado a Eventos (EDA)

Sistema de vendas distribuído utilizando arquitetura de microsserviços. O projeto demonstra o desacoplamento entre a venda (API) e o processamento de estoque (Worker) através de mensageria assíncrona.

## 🚀 Arquitetura da Solução

1.  **api-vendas (Producer):** API REST Spring Boot que recebe o pedido, salva o estado inicial ("AGUARDANDO") e publica um evento no RabbitMQ.
2.  **RabbitMQ (Broker):** Garante a entrega da mensagem e o desacoplamento temporal (a API não trava esperando o estoque).
3.  **worker-estoque (Consumer):** Microsserviço (Spring Boot) que processa a fila, simula a baixa de estoque e atualiza o status do pedido no banco ("APROVADO").
4.  **MySQL:** Banco de dados compartilhado (para fins didáticos) rodando em Docker.

## 🛠️ Stack Tecnológica
- **Java 21** (LTS)
- **Spring Boot 3.2**
- **Spring AMQP** (RabbitMQ)
- **Docker & Docker Compose** (Infraestrutura)
- **Spotless** (Linting/Formatação Automática)

## 📦 Como Rodar

O ambiente é 100% containerizado.

### 1. Subir a Infraestrutura
```bash
docker compose up --build
