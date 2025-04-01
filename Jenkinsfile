pipeline {
    agent any
    environment {
        GIT_REPO = 'https://github.com/raz24k/azure-springboot.git'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: env.GIT_REPO
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t azure-springboot .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8081:8081 azure-springboot'
            }
        }
    }
}