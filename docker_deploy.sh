#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DOCKER_HOST="tcp://localhost:2375"  # Хост и порт, через который осуществляется обращение к Docker демону
DIST_PATH="/var/jenkins_home/workspace/BUILD_JOB/"
DOCKER_PATH="C:/Program Files/Docker/Docker/resources/bin/docker.exe"  # Путь к исполняемому файлу Docker

export PATH=$PATH:"$DOCKER_PATH"
"$DOCKER_PATH" build -t $DOCKER_IMAGE_NAME $DIST_PATH
"$DOCKER_PATH" run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME