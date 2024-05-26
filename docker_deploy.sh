#!/bin/bash

# Переменные для настройки
DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"

# Путь к собранному дистрибутиву передается через переменные Jenkins
DIST_PATH=$DIST_PATH_FROM_JOB # Переменная, в которую Jenkins передает путь к дистрибутиву

# 1. Собираем Docker контейнер
docker build -t $DOCKER_IMAGE_NAME .

# 2. Запускаем Docker контейнер, монтируя собранный дистрибутив
docker run -d --name $DOCKER_CONTAINER_NAME -v $DIST_PATH:/app $DOCKER_IMAGE_NAME

# 3. В данном месте вы можете добавить необходимые дополнительные команды для деплоя

# Выводим информацию о выполненных действиях
echo "Docker контейнер успешно создан и запущен для деплоя вашего дистрибутива на пути: $DIST_PATH"