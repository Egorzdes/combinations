pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Egorzdes/combinations'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Execute Jenkins Groovy Script') {
            steps {
                sh 'cat jenkins.groovy' // Здесь уточните путь к файлу jenkins.groovy в репозитории
            }
        }
    }
}