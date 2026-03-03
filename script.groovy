def runTests() {
    echo "Testing the application ..."
    echo "Executing the piplein for branch $BRANCH_NAME"
    sh 'mvn test'
}


def deployApp() {
    echo "deploying the application.... "
}

return this