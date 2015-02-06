/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jaas.webapp.logic;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author marco.malavolta
 */
@ApplicationScoped
@Named
public class Configuration implements Serializable {

    private static final String APP_NAME = "jaas-webapp";

    private static final String APP_REL = "1.0.0";

    public Configuration() {

    }

    public String getAppName() {
        return APP_NAME;
    }

    public String getAppVersion() {
        return APP_REL;
    }

    public String getAppFullName() {
        return getAppName() + " " + getAppVersion();
    }
}
