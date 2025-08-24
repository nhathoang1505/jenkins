pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/USERNAME/demo2.git'
            }
        }

        stage('Build') {
            steps {
                bat 'javac WebServer.java'
            }
        }

        stage('Deploy') {
            steps {
                powershell '''
                    # Kill old process on port 8081 if exists
                    $proc = Get-NetTCPConnection -LocalPort 8081 -ErrorAction SilentlyContinue
                    if ($proc) {
                        Stop-Process -Id $proc.OwningProcess -Force
                        Write-Output "Stopped old server on port 8081"
                    }

                    # Start server in background
                    Start-Process java -ArgumentList "WebServer"
                    Write-Output "Started new server on port 8081"
                '''
            }
        }
    }
}

