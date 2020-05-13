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
		    script {
	      def mavenPom = readMavenPom file: 'pom.xml'
			   
		    echo "version ${mavenPom.version}"
		    }
            }
        }
    }
}
