pipeline {
    agent any

    tools {
        maven "Maven3"
        jdk "JDK25"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh './mvnw test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Publish Dashboard') {
            steps {
                publishHTML(target: [
                    reportDir: 'src/main/resources/static',
                    reportFiles: 'dashboard_petclinic.html',
                    reportName: 'Dashboard Manual Testing'
                ])
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
        }
    }
}
