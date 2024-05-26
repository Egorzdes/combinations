#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DIST_PATH="/var/jenkins_home/workspace/BUILD_JOB/"
DOCKER_PATH="/usr/bin/docker"
echo "Путь к Docker: $DOCKER_PATH"
if [ ! -f "$DIST_PATH/Dockerfile" ]; then
    echo "Dockerfile not found in $DIST_PATH"
    exit 1
fi
sudo service docker start
"$DOCKER_PATH" build -t $DOCKER_IMAGE_NAME $DIST_PATH
"$DOCKER_PATH" run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME