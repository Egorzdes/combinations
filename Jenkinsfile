pipeline {
    agent any
    tools {
        maven 'M3'
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
                sh './docker_deploy'
            }
        }
    }
}