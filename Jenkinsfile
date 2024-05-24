pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "/opt/maven/bin/mvn clean"
            }
        }
        stage('--package--') {
            steps {
                sh "/opt/maven/bin/mvn package"
            }
        }
    }
}