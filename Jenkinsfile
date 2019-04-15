pipeline {
  agent {
    docker {
      args '-v /root/.m2:/root/.m2'
      image '3-jdk-8-alpine'
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