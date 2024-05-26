#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"

DIST_PATH=$DIST_PATH_FROM_JOB

docker build -t $DOCKER_IMAGE_NAME .

docker run -d --name ${DOCKER_CONTAINER_NAME} -v ${DIST_PATH}:/app ${DOCKER_IMAGE_NAME}
echo "Docker контейнер успешно создан и запущен для деплоя вашего дистрибутива на пути: $DIST_PATH"