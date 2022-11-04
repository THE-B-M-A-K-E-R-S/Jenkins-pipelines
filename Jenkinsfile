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
        stage("Build") {
            steps {
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage("SonarQube Analysis") {
            steps {
                sh 'mvn sonar:sonar'
            }
        }
        stage('Nexus Deploy ') {
            steps {
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'achat',
                        classifier: '',
                        file: 'target/achat.jar',
                        type: 'jar'
                    ]
                ],
                 credentialsId: 'nexus3',
                 groupId: 'tn.esprit.rh',
                 nexusUrl: 'localhost:8081',
                 nexusVersion: 'nexus3',
                 protocol: 'http',
                 repository: 'Achat-release',
                 version: '1.0.0'
            }
        }

   }
}
