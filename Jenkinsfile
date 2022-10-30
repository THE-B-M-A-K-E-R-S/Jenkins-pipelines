pipeline {
    agent any

    stages {
        stage('Pulling from git...'){
            steps{
               git branch : 'main',
                url : 'https://github.com/THE-B-M-A-K-E-R-S/Jenkins-pipelines'
            }
        }

         stage('Running the unit test...'){
                    steps{
                        sh 'mvn test'
                    }
                }

        stage('Building the project...'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('Deploying the project...'){
            steps{
                sh 'mvn deploy'
            }
        }




   }
}
