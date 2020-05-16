Instruções para utilização da API:

- Para mostrar a tabela de preço basta digitar: http://localhost:8080/rest/pedagio/tabelaDePrecos


- Para realizar o pagamento do pedágio basta digitar: 
http://localhost:8080/rest/pedagio/{tipo_de_veículo}/{pagamento}/

- Caso o veiculo seja caminhão deve-se digitar:

http://localhost:8080/rest/pedagio/caminhao/{eixoAdicional}/{valorFornecido}


Operações do pedágio aceitas: fusca, moto, bike, onibus, e caminhao