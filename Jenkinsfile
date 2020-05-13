pipeline {
    agent any 
	options {
	  disableConcurrentBuilds()
	  buildDiscarder(logRotator(numToKeepStr: '5'))
	}
	tools {
         maven 'MAVEN_HOME'
     }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') { 
            steps {
                echo "test"
            }
        }
    }
}
