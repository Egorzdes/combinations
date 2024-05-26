pipeline {
    agent any
    tools {
        maven 'M3' // Имя настройки Maven, как она задана в Jenkins (обычно что-то вроде "M3")
    }
    stages {
        stage('---clean---') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('--package--') {
            steps {
                sh 'mvn package'
                script {
                    def version = sh(script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true).trim()
                    echo "Текущая версия дистрибутива: ${version}"

                    // Увеличение версии на 1
                    def parts = version.tokenize('.')
                    def mainVersion = parts[0]
                    def subVersion = parts[1]
                    def newVersion = mainVersion + '.' + (subVersion as Integer + 1).toString()
                    echo "Новая версия дистрибутива: ${newVersion}"

                    env.BUILD_VERSION = newVersion // Сохраняем новую версию в переменной BUILD_VERSION
                }
            }
        }
        stage('--build-dist--') {
            steps {
                sh 'mvn install' // Собираем дистрибутив
            }
        }
    }
    post {
        always {
            // Обновляем значение BUILD_VERSION после окончания сборки
            script {
                currentBuild.build.variable('BUILD_VERSION', env.BUILD_VERSION)
            }
        }
    }
}