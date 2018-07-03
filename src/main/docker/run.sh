#!/bin/sh
echo "********************************************************"
echo "Starting the Trading Reporting Engine"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/jpmc/tradereporting/@project.build.finalName@-jar-with-dependencies.jar
