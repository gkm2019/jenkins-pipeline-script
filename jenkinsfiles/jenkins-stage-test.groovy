pipeline {
    agent any
    stages {

        stage('Parameters'){
            steps {
                script {
                    properties([
                            parameters([
                                    [$class: 'ChoiceParameter',
                                     choiceType: 'SERVICE_JAR_FILE',
                                     description: 'Select the jar file from the Dropdown List',
                                     filterLength: 1,
                                     filterable: false,
                                     name: 'jar_file',
                                     script: [
                                             $class: 'GroovyScript',
                                             fallbackScript: [
                                                     classpath: [],
                                                     sandbox: false,
                                                     script:
                                                             "return['Could not get The jar_file']"
                                             ],
                                             script: [
                                                     classpath: [],
                                                     sandbox: false,
                                                     script:
                                                             "return['1_jar_file','2_jar_file','3_far_file']"
                                             ]
                                     ]
                                    ],
                                    [$class: 'ChoiceParameter',
                                     choiceType: 'BRANCH',
                                     description: 'Select the branch from the Dropdown List',
                                     filterLength: 1,
                                     filterable: false,
                                     name: 'jar_file',
                                     script: [
                                             $class: 'GroovyScript',
                                             fallbackScript: [
                                                     classpath: [],
                                                     sandbox: false,
                                                     script:
                                                             "return['Could not get branch']"
                                             ],
                                             script: [
                                                     classpath: [],
                                                     sandbox: false,
                                                     script:
                                                             "return['main','dev']"
                                             ]
                                     ]
                                    ],
                                    [$class: 'StringParameterValue', name: 'service_name', value: "${JOB_NAME}"]

                            ])
                    ])
                }
            }
        }

        stage('Stage 1') {
            steps {
                script {
                    echo 'Stage 1'
                }
            }
        }

        stage('Stage 2') {
            steps {
                script {
                    echo 'Stage 2'
                }
            }
        }

    }
}
