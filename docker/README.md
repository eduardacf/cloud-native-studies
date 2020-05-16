<h4>Calculadora Spring com Docker</h4>


1.Construa um .war com Gradle ```sh
                              ./gradlew clean build ```     
                                                       
2.Você tem que estar no diretório correto.

3.Construa seu contêiner
  `` sh
  docker build -t <nome_imagem>.
  `` 
  
4.Execute o contêiner docker
    ```sh execução do docker --name <run_name_image> -it -p 8080: 8080 <name_image> ``` 
                                                              

* Para acessar a calculadora basta digitar: http://localhost:8080/Gradle___tema_6_Docker_1_0_SNAPSHOT_war/calculadora?valor1=PRIMEIROVALOR&valor2=SEGUNDOVALOR&operador=OPERACAOREALIZADA

    Exemplo:

http://localhost:8080/Gradle___tema_6_Docker_1_0_SNAPSHOT_war/calculadora?valor1=6&valor2=3&operador=dividir


Saida:
Primeiro Valor: 6
Segundo Valor:3
Operação: dividir
Result: 2.0 
Historico: Divisão[Valor1: 6.0 Valor2: 3.0 Resultado: 2.0]






 ``` Operações aceitas: somar / dividir / subtrair / multiplicar / potenciacao``` 
