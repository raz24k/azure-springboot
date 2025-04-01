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
                // Stop and remove all containers with the name 'azure-springboot'
                bat '''
                    echo "Cleaning up Docker containers if any"
                    for /f "tokens=*" %%i in ('docker ps -a -q -f "name=azure-springboot"') do (
                        echo "Stopping and removing container %%i"
                        docker stop %%i
                        docker rm %%i
                    )
                    echo "Docker cleanup complete"
                '''
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8081:8080 --name azure-springboot azure-springboot'
            }
        }
    }
}
