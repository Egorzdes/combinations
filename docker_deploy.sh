#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DOCKER_HOST="tcp://localhost:2375"
docker -H $DOCKER_HOST build -t $DOCKER_IMAGE_NAME -f Dockerfile .

if [ $? -ne 0 ]; then
    echo "Failed to build the Docker image. Exiting."
    exit 1
fi

docker -H $DOCKER_HOST run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME

if [ $? -ne 0 ]; then
    echo "Failed to run the Docker container. Exiting."
    exit 1
fi

echo "Docker container $DOCKER_CONTAINER_NAME is running."