# Execução via terminal
## Se lib estiver uma pasta antes do src
Compilação
```
javac -cp ".;../lib/*" ServerUDP.java
```
```
javac -cp ".;../lib/*" ClientUDP.java
```
Execução
```
java -cp ".;../lib/*" ServerUDP.java
```
```
java -cp ".;../lib/*" ClientUDP.java
```

## Se a lib estiver dentro da pasta src
Compilação
```
javac -cp ".;lib/*" ServerUDP.java
```
```
javac -cp ".;lib/*" ClientUDP.java
```
Execução
```
java -cp ".;lib/*" ServerUDP.java
```
```
java -cp ".;lib/*" ClientUDP.java
```
