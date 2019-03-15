pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sbt clean
                sbt update
                sbt compile
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sbt test
                sbt doc
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'

            }
        }
    }
}