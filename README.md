Simple chat application implemented in Java 11.
Messages are persisted in the MySQL database,
chat functions are exposed through the REST API,
with following methods:
- /message 
- /group

Run it with:

`./gradlew bootRun`

Application exposes following REST URL: `http://localhost:8080/chatapp`
