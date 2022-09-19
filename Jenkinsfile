pipeline {
    agent any
    
    stages {
        stage('Pulling from git...'){
            steps{
               git branch : 'main',
                url : 'https://github.com/THE-B-M-A-K-E-R-S/Jenkins-pipelines'
            }
        }
        
        stage('Testing maven...'){
            steps {
                sh """mvn -versinon"""
            }
        }
        
        stage('Show system date'){
            steps{
               script {
                    def now = new Date()
                    println now.format("yyMMdd.HHmm", TimeZone.getTimeZone('UTC'))
                }
            }
        } 
   }
}
