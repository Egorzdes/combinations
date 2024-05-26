pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'myapp'
        DOCKER_CONTAINER_NAME = 'myapp_container'
    }

    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}")
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
                    // Stop and remove any existing container with the same name
                    sh "docker stop ${DOCKER_CONTAINER_NAME} || true"
                    sh "docker rm ${DOCKER_CONTAINER_NAME} || true"

                    // Run the new Docker container
                    def dockerImage = docker.image("${DOCKER_IMAGE_NAME}")
                    dockerImage.run("-d --name ${DOCKER_CONTAINER_NAME}")
                }
            }
        }
    }
}
