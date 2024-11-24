pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/EgorZdes/combinations.git'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Verify Build Artifacts') {
            steps {
                sh 'ls -l target/'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t combinations:latest .'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh '''
                docker stop combinations || true
                docker rm combinations || true
                docker run -d --name combinations -p 8080:8080 combinations:latest
                '''
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
