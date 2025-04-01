pipeline {
    agent any
    tools {
        maven 'Maven-3.9.9' // Use the configured Maven 3.9.9
    }
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
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t azure-springboot .'
            }
        }

        stage('Cleanup Docker Containers') {
            steps {
                bat 'docker ps -a -q -f "name=azure-springboot" | ForEach-Object { docker stop $_ }'
                bat 'docker ps -a -q -f "name=azure-springboot" | ForEach-Object { docker rm $_ }'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8081:8080 azure-springboot'
            }
        }
    }
}