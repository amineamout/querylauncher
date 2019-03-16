pipeline {
    agent any

    stages {

        stage('Checkout Git') {
            steps {
                git poll: true, branch: 'develop', url: 'https://github.com/amineamout/querylauncher.git', credentialsId: 'ef6342cb-a263-487f-84ac-99ca52057549'
            }
        }
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