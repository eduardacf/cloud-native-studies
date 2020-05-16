Instruções para Deploy com TomCat do Tema 01 - Calculadora com Spring :)


1. Acesse o diretório onde está a calculadora (tema-3-CalculadoraSpring_TomCat)

2. Dentro do diretório, digite o comando `` `gradle wrapper` `` seguido por ` ./gradlew clean build`  dentro da pasta do projeto.

3. Vá para a pasta ~ / build / libs, onde você encontrará o arquivo {project_name} .war

4. Copie este arquivo para a pasta ** webbapps ** dentro do seu diretório principal do tomcat

5. Inicie o servidor entrando na pasta onde o foi descompactado e digite no terminal "java -jar start.jar"

6. Acesse a pasta bin onde o foi descompactado e digite no terminal "./catalina.sh start"

Para utilizar a calculadora, acesse via URL seguindo o exemplo abaixo:
http://localhost:8080/Gradle___tema_3_CalculadoraSpring__TomCat_1_0_SNAPSHOT_war/calculadora?valor1=10&valor2=2&operador=dividir

- Operações aceitas: somar / dividir / subtrair / multiplicar / potenciacao

