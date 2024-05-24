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
                    // Изменим способ чтения файла и выполнения скрипта
                    def scriptPath = "jenkins/jenkins.groovy"
                    def scriptFile = new File(scriptPath)
                    def scriptContent = scriptFile.text.trim()
                    evaluate(scriptContent)
                }
            }
        }
    }
}