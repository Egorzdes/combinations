#!/bin/bash

DOCKER_IMAGE_NAME="myapp"
DOCKER_CONTAINER_NAME="myapp_container"
DIST_PATH="/var/jenkins_home/workspace/BUILD_JOB/"
DOCKER_PATH="/usr/bin/docker"
echo "Путь к Docker: $DOCKER_PATH"
cd $DIST_PATH
"$DOCKER_PATH" build -t $DOCKER_IMAGE_NAME - <<EOF
FROM scratch
ADD . /
EOF

if [ $? -ne 0 ]; then
    echo "Failed to build the Docker image. Exiting."
    exit 1
fi

"$DOCKER_PATH" run -d --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME
if [ $? -ne 0 ]; then
    echo "Failed to run the Docker container. Exiting."
    exit 1
fi

echo "Docker container $DOCKER_CONTAINER_NAME is running."