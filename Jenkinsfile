<<<<<<< HEAD
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build aerfin project') {
            steps {
                dir('aerfin') {     // 👈 Your project folder
                    bat "mvn clean test"
                }
            }
        }
    }
=======
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build aerfin project') {
            steps {
                dir('aerfin') {     // 👈 Your project folder
                    bat "mvn clean test"
                }
            }
        }
    }
>>>>>>> 40ef959 (Updated eclipse workspace)
}