pipeline {
    agent any

    parameters {
        string(name: 'APP_URL', defaultValue: 'https://ics-hris.skwn.dev/login', description: 'Target application URL')
        string(name: 'USER_EMAIL', defaultValue: 'saiqul@gmail.com', description: 'Login email for testing')
        password(name: 'USER_PASSWORD', defaultValue: '', description: 'Login password for testing')
        string(name: 'TEST_SUITE_PATH', defaultValue: 'Test Suites/Login', description: 'Katalon Test Suite path')
    }

    environment {
        KATALON_PROJECT  = "/katalon/hris_ess.prj"
        REPORT_PATH      = "/katalon/Reports"
        KATALON_API_KEY  = credentials('katalon_api_key')
    }

    stages {
        stage('Run Katalon Test Suite') {
            steps {
                sh """
                docker run --rm --platform linux/amd64 \
                  -v \$WORKSPACE:/katalon/project \
                  -v \$WORKSPACE/Reports:/katalon/Reports \
                  katalonstudio/katalon:latest katalonc \
                  -projectPath="\$KATALON_PROJECT" \
                  -retry=0 \
                  -testSuitePath="${params.TEST_SUITE_PATH}" \
                  -executionProfile=default \
                  -browserType="Chrome" \
                  -g_url="${params.APP_URL}" \
                  -g_email="${params.USER_EMAIL}" \
                  -g_password="${params.USER_PASSWORD}" \
                  -reportFolder="\$REPORT_PATH" \
                  -reportFileName=jenkins_report \
                  -apiKey="\$KATALON_API_KEY"
                """
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'Reports/**', fingerprint: true
            }
        }
    }

    post {
        always {
            echo "Pipeline finished. Reports archived (if generated)."
        }
        success {
            echo "✅ Test suite PASSED!"
        }
        failure {
            echo "❌ Test suite FAILED! Check Reports in Jenkins artifacts."
        }
    }
}
