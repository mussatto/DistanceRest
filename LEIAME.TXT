Overview:

Este e um projeto multimodulos e utiliza o gradle para gestao de dependencia

DistanceCalculator
Contem as classes para calculo de distancia entre 2 pontos (latitude e longitude) no globo

DistanceCalculatorRest
Possui dependencia de DistanceCalculator e expoe as funcionalidades utilizando REST
Utiliza Spring MVC + Spring Boot para isto

How to Run:

Crie um BD mysql, utilizando como referencia o script em scripts/setup_docker.sh

./gradlew compileJava

./gradlew build

java -jar DistanceCalculatorRest/build/libs/DistanceCalculatorRest-1.0.war

abrir o browser em : http://localhost:8080/