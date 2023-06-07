pipeline {
    agent any
    stages {
        stage('Parameters'){
            steps {
                script {
                    properties([
                            parameters([
                                    [$class: 'ChoiceParameter',
                                     choiceType: 'PT_SINGLE_SELECT',
                                     description: 'Select the Environemnt from the Dropdown List',
                                     filterLength: 1,
                                     filterable: false,
                                     name: 'Env',
                                     script: [
                                             $class: 'GroovyScript',
                                             fallbackScript: [
                                                     classpath: [],
                                                     sandbox: true,
                                                     script:
                                                             "return['Could not get The environemnts']"
                                             ],
                                             script: [
                                                     classpath: [],
                                                     sandbox: true,
                                                     script:
                                                             "return['dev','stage','prod']"
                                             ]
                                     ]
                                    ],
                                    [$class: 'ChoiceParameter',
                                     choiceType: 'BRANCH',
                                     description: 'Select the branch from the Dropdown List',
                                     filterLength: 1,
                                     filterable: false,
                                     name: 'Env',
                                     script: [
                                             $class: 'GroovyScript',
                                             fallbackScript: [
                                                     classpath: [],
                                                     sandbox: true,
                                                     script:
                                                             "return['Could not get The branch']"
                                             ],
                                             script: [
                                                     classpath: [],
                                                     sandbox: true,
                                                     script:
                                                             "return['main','develop']"
                                             ]
                                     ]
                                    ],
                                    string(
                                            defaultValue: 'chewbacca',
                                            name: 'service_name',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'chews',
                                            name: 'stack',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'chews',
                                            name: 'env',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'chewbacca-arm64',
                                            name: 'base_ami_id',
                                            trim: true
                                    )
                            ])
                    ])
                }
            }
        }
    }
}