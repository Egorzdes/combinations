#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DOCKER_HOST="tcp://localhost:2375"
DIST_PATH="/var/jenkins_home/workspace/BUILD_JOB/"

docker -H $DOCKER_HOST build -t $DOCKER_IMAGE_NAME $DIST_PATH
docker -H $DOCKER_HOST run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME