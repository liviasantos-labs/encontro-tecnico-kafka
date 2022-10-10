# Encontro Técnico - Kafka
Material utilizado na apresentação do Encontro Técnico sobre Kafka.



## Instalação

O pessoal da Conduktor disponibiliza vários arquivos docker-compose para subir Kafka/Zookeeper com instâncias single/multiple (https://github.com/conduktor/kafka-stack-docker-compose).
Para a apresentação, utilizamos a seguinte cenário disponível no arquivo docker/zk-single-kafka-multiple-kafdrop.yml:

- Single Zookeeper
- Multiple Kafka (3 brokers)
- Kakdrop (para gerenciamento)

Para executar os containers:

> cd docker  
> docker-compose -f zk-single-kafka-multiple-kafdrop.yml up -d

Para visualizar se os containers subiram corretamente: 

> docker-compose -f zk-single-kafka-multiple-kafdrop.yml ps

Acesse o Kafdrop em http://localhost:9000.

Para encerrar a execução:

> docker-compose -f zk-single-kafka-multiple-kafdrop.yml stop
