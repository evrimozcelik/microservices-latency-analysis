#!/bin/bash
#
# Run JMeter script on Jmeter POD

JMETER_POD_NAME="jmeter-2150202267-g1vbh"
SERVICE_A_POD_NAME="microserviceapp-a-2063030179-zcvx6"
SERVICE_B_POD_NAME="microserviceapp-b-606931349-qmvf4"

# Prepare service
kubectl exec -it ${SERVICE_A_POD_NAME}  -- bash -c "cat /dev/null > /tmp/ServiceA.log"
kubectl exec -it ${SERVICE_B_POD_NAME}  -- bash -c "cat /dev/null > /tmp/ServiceB.log"

# Finally run
kubectl exec -it ${JMETER_POD_NAME}  -- rm -rf /tmp/jmeter-report
kubectl cp ../jmeter-script ${JMETER_POD_NAME}:/tmp/jmeter-script
kubectl exec -it ${JMETER_POD_NAME}  -- ./bin/jmeter.sh -n -t /tmp/jmeter-script/sample.jmx
rm -rf /tmp/jmeter-report
kubectl cp ${JMETER_POD_NAME}:/tmp/jmeter-report /tmp/jmeter-report

# Collect service performance logs
rm -rf /tmp/Service*-perf.log
kubectl exec -it ${SERVICE_A_POD_NAME}  -- bash -c "cat /tmp/ServiceA.log | grep 'ServiceA total elapsed time' > /tmp/ServiceA-perf.log"
kubectl exec -it ${SERVICE_B_POD_NAME}  -- bash -c "cat /tmp/ServiceB.log | grep 'ServiceB total elapsed time' > /tmp/ServiceB-perf.log"
kubectl cp ${SERVICE_A_POD_NAME}:/tmp/ServiceA-perf.log /tmp/ServiceA-perf.log
kubectl cp ${SERVICE_B_POD_NAME}:/tmp/ServiceB-perf.log /tmp/ServiceB-perf.log
