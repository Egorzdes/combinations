pipeline {
    agent any
    tools {
        maven 'M3' // Имя настройки Maven, как она задана в Jenkins (обычно что-то вроде "M3")
    }
    stages {
        stage('---clean---') {
            steps {
                // Не нужно указывать путь вручную, Jenkins сам подставит правильный путь к maven
                sh 'mvn clean'
            }
        }
        stage('--package--') {
            steps {
                sh 'mvn package'
                script {
                    def version = sh(script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true).trim()
                    writeFile file: 'version.txt', text: version
                    echo "Собранная версия: ${version}"
                }
            }
        }
    }
}