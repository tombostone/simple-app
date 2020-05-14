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

    stage('SonarQube analysis') {
	   steps {
         withSonarQubeEnv('sonar-server') {
             sh 'mvn sonar:sonar'
    } 
   }
  }

     stage('Quality Gate check') {
	   steps {
           timeout(20) {
  
            def qg = waitForQualityGate()
              if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }

            }


   }

  }

}
}
