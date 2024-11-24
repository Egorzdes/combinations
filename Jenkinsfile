pipeline {
    agent any

    environment {
        IMAGE_NAME = "combinations"
        CONTAINER_NAME = "combinations"
        PORT = "8081"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/EgorZdes/combinations.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh '''
                echo "Building the project with Maven..."
                mvn clean package -DskipTests
                '''
            }
        }

        stage('Verify Build Artifacts') {
            steps {
                sh '''
                echo "Verifying build artifacts..."
                ls -l target/
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                echo "Building Docker image..."
                if [ ! -f target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar ]; then
                  echo "Error: JAR file not found in target/ directory."
                  exit 1
                fi
                docker build -t ${IMAGE_NAME}:latest .
                '''
            }
        }

        stage('Run Docker Container') {
            steps {
                sh '''
                echo "Stopping and removing any existing container..."
                docker stop ${CONTAINER_NAME} || true
                docker rm ${CONTAINER_NAME} || true

                echo "Running the new container..."
                docker run -d --name ${CONTAINER_NAME} -p ${PORT}:${PORT} ${IMAGE_NAME}:latest
                '''
            }
        }

        stage('Check Running Container') {
            steps {
                script {
                    echo "Checking if container is running..."
                    def isRunning = sh(script: "docker ps --filter 'name=${CONTAINER_NAME}' --format '{{.Names}}' | grep ${CONTAINER_NAME} || true", returnStatus: true)
                    if (isRunning != 0) {
                        error "Container '${CONTAINER_NAME}' is not running"
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            // cleanWs() // Временно отключено для сохранения файлов
        }
        success {
            echo "Pipeline completed successfully."
        }
        failure {
            echo "Pipeline failed. Please check logs for more details."
        }
    }
}
