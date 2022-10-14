# Encontro Técnico - Kafka
Material utilizado na apresentação do Encontro Técnico sobre Kafka.



## Instalação

O pessoal da Conduktor disponibiliza vários arquivos docker-compose para subir Kafka/Zookeeper com instâncias single/multiple (https://github.com/conduktor/kafka-stack-docker-compose).
Para a apresentação, utilizamos a seguinte cenário disponível no arquivo docker/zk-single-kafka-single-cmak.yml:

- 1 instância Zookeeper
- 1 instância Kafka (1 broker)
- 1 instância de CMAK (para gerenciamento do cluster Kafka)

Para executar os containers:

> cd docker  
> docker-compose -f zk-single-kafka-single-cmak.yml up -d

Para visualizar se os containers subiram corretamente: 

> docker-compose -f zk-single-kafka-single-cmak.yml ps

Acesse o Kafdrop em http://localhost:9000.

Para encerrar a execução:

> docker-compose -f zk-single-kafka-single-cmak.yml stop
