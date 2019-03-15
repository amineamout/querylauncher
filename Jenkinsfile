pipeline {
    agent any

    stages {
        stage('Checkout Git') {
            git poll: true, branch: 'master', url: 'https://github.com/amineamout/querylauncher.git', credentialsId: 'ef6342cb-a263-487f-84ac-99ca52057549'
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}