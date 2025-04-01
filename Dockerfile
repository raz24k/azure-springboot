FROM tomcat:9.0-jdk17-openjdk-slim

# Remove the default web apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your .war file to the Tomcat webapps directory
COPY target/azure-cicd-3.4.5-SNAPSHOT.war /usr/local/tomcat/webapps/azure-springboot.war

# Expose the port Tomcat runs on
EXPOSE 8082

# Start Tomcat
CMD ["catalina.sh", "run"]