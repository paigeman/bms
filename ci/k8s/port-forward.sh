#!/bin/bash

DEPLOYMENT_NAME="bms"  # 要监视的 Deployment 名称
CONTAINER_NAME="bms"  # 要监视的容器名称
COMMAND=  # 要执行的命令

while true; do
    STATUS=$(kubectl get pods -l app=$DEPLOYMENT_NAME -o jsonpath="{.items[0].status.containerStatuses[?(@.name=='$CONTAINER_NAME')].ready}")

    if [[ $STATUS == "true" ]]; then
        echo "Container is running. Executing command..."
        nohup kubectl port-forward deployment/bms 8080:8080 --address=$PORT_FORWARD_HOST > port-forward.log 2>&1 &
        echo $! > save_pid.txt
        # 因为只有一个ip，而ingress没有外部ip
        nohup kubectl port-forward deployment/ingress-nginx-controller -n ingress-nginx 443:443 --address=$PORT_FORWARD_HOST > ingress-port-forward.log 2>&1 &
        echo $! > ingress_save_pid.txt
        break
    fi

    echo "Container is not running. Waiting..."
    sleep 1
done