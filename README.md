# jaas-test

jaas-webapp is a struts 2 web application
test-realm is the jaas realm


Configurations for TomEE 1.7.1

In catalina.bat
CATALINA_OPTS=-Djava.security.auth.login.config=%CATALINA_HOME%/conf/jaas_test.config

in /conf/jaas_test.config
test-login {
   test.jaas.auth.JAASLoginModule required;
};
