pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK 21'
    }
    environment {
        SONAR_TOKEN = credentials('sonartoken')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/J-Maryam/YouQuiz.git', credentialsId: 'youQuiz-token'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Building the project with Maven using JDK 21..."
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    echo 'Running SonarQube analysis...'
                    withSonarQubeEnv('sonarqube-8.9') {
                        sh """
                          mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=YouQuiz_jenkins_project \
                            -Dsonar.projectName='YouQuiz_jenkins_project' \
                            -Dsonar.host.url=http://localhost:9000 \
                            -Dsonar.login=${env.SONAR_TOKEN}\
                            -DskipTests
                        """
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    echo 'Building Docker image...'
                    def dockerImage = 'jmaryam/youquiz'
                    def tag = 'v1.0'
                    docker.build("${dockerImage}:${tag}", '.')
                }
            }
        }

        stage('Docker Publish') {
            steps {
                script {
                    echo 'Publishing Docker image to Docker Hub...'
                    def dockerImage = 'jmaryam/youquiz'
                    def tag = 'v1.0'
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                        docker.image("${dockerImage}:${tag}").push()
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed!'
        }
    }
}
