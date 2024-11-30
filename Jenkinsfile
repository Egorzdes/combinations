pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/EgorZdes/combinations.git'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t combinations .'
                }
            }
        }
        stage('Deploy Docker Container') {
            steps {
                script {
                    sh 'docker run -d --name combinations combinations'
                }
            }
        }
    }
}
