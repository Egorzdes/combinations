pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                bat "/opt/maven/bin/mvn clean"
            }
        }
        stage('--package--') {
            steps {
                bat "/opt/maven/bin/mvn package"
            }
        }
    }
}