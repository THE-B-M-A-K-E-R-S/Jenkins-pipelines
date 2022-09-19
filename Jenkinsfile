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
                Date date = new Date()
                String datePart = date.format("dd/MM/yyyy")
                String timePart = date.format("HH:mm:ss")
                println "datePart : " + datePart + "\ttimePart : " + timePart
            }
        }
    
    
    
}
