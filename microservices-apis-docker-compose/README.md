_** Microservices com Springboot e Docker **_

```**ATENÇÃO**

* Antes de construir o jar dos serviços você precisa configurar as váriaveis de ambientes que são: *

* consumerkey
* consumerSecret
* accessToken
* accessSecret

* Coloque as chaves em	tema-7-microservices / Twitter / src / main /  resources / application.properties```

Passo 1: Entre dentro da pasta do projeto e digite o comando abaixo para gerar o .jar:
         ./gradlew clean build
         
Passo 2: Na raíz do arquivo docker-compose.yml, execute "sudo docker-compose up" 

Acesse em:

*Integração Git e Twitter
		 http://localhost:8080/twitter/usuarioTwitter/github/usuarioGit
---------------------
*Twitter
		 http://localhost:8080/twitter/usuarioTwitter
----------------------
*GitHub
		 http://localhost:8080/github/usuarioGit
