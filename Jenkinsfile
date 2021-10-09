pipeline {
agent any

tools {
  maven 'M3'
  git 'git'
}

stages {
      stage('Checkout SCM') {
         steps {
            // Get some code from a GitHub repository
            echo "checkout branch"
            git branch: 'main', url: 'https://github.com/harihar2u/estore.git'
         }
      }
    
      stage("Maven build"){
        steps{
             // Run Maven on a Unix agent.
            sh "mvn clean install -DskipTests"
        }
    } 

      post {
            success {
            //   junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
            }
         }
   }
}
