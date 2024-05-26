pipeline {
    agent any
    tools {
        maven 'M3' // Имя настройки Maven, как она задана в Jenkins (обычно что-то вроде "M3")
    }
    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean' // Очистка проекта
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package' // Сборка дистрибутива
            }
        }
        stage('Build') {
            steps {
                sh 'mvn install' // Сборка проекта
            }

            stage('Deploy') {
                        steps {
                            sh './docker_deploy' // Запуск скрипта docker_deploy.sh для деплоя
                        }
        }
    }
}