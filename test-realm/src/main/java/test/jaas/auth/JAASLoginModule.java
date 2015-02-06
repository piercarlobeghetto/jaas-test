/*
 * -----------------------------------------------------------------------------
 * Copyright (c) Diennea S.r.l.
 * This software is the proprietary 
 * information of Diennea S.r.l. All Rights Reserved.
 * -----------------------------------------------------------------------------
 */
package test.jaas.auth;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *
 * @author Piercarlo Beghetto
 * @version $Id$
 */
public class JAASLoginModule implements LoginModule {

    private final static String USERNAME = "username";

    private final static String PASSWORD = "password";

    public JAASLoginModule() {
    }

    private Subject subject;

    private CallbackHandler callbackHandler;

    private Map sharedState;

    private Map options;

    private boolean succeeded = false;

    private String username;

    private String password;

    private long id = 11111l;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        System.out.println("Login Module - initialize called");
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;

        System.out.println("SHARED STATE: ");
        for (Entry<String, ?> e : sharedState.entrySet()) {
            System.out.println(e.getKey() + " --> " + e.getValue().toString());
        }
        System.out.println("OPTIONS: ");
        for (Entry<String, ?> e : options.entrySet()) {
            System.out.println(e.getKey() + " --> " + e.getValue().toString());
        }

        System.out.println("testOption value: " + (String) options.get("testOption"));
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println("Login Module - login called");
        if (callbackHandler == null) {
            throw new LoginException("Oops, callbackHandler is null");
        }

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("name:");
        callbacks[1] = new PasswordCallback("password:", false);

        try {
            callbackHandler.handle(callbacks);
        } catch (IOException e) {
            throw new LoginException("Oops, IOException calling handle on callbackHandler");
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
        }

        NameCallback nameCallback = (NameCallback) callbacks[0];
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

        username = nameCallback.getName();
        password = new String(passwordCallback.getPassword());

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            System.out.println("Success! You get to log in!");
            succeeded = true;
            return succeeded;
        } else {
            System.out.println("Failure! You don't get to log in");
            succeeded = false;
            throw new FailedLoginException("Sorry! No login for you.");
        }
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("Login Module - commit called");
        subject.getPrincipals().add(new UserPrincipal(username));

        subject.getPrincipals().add(new RolePrincipal("Ruolo1"));
        subject.getPrincipals().add(new RolePrincipal("Ruolo2"));
        subject.getPrincipals().add(new RolePrincipal("Ruolo3"));
        subject.getPrincipals().add(new RolePrincipal("Ruolo4"));
        return succeeded;
    }

    @Override
    public boolean abort() throws LoginException {
        System.out.println("Login Module - abort called");
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        System.out.println("Login Module - logout called");
        return false;
    }

}
