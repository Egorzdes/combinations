pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'git_cred', url: 'https://github.com/Egorzdes/combinations'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Execute Jenkins Groovy Script') {
            steps {
                script {
                    // Загрузка и выполнение Groovy-скрипта из указанного абсолютного пути
                    def scriptPath = "C:\\Users\\79332\\combinations\\jenkins\\jenkins.groovy"
                    def scriptContent = readFile(scriptPath).trim()
                    evaluate(scriptContent)
                }
            }
        }
    }
}