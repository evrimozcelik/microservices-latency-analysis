#!/bin/bash
# Inspired from https://github.com/justb4/docker-jmeter
#
# Run JMeter Docker image with options

NAME="jmeter-server"
IMAGE="registry.eu-gb.bluemix.net/evrim/jmeter-server"

# Use the current working dir
WORK_DIR="`pwd`"

# Finally run
sudo docker stop ${NAME} > /dev/null 2>&1
sudo docker rm ${NAME} > /dev/null 2>&1
sudo docker run --name ${NAME} -i -v ${WORK_DIR}:${WORK_DIR} -w ${WORK_DIR} -p 1099:1099 -p 4000:4000 ${IMAGE} -D "server.rmi.localport=4000" -D "java.rmi.server.hostname=127.0.0.1" $@
