#!/bin/bash

echo "START Running com.mycompany.services on `date`"
echo "java args=$@"

java -jar $@ target/*.war
