pipeline {
    agent any
    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge', 'safari'],
            description: 'Choice browser'
        )
    }
    environment {
        SELENOID_URL = 'http://localhost:4444/'
    }

    stages {
        stages('Run test') {
            script {
                sh "mvn test -Dbrowser=chrome -DselenoidUrl=${env.SELENOID_URL}"
            }
        }
    }
    post {
        always {
            generateAllure()
        }
    }
}
def generateAllure(){
    allure([
            includeProperties: true,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            result           : [[path: 'target/allure-results']]
    ])
}