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
		
                sh 'mvn clean install -U -Dmaven.test.skip=true'
            }
        }
        stage('Test') { 
            steps {
		   	   
		    echo "version ${env.version}"
		    sh 'mvn test'
		   
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
           script {
      timeout(20) {
  
            def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                   manager.addShortText("Quality gate failed", 'white', '#EF0000', '1px', 'red')
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
          }

            }
           }
       


   }

  }

}
}
