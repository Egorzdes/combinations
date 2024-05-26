pipeline {
    agent any

    environment {
        DOCKER_PATH = "/c/Program Files/Docker/Docker/resources/bin"
    }

    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    withEnv(["PATH+DOCKER=${env.DOCKER_PATH}"]) {
                        sh 'bash docker_deploy.sh'
                    }
                }
            }
        }
    }
}