pipeline {
    agent any

    stages {
        stage('Pulling from git...'){
            steps{
               git branch : 'main',
                url : 'https://github.com/THE-B-M-A-K-E-R-S/Jenkins-pipelines'
            }
        }


        stage('MVN CLEAN...'){
            steps {
                sh """mvn clean"""
            }
        }

//         stage('MVN COMPILE'){
//             steps {
//                 sh """MVN COMPILE"""
//             }
//         }
   }
}
