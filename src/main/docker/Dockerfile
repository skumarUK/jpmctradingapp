FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/jpmc/tradereporting/
ADD @project.build.finalName@-jar-with-dependencies.jar /usr/local/jpmc/tradereporting/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh


