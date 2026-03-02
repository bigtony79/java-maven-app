pipeline {
  agent any
  
  tools {
    maven "maven-3.9"
  }
  
  stages {
    stage("build jar") {
      steps {
        script {
          echo "building the application ..."
          sh 'mvn package'
        }
        
      }
    }

    stage("build docker image") {
          steps {
            script {
              echo "building the docker image ..."
              withCredentials([usernamePassword(credentialsId: 'dockerhub-pat', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
              sh 'docker build -t $DOCKERHUB_USERNAME/demo-app:jma-1.2 .'
              sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
              sh 'docker push $DOCKERHUB_USERNAME/demo-app:jma-1.2'
              }
            }
            
          }
    }
    
    stage("deploy") {
      steps {
        script {
          echo "deploying the application.... "
        }
        
      }
    }
  }
}
        
          

      
  
