pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Egorzdes/combinations'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                bat 'start /B cmd /c copy target\\BUILD.jar C:\\path\\to\\local\\deploy\\BUILD.jar'
            }
        }
    }
}