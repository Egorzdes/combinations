pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Предполагаем, что проект использует Maven для билда, можно заменить на нужный инструмент
                    if (fileExists('pom.xml')) {
                        sh 'mvn clean package'
                    } else {
                        error "Файл pom.xml не найден, убедитесь, что это Maven проект"
                    }
                }
            }
        }

        stage('Archive') {
            steps {
                script {
                    // Создаем архив c результатами билда
                    def outputFile = 'build_archive.zip'
                    sh "zip -r ${outputFile} target/"

                    // Артифакт, который будет доступен через интерфейс Jenkins
                    archiveArtifacts artifacts: outputFile
                }
            }
        }

    }

    post {
        always {
            // Всегда очищаем рабочую директорию после выполнения пайплайна
            cleanWs()
        }
    }
}