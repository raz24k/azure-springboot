pipeline {
    agent any
    tools {
        maven 'Maven-3.9.9' // Use the configured Maven 3.9.9
    }
    environment {
        GIT_REPO = 'https://github.com/raz24k/azure-springboot.git'
        DOCKER_BUILD_DIR = 'C:\\Users\\raz24\\Downloads\\azure-cicd' // Docker build directory
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

        stage('Copy WAR to Docker Context') {
            steps {
                bat "copy target\\azure-cicd-3.4.5-SNAPSHOT.war ${DOCKER_BUILD_DIR}\\target\\"
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t azure-springboot ${DOCKER_BUILD_DIR}"
            }
        }

        stage('Cleanup Docker Containers') {
            steps {
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
                bat 'docker run -d -p 8081:8082 --name azure-springboot azure-springboot'
            }
        }
    }
}

