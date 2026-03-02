def gv

pipeline {
  agent any

  tools {
    maven "maven-3.9"
  }

  stages {

    stage("init") {
      steps {
        script {
          sh "ls -R ."
          gv = load "script.groovy"
          echo "initializing the pipeline..."
        }
      }
    }

    stage("build jar") {
      steps {
        script {
          gv.buildJar()
        }
      }
    }

    stage("build docker image") {
      steps {
        script {
          gv.buildImage()
        }
      }
    }

    stage("deploy") {
      steps {
        script {
          gv.deployApp()
        }
      }
    }
  }

  post {
    always {
      echo "Pipeline completed."
    }
    failure {
      echo "Pipeline failed."
    }
  }
}