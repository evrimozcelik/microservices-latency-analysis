#!/bin/bash
#
# Run JMeter script on Jmeter POD

POD_NAME="jmeter-2150202267-g1vbh"

# Finally run
kubectl exec -it ${POD_NAME}  -- rm -rf /tmp/jmeter-report
kubectl cp ../jmeter-script ${POD_NAME}:/tmp/jmeter-script
kubectl exec -it ${POD_NAME}  -- ./bin/jmeter.sh -n -t /tmp/jmeter-script/sample.jmx 
rm -rf /tmp/jmeter-report
kubectl cp ${POD_NAME}:/tmp/jmeter-report /tmp/jmeter-report
