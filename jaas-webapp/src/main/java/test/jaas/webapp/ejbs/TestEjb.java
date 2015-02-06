
package test.jaas.webapp.ejbs;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Piercarlo Beghetto
 * @version $Id$
 */
@Stateless
public class TestEjb {

    @RolesAllowed("Ruolo1")
//    @PermitAll
    public void doSomething() {
        System.out.println("PROVA PERMISSION");
    }

}
