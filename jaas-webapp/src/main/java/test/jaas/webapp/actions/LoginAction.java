package test.jaas.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import test.jaas.webapp.logic.CommonAction;

/**
 *
 * @author Piercarlo Beghetto
 * @version $Id: LoginAction.java 8666 2015-01-26 10:25:31Z piercarlo.beghetto $
 */
@Results({
    @Result(name = ActionSupport.INPUT, location = "login.jsp"),
    @Result(name = "loggedIn", location = "home", type = "redirectAction"),
    @Result(name = "loggedOut", location = "login", type = "redirectAction", params = {"lo", "true"})
})
public class LoginAction extends CommonAction {

    public static final String SESSION_EXPIRED_PARAM = "se";

    public static final String LOGGED_OUT_PARAM = "lo";

    private String username;

    private String password;

    @Action("login")
    @Override
    public String input() throws Exception {

        HttpSession session = getServletRequest().getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return SUCCESS;
    }

    @Action("performLogin")
    public String performLogin() throws Exception {
        try {

            servletRequest.login(username, password);
            
            System.out.println("Ruolo1: " + servletRequest.isUserInRole("Ruolo1"));
            System.out.println("Ruolo2: " + servletRequest.isUserInRole("Ruolo2"));
            System.out.println("Ruolo3: " + servletRequest.isUserInRole("Ruolo3"));
            System.out.println("Ruolo4: " + servletRequest.isUserInRole("Ruolo4"));
            System.out.println("Ruolo5: " + servletRequest.isUserInRole("Ruolo5"));
            
//            LoginContext lc = new LoginContext("test-login", new LoginCallbackHandler(username, password));
//            lc.login();

//            System.out.println("subject: " + lc.getSubject().toString());
//            
//            for(RolePrincipal r : lc.getSubject().getPrincipals(RolePrincipal.class)) {
//                System.out.println("role: " + r.getName());                
//            }
            
            return "loggedIn";
        } catch (Exception ex) {
            ex.printStackTrace();
            return INPUT;
        }
    }

    @Action(value = "performLogout")
    @SkipValidation
    public String performLogout() throws Exception {

        return "loggedOut";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
