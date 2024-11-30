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
                    // Убедитесь, что старый контейнер остановлен и удален
                    sh '''
                    docker stop combinations || true
                    docker rm combinations || true
                    docker run -d --name combinations combinations
                    '''
                }
            }
        }
        stage('Check Running Container') {
            steps {
                script {
                    // Проверяем, работает ли контейнер
                    echo "Checking if container 'combinations' is running..."
                    def isRunning = sh(script: "docker ps --filter 'name=combinations' --format '{{.Names}}' | grep combinations || true", returnStatus: true)
                    if (isRunning != 0) {
                        error "Container 'combinations' is not running."
                    } else {
                        echo "Container 'combinations' is running successfully."
                    }
                }
            }
        }
    }
}
