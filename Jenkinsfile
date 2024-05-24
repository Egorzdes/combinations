pipeline {
    agent any
    tools {
        maven 'M3' // Имя настройки Maven, как она задана в Jenkins (обычно что-то вроде "M3")
    }
    stages {
        stage('---clean---') {
            steps {
                // Не нужно указывать путь вручную, Jenkins сам подставит правильный путь к maven
                bat 'mvn clean'
            }
        }
        stage('--package--') {
            steps {
                bat 'mvn package'
            }
        }
    }
}