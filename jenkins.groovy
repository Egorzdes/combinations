pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                script {
                    // Проверяем, что Maven установлен
                    def mvnHome = tool name: 'Maven 3.x', type: 'maven'
                    echo "Maven tool home: ${mvnHome}"

                    // Проверяем, что JDK установлен
                    def jdkHome = tool name: 'JDK 1.8 (latest)', type: 'hudson.model.JDK'
                    echo "JDK tool home: ${jdkHome}"

                    // Обновляем пути для использования Maven и JDK
                    env.PATH = "${mvnHome}/bin:${jdkHome}/bin:${env.PATH}"
                }
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Проверяем, что Maven проект действительно содержит pom.xml
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
                    // Создаем архив с результатами билда
                    def outputFile = 'build_archive.zip'
                    sh "zip -r ${outputFile} target/"

                    // Артефакт, который будет доступен через интерфейс Jenkins
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