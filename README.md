## kafka (docker) && spring boot connect

## Send Kafka Message

### run zookeeper && kafka
```shell
docker run -d --name zookeeper --network kafka-network -p 2181:2181 -e ZOOKEEPER_CLIENT_PORT=2181 confluentinc/cp-zookeeper:latest

docker run -d --name kafka --network kafka-network -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT -v /path/to/local/kafka-logs:/kafka-logs confluentinc/cp-kafka:latest

docker exec -it kafka /bin/bash -c "kafka-topics --create --topic kafka_topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1"

```

### spring boot kafka dependency
```ruby
implementation 'org.springframework.kafka:spring-kafka'
```

## API
- POST /send?message=HelloKafka