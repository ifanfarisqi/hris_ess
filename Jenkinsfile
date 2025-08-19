pipeline {
    agent any

    environment {
        KATALON_PROJECT = "/katalon/hris_ess.prj"
        TEST_SUITE_PATH = "Test Suites/Login"
        REPORT_PATH = "/katalon/Reports"
        APP_URL = "https://ics-hris.skwn.dev/login"
        USER_EMAIL = "saiqul@gmail.com"
        USER_PASSWORD = "password123"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ifanfarisqi/hris_ess.git'
            }
        }

        stage('Run Katalon Test Suite') {
            steps {
                sh """
                    docker run --rm --platform linux/arm64/v8 \
                        -v \$(pwd):/katalon/project \
                        -v \$(pwd)/Reports:/katalon/Reports \
                        katalonstudio/katalon:latest \
                        -projectPath="$KATALON_PROJECT" \
                        -retry=0 \
                        -testSuitePath="$TEST_SUITE_PATH" \
                        -executionProfile=default \
                        -browserType="Chrome" \
                        -g_url=$APP_URL \
                        -g_email=$USER_EMAIL \
                        -g_password=$USER_PASSWORD \
                        -reportFolder=$REPORT_PATH \
                        -reportFileName=jenkins_report
                """
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'Reports/**', fingerprint: true
            }
        }
    }
}
