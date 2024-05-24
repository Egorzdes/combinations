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
                def scriptPath = "jenkins.groovy"
                def scriptContent = readFileFromWorkspace(scriptPath).trim()
                evaluate(scriptContent)
            }
        }

        stage('Checkout Branch') {
            steps {
                bat script: '"C:/Program Files/Git/bin/git.exe" checkout -b master a42338da2fd6c6c9ba769835c5d4a2464b93585d', returnStatus: true
            }
        }
    }
}