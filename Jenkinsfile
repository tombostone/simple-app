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
		         script {
	      def mavenPom = readMavenPom file: 'pom.xml'	   
	      env.version = mavenPom.version
		    } 
		
                sh 'mvn clean package'
            }
        }
        stage('Test') { 
            steps {
		   	   
		    echo "version ${env.version}"
		   
            }
        }
    }
}
