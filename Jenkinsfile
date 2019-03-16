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
                sh "rm -rf ${WORKSPACE}/spark-warehouse/"
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
                sh "sbt package"
                echo 'Deploying....'
                script {
                    try {
                        sh "cp ${WORKSPACE}/target/scala-2.12/querylauncher-0.1.jar /home/dev/deploy/querylauncher-0.1.jar"
                    } catch (Exception err) {
                        currentBuild.result = 'FAILURE'
                    }
                }

            }
        }
    }
}