pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat "mvnw.cmd -Dmaven.test.skip=false clean test"
            }
        }

        stage('Publish Surefire Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Publish HTML Dashboard') {
            steps {
                publishHTML([
                    reportDir: 'target/classes/static',
                    reportFiles: 'dashboard_petclinic.html',
                    reportName: 'Dashboard Pruebas PetClinic'
                ])
            }
        }
    }

    post {
        always {
            echo "Pipeline finalizado"
        }
        failure {
            echo "Pipeline falló, revisar pruebas"
        }
    }
}
