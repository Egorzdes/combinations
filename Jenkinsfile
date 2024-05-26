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
                    docker.run("${DOCKER_IMAGE_NAME}", "--name ${DOCKER_CONTAINER_NAME} -d")
                }
            }
        }
    }
}
