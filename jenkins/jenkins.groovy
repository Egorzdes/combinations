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
    }
}