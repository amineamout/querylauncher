pipeline {
    agent any

    stages {

        stage('Checkout Git') {
            steps {
                git poll: true, branch: '${branch}', url: 'https://github.com/amineamout/querylauncher.git', credentialsId: '9f4a36ae-80a0-49cb-a4a7-e09e035187c2'
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
        stage('generate scripts') {
            steps {
                sh "cd ansible"
                sh "pwd"
                sh "cd .."
                //execIn('ansible-playbook spark_template.yml')
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