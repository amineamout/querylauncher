pipeline {
    agent any

    stages {

        stage('Checkout Git') {
            steps {
                git poll: true, branch: 'master', url: 'https://github.com/amineamout/querylauncher.git', credentialsId: 'ef6342cb-a263-487f-84ac-99ca52057549'
            }
        }
        stage('cleaning') {
            steps {
                sh "sbt clean"
                sh "rm -rf /var/lib/jenkins/workspace/querylauncherPipeline/"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
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