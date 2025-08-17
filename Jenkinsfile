pipeline {
    agent any

    environment {
        KATALON_API_KEY = credentials('katalon-api-key') 
        APP_BASE_URL    = "https://ics-hris.skwn.dev/login"
        APP_EMAIL       = "saiqul@gmail.com"
        APP_PASSWORD    = "password123"
    }

    stages {
        stage('Checkout Code') {
            steps {
                // clone project Katalon dari repo kamu
                git branch: 'main', url: 'https://github.com/ifanfarisqi/hris_ess.git'
            }
        }

        stage('Run Katalon Test with Docker') {
            steps {
                sh '''
                docker run --rm \
                  -e KATALON_API_KEY=$KATALON_API_KEY \
                  -e APP_BASE_URL=$APP_BASE_URL \
                  -e APP_EMAIL=$APP_EMAIL \
                  -e APP_PASSWORD=$APP_PASSWORD \
                  -v "$PWD":/katalon/project \
                  -v "$PWD/reports":/katalon/report \
                  katalonstudio/katalon:latest \
                  katalonc.sh -noSplash -runMode=console \
                    -projectPath="/Users/ifanmuhammad/Katalon Studio/hris_ess/hris_ess.prj" \
                    -testSuitePath="Test Suites/Login" \
                    -executionProfile="default" \
                    -browserType="Chrome (headless)" \
                    -reportFolder="/katalon/report" \
                    -reportFileName="login"
                '''
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML (target: [
                    allowMissing: false,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'login.html',
                    reportName: 'Katalon Test Report'
                ])
            }
        }
    }
}
