/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jaas.webapp.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import javax.inject.Inject;
import org.apache.struts2.convention.annotation.Action;
import test.jaas.webapp.ejbs.TestEjb;
import test.jaas.webapp.logic.CommonAction;

/**
 *
 * @author marco.malavolta
 */
public class HomeAction extends CommonAction {

    @Inject
    private TestEjb ejb;

    @Action("home")
    public String home() throws Exception {

        System.out.println("Ruolo1: " + servletRequest.isUserInRole("Ruolo1"));
        System.out.println("Ruolo2: " + servletRequest.isUserInRole("Ruolo2"));
        System.out.println("Ruolo3: " + servletRequest.isUserInRole("Ruolo3"));
        System.out.println("Ruolo4: " + servletRequest.isUserInRole("Ruolo4"));
        System.out.println("Ruolo5: " + servletRequest.isUserInRole("Ruolo5"));

        try {
            ejb.doSomething();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }
}
