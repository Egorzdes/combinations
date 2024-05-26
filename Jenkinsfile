pipeline {
    agent any
    tools {
        maven 'M3' // Имя настройки Maven, как она задана в Jenkins (обычно что-то вроде "M3")
    }
    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean' // Очистка проекта
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package' // Сборка дистрибутива
            }
        }
         stage('Build') {
                    steps {
                        script {
                            def DOCKER_IMAGE_NAME = "myapp"
                            def DOCKER_CONTAINER_NAME = "myapp_container"
                            def DIST_PATH = "/var/jenkins_home/workspace/BUILD_JOB/"

                            echo "${DOCKER_IMAGE_NAME}"
                        }
                    }
                }
    }
}