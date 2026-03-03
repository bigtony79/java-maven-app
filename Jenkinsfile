#!/user/bin/env groovy

@Library('jenkins-shared-library')_

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
          
          gv = load "script.groovy"
          echo "initializing the pipeline..."
        }
      }
    }

    stage("test") {
      steps {
        script {
          gv.runTests()
        }
      }
    }

    stage("build jar") {
      steps {
        script {
          buildJar()
        }
      }
    }

    stage("build docker image") {
      steps {
        script {
          buildImage()
        }
      }
    }

    stage("deploy") {
      when {
        expression {
          BRANCH_NAME == "main" //This variable is only available in multibranch pipeline.
         }
      }
      
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