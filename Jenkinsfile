pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/J-Maryam/YouQuiz.git', credentialsId: 'youQuiz-token'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo 'Building the project with Maven...'
                    sh 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Running unit tests...'
                    sh 'mvn test'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    echo 'Running SonarQube analysis...'
                    withSonarQubeEnv('sonarqube-8.9') {
                        sh 'mvn sonar:sonar'
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
