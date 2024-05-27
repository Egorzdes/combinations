#!/bin/bash

DOCKER_IMAGE_NAME="proj"
DOCKER_CONTAINER_NAME="myapp_container"
DIST_PATH="/mnt/c/Users/79332/Downloads/jenkins_docker/jenkins_home/workspace/BUILD_JOB"

docker build -t $DOCKER_IMAGE_NAME -f $DIST_PATH/Dockerfile $DIST_PATH
docker run -d --rm --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME
