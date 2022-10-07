# Encontro Técnico - Kafka
Material utilizado na apresentação do Encontro Técnico sobre Kafka.



## Instalação

O pessoal da Conduktor disponibiliza vários arquivos docker-compose para subir Kafka/Zookeeper com instâncias single/multiple (https://github.com/conduktor/kafka-stack-docker-compose).
Para a apresentação, utilizamos a seguinte cenário disponível no arquivo zk-single-kafka-multiple-kafdrop.yml:

- Single Zookeeper
- Multiple Kafka (3 brokers)
- Kakdrop (para gerenciamento)

Para executar os containers:

> docker-compose -f zk-single-kafka-multiple-cmak.yml up -d

E para encerrar a execução:

> docker-compose -f zk-single-kafka-multiple-cmak.yml stop
