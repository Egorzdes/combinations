pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build("my-app")
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    kubectl("apply -f C:/Users/79332/combinations/k8s-deployment.yaml")
                }
            }
        }
    }
}

def kubectl(command) {
    sh "kubectl ${command}"
}
