### Excute this
```
mvn test
```

run specific example
```
mvn test -Dtest=WordCountFromElementsStringTest
```

run in debug mode
```
mvn test -Dmaven.surefire.debug
```


### Classpath example
```
export CP_ROOT=~/.m2/repository/
export CP=${CP_ROOT}/org/apache/flink/flink-java/0.9.1/flink-java-0.9.1.jar:\
${CP_ROOT}/org/apache/flink/flink-shaded-include-yarn/0.9.1/flink-shaded-include-yarn-0.9.1.jar:\
${CP_ROOT}/org/apache/avro/avro/1.7.6/avro-1.7.6.jar:\
${CP_ROOT}/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:\
${CP_ROOT}/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:\
${CP_ROOT}/com/thoughtworks/paranamer/paranamer/2.3/paranamer-2.3.jar:\
${CP_ROOT}/org/xerial/snappy/snappy-java/1.0.5/snappy-java-1.0.5.jar:\
${CP_ROOT}/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:\
${CP_ROOT}/org/tukaani/xz/1.0/xz-1.0.jar:\
${CP_ROOT}/com/esotericsoftware/kryo/kryo/2.24.0/kryo-2.24.0.jar:\
${CP_ROOT}/com/esotericsoftware/minlog/minlog/1.2/minlog-1.2.jar:\
${CP_ROOT}/org/objenesis/objenesis/2.1/objenesis-2.1.jar:\
${CP_ROOT}/com/twitter/chill_2.10/0.5.2/chill_2.10-0.5.2.jar:\
${CP_ROOT}/org/scala-lang/scala-library/2.10.4/scala-library-2.10.4.jar:\
${CP_ROOT}/com/twitter/chill-java/0.5.2/chill-java-0.5.2.jar:\
${CP_ROOT}/com/twitter/chill-avro_2.10/0.5.2/chill-avro_2.10-0.5.2.jar:\
${CP_ROOT}/com/twitter/chill-bijection_2.10/0.5.2/chill-bijection_2.10-0.5.2.jar:\
${CP_ROOT}/com/twitter/bijection-core_2.10/0.7.2/bijection-core_2.10-0.7.2.jar:\
${CP_ROOT}/com/twitter/bijection-avro_2.10/0.7.2/bijection-avro_2.10-0.7.2.jar:\
${CP_ROOT}/de/javakaffee/kryo-serializers/0.27/kryo-serializers-0.27.jar:\
${CP_ROOT}/joda-time/joda-time/2.5/joda-time-2.5.jar:\
${CP_ROOT}/org/apache/commons/commons-lang3/3.3.2/commons-lang3-3.3.2.jar:\
${CP_ROOT}/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:\
${CP_ROOT}/org/slf4j/slf4j-log4j12/1.7.7/slf4j-log4j12-1.7.7.jar:\
${CP_ROOT}/log4j/log4j/1.2.17/log4j-1.2.17.jar:\
${CP_ROOT}/org/apache/flink/flink-core/0.9.1/flink-core-0.9.1.jar:\
${CP_ROOT}/commons-collections/commons-collections/3.2.1/commons-collections-3.2.1.jar:\
${CP_ROOT}/org/apache/flink/flink-streaming-core/0.9.1/flink-streaming-core-0.9.1.jar:\
${CP_ROOT}/org/apache/flink/flink-runtime/0.9.1/flink-runtime-0.9.1.jar:\
${CP_ROOT}/com/amazonaws/aws-java-sdk/1.8.1/aws-java-sdk-1.8.1.jar:\
${CP_ROOT}/commons-logging/commons-logging/1.1.1/commons-logging-1.1.1.jar:\
${CP_ROOT}/org/apache/httpcomponents/httpclient/4.2/httpclient-4.2.jar:\
${CP_ROOT}/org/apache/httpcomponents/httpcore/4.2/httpcore-4.2.jar:\
${CP_ROOT}/commons-codec/commons-codec/1.3/commons-codec-1.3.jar:\
${CP_ROOT}/com/fasterxml/jackson/core/jackson-core/2.1.1/jackson-core-2.1.1.jar:\
${CP_ROOT}/com/fasterxml/jackson/core/jackson-databind/2.1.1/jackson-databind-2.1.1.jar:\
${CP_ROOT}/com/fasterxml/jackson/core/jackson-annotations/2.1.1/jackson-annotations-2.1.1.jar:\
${CP_ROOT}/io/netty/netty-all/4.0.27.Final/netty-all-4.0.27.Final.jar:\
${CP_ROOT}/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:\
${CP_ROOT}/org/codehaus/jettison/jettison/1.1/jettison-1.1.jar:\
${CP_ROOT}/stax/stax-api/1.0.1/stax-api-1.0.1.jar:\
${CP_ROOT}/com/typesafe/akka/akka-actor_2.10/2.3.7/akka-actor_2.10-2.3.7.jar:\
${CP_ROOT}/com/typesafe/config/1.2.1/config-1.2.1.jar:\
${CP_ROOT}/com/typesafe/akka/akka-remote_2.10/2.3.7/akka-remote_2.10-2.3.7.jar:\
${CP_ROOT}/io/netty/netty/3.8.0.Final/netty-3.8.0.Final.jar:\
${CP_ROOT}/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:\
${CP_ROOT}/org/uncommons/maths/uncommons-maths/1.2.2a/uncommons-maths-1.2.2a.jar:\
${CP_ROOT}/com/typesafe/akka/akka-slf4j_2.10/2.3.7/akka-slf4j_2.10-2.3.7.jar:\
${CP_ROOT}/org/clapper/grizzled-slf4j_2.10/1.0.2/grizzled-slf4j_2.10-1.0.2.jar:\
${CP_ROOT}/com/github/scopt/scopt_2.10/3.2.0/scopt_2.10-3.2.0.jar:\
${CP_ROOT}/io/dropwizard/metrics/metrics-core/3.1.0/metrics-core-3.1.0.jar:\
${CP_ROOT}/io/dropwizard/metrics/metrics-jvm/3.1.0/metrics-jvm-3.1.0.jar:\
${CP_ROOT}/io/dropwizard/metrics/metrics-json/3.1.0/metrics-json-3.1.0.jar:\
${CP_ROOT}/org/apache/commons/commons-math/2.2/commons-math-2.2.jar:\
${CP_ROOT}/org/apache/sling/org.apache.sling.commons.json/2.0.6/org.apache.sling.commons.json-2.0.6.jar:\
${CP_ROOT}/org/apache/flink/flink-clients/0.9.1/flink-clients-0.9.1.jar:\
${CP_ROOT}/org/apache/flink/flink-optimizer/0.9.1/flink-optimizer-0.9.1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-server/8.0.0.M1/jetty-server-8.0.0.M1.jar:\
${CP_ROOT}/org/mortbay/jetty/servlet-api/3.0.20100224/servlet-api-3.0.20100224.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-continuation/8.0.0.M1/jetty-continuation-8.0.0.M1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-http/8.0.0.M1/jetty-http-8.0.0.M1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-io/8.0.0.M1/jetty-io-8.0.0.M1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-util/8.0.0.M1/jetty-util-8.0.0.M1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-security/8.0.0.M1/jetty-security-8.0.0.M1.jar:\
${CP_ROOT}/org/eclipse/jetty/jetty-servlet/8.0.0.M1/jetty-servlet-8.0.0.M1.jar:\
${CP_ROOT}/commons-fileupload/commons-fileupload/1.3.1/commons-fileupload-1.3.1.jar:\
${CP_ROOT}/commons-io/commons-io/2.4/commons-io-2.4.jar:\
${CP_ROOT}/commons-cli/commons-cli/1.2/commons-cli-1.2.jar

```

