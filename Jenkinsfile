pipeline {
  agent {
    dockerfile {
      filename 'phss.dockerfile'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
  }
}