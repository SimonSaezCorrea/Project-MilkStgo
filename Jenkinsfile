pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage("Build JAR FILE"){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/SimonSaezCorrea/Project-MilkStgo']])
                sh "mvn clean install"
            }
        }
        stage("Test"){
            steps{
                sh "mvn test"
            }
        }
        stage("SonarQube Analysis"){
            steps{
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Project-MilkStgo -Dsonar.projectName='Project-MilkStgo' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_915d98b55653607e0d4098c924ced901d1747677"
            }
        }
        stage("Build Docker Image"){
            steps{
                sh "docker build -t simonsaez/project-milkstgo ."
            }
        }
        stage("Build Push Docker Image"){
            steps{
                withCredentials([string(credentialsId: 'dckrhubpassword', variable: 'dckpass')]) {
                    sh "docker login -u simonsaez -p ${dckpass}"
                }
                sh "docker push simonsaez/project-milkstgo"
            }
        }
    }
    post{
        always{
            sh "docker logout"
        }
    }
}