pipeline {

    agent any

    parameters {
        choice(
                name: 'BROWSER',
                choices: ['chrome','firefox','edge'],
                description: 'Select Browser'
        )

        string(
                name: 'TCID',
                defaultValue: 'TC_001',
                description: 'Enter Test Case ID'
        )
    }
    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                        url: 'https://github.com/Thirumurugan3/Realtime_LMS_Project'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Execute Tests') {
            steps {
                bat "mvn test -Dbrowser=${params.BROWSER} -Dtcid=${params.TCID}"
            }
        }



        stage('Generate Allure Report') {
            steps {
                bat 'allure generate allure-results --clean -o allure-report'
            }
        }
    }

    post {

        always {
            allure([
                    includeProperties: false,
                    results          : [[path: 'allure-results']]
            ])
        }

        success {
            echo 'Execution Successful'
        }

        failure {
            echo 'Execution Failed'
        }
    }
}