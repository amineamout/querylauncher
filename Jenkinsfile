pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "sbt clean"
                sh "sbt update"
                sh "sbt compile"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "sbt test"
                sh "sbt doc"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

            }
        }
    }
}