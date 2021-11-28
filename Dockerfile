FROM openjdk:15
WORKDIR /app/
COPY src/*.java ./
COPY src/*.jar ./
ENV CLASSPATH=.:antlr-4.9.3-complete.jar
RUN javac -d ./ *.java