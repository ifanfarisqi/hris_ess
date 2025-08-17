pipeline {
    agent any

    environment {
        APP_BASE_URL    = "https://ics-hris.skwn.dev/login"
        APP_EMAIL       = "saiqul@gmail.com"
        APP_PASSWORD    = "password123"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/ifanfarisqi/hris_ess.git'
            }
        }

        stage('Run Katalon Test with Docker') {
            steps {
                sh '''
                mkdir -p reports

                docker run --rm \
                  -e APP_BASE_URL=$APP_BASE_URL \
                  -e APP_EMAIL=$APP_EMAIL \
                  -e APP_PASSWORD=$APP_PASSWORD \
                  -v "$PWD":/katalon/project \
                  -v "$PWD/reports":/katalon/report \
                  katalonstudio/katalon:latest \
                  katalonc.sh -noSplash -runMode=console \
                    -projectPath="/katalon/project/hris_ess.prj" \
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
