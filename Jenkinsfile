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
               echo "TimeStamp: ${Util.getTimeSpanString(System.currentTimeMillis())}"
            }
        } 
   }
}
