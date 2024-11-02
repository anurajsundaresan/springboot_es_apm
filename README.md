//gitlab -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
# elastic-apm-docker-compose
A docker-compose setup to deploy a local stack for elastic-apm https://www.elastic.co/apm to receive and visualise metrics from instrumented applications for performance monitoring.

# pre-requirements
 - docker must be installed

# how to start
run `docker-compose up` from the commandline inside of the main directory of this project.
The stack will take ~1 minute to start up.

Open http://localhost:5601 in your local browser see the overview of Kibana.
Select APM from the menu and follow the instructions to instrument your application.

# Java instrumentation

Download the agent jar file from Maven central https://mvnrepository.com/artifact/co.elastic.apm/elastic-apm-agent and store it in a local directory.
Don't add it as a build dependency to your application.

Start your application with the `-javaagent` flag pointing to the downloaded jar and configure the required parameters.
use the same token for `elastic.apm.secret_token` that is configured in the `docker-compose.yml`
```
java -javaagent:elastic-apm-agent-java8-1.52.0.jar -Delastic.apm.service_name=my-application -Delastic.apm.server_urls=http://localhost:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=org.example -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

you can find a list of all configuration parameters here: https://www.elastic.co/guide/en/apm/agent/java/current/configuration.html

After starting and interacting with the instrumented application, you should find the service name in the APM listing.
