FROM maven:3.3.9-jdk-8-alpine
COPY . /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["/app/custom-entrypoint.sh"]
CMD java -jar target/*.war
