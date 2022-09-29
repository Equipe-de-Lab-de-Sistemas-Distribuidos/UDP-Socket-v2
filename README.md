# Execução via terminal
## Se lib estiver uma pasta antes do src
Compilação
```
javac -cp ".;../lib/*" ServerUDP.java _porta_
```
```
javac -cp ".;../lib/*" ClientUDP.java _ip_ _porta_
```
Execução
```
java -cp ".;../lib/*" ServerUDP.java _porta_
```
```
java -cp ".;../lib/*" ClientUDP.java _ip_ _porta_
```

## Se a lib estiver dentro da pasta src
Compilação
```
javac -cp ".;lib/*" ServerUDP.java _porta_
```
```
javac -cp ".;lib/*" ClientUDP.java _ip_ _porta_
```
Execução
```
java -cp ".;lib/*" ServerUDP.java _porta_
```
```
java -cp ".;lib/*" ClientUDP.java _ip_ _porta_
```
