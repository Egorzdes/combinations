pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Шаг для получения исходного кода проекта из репозитория
                git 'https://github.com/Egorzdes/combinations'
            }
        }

        stage('Build') {
            steps {
                // Шаг для сборки проекта с использованием Maven
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                // Шаг для копирования собранного файла на локальную машину с использованием команды start /B
                bat 'start /B cmd /c copy target\\BUILD.jar C:\\path\\to\\local\\deploy\\BUILD.jar'
            }
        }
    }
}