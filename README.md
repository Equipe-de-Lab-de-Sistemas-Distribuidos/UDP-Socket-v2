# Execução via terminal WINDOWS
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
java -cp ".;../lib/*" ServerUDP.java _porta_
```
```
java -cp ".;../lib/*" ClientUDP.java _ip_ _porta_
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
java -cp ".;lib/*" ServerUDP.java _porta_
```
```
java -cp ".;lib/*" ClientUDP.java _ip_ _porta_
```
# Execução via terminal LINUX
Compilação
```
javac -cp "../lib/*" ServerUDP.java
```
```
javac -cp "../lib/*" ClientUDP.java
```
Execução
```
java -cp ".;../lib/*" ServerUDP.java _porta_
```
```
java -cp ".;../lib/*" ClientUDP.java _ip_ _porta_
```
ou
Compilação
```
javac -cp "/home/jonathan/Documentos/lab-SD/UDP-Socket-v2-main/lib/*" ServerUDP.java
```
Execução
```
java -cp "/home/jonathan/Documentos/lab-SD/UDP-Socket-v2-main/lib/*" ServerUDP.java _porta_
```
```
java -cp "/home/jonathan/Documentos/lab-SD/UDP-Socket-v2-main/lib/*" ClientUDP.java _ip_ _porta_
```
