# preview-search-engine

Requires Kafka:
- download https://www.apache.org/dyn/closer.cgi?path=/kafka/2.2.0/kafka_2.12-2.2.0.tgz
- `tar -xf ...`
- run in the following script in its directory:

```
bin/zookeeper-server-start.sh config/zookeeper.properties &

sleep 10

bin/kafka-server-start.sh config/server.properties &

sleep 10

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic queries
```
