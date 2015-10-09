Overview:

This is a multi-module project that uses gradle for depency management

DistanceCalculator
Contain classes for distance calculations between 2 cities (using latitude and longitude)

DistanceCalculatorRest
Contains dependency for DistanceCalculator and exposes the functonalities using REST
Uses Spring MVC + Sprint Boot for this

How to Run:

Create a mysql database, using the script as reference scripts/setup_docker.sh

./gradlew compileJava

./gradlew build

java -jar DistanceCalculatorRest/build/libs/DistanceCalculatorRest-1.0.war

open the browser in: http://localhost:8080/

I decided to use haversine formula because from research:
The haversine formula ‘remains particularly well-conditioned for numerical computa­tion even at small distances’ – unlike calculations based on the spherical law of cosines.
