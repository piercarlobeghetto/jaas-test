# jaas-test

jaas-webapp: is a struts 2 web application
test-realm: is the jaas realm (jar inclided in %CATALINA_HOME%/lib/)


Configurations for TomEE 1.7.1

In catalina.bat
CATALINA_OPTS=-Djava.security.auth.login.config=%CATALINA_HOME%/conf/jaas_test.config

in %CATALINA_HOME%/conf/jaas_test.config
test-login {
   test.jaas.auth.JAASLoginModule required;
};


Launching web app, initial page is login, credentials are username password.
There are some system out for roles check in LoginAction and in HomeAction.
