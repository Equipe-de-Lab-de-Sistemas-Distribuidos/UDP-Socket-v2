# Execução via terminal
## Se lib estiver uma pasta antes do src
Compilação
```
javac -cp ".;../lib/*" UDPServer.java
```
```
javac -cp ".;../lib/*" UDPClient.java
```
Execução
```
java -cp ".;../lib/*" UDPServer.java
```
```
java -cp ".;../lib/*" UDPClient.java
```

## Se a lib estiver dentro da pasta src
Compilação
```
javac -cp ".;lib/*" UDPServer.java
```
```
javac -cp ".;lib/*" UDPClient.java
```
Execução
```
java -cp ".;lib/*" UDPServer.java
```
```
java -cp ".;lib/*" UDPClient.java
```
