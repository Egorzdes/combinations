pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    // Строим Docker-образ
                    sh 'docker build -t my-app .'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Сохраните Docker-образ в файл и загрузите его в Minikube
                    sh 'docker save my-app -o my-app.tar'
                    sh 'docker cp my-app.tar minikube:/my-app.tar'

                    // Внутри контейнера Minikube загрузите образ
                    sh 'docker exec minikube docker load -i /my-app.tar'

                    // Копируем манифесты в контейнер Minikube
                    sh 'docker cp deployment.yaml minikube:/deployment.yaml'
                    sh 'docker cp service.yaml minikube:/service.yaml'

                    // Применяем Kubernetes манифесты для деплоя
                    sh 'docker exec minikube kubectl apply -f /deployment.yaml'
                    sh 'docker exec minikube kubectl apply -f /service.yaml'
                }
            }
        }
    }
}
