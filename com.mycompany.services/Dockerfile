FROM maven:3.3.9-jdk-8-alpine

# Install extra packages
# Change TimeZone
ARG TZ="Europe/Istanbul"
RUN apk update
RUN apk add --update openjdk8-jre tzdata curl unzip bash
# Clean APK cache
RUN rm -rf /var/cache/apk/*

COPY . /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["/app/entrypoint.sh"]
