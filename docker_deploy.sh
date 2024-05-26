#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DIST_PATH="/var/jenkins_home/workspace/BUILD_JOB/"
DOCKER_PATH="/c/Program Files/Docker/Docker/resources/bin"
export PATH="$PATH:$DOCKER_PATH"
docker build -t $DOCKER_IMAGE_NAME $DIST_PATH
docker run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME