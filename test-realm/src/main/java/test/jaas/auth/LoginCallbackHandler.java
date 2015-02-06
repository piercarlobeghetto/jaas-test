/*
 * -----------------------------------------------------------------------------
 * Copyright (c) Diennea S.r.l.
 * This software is the proprietary 
 * information of Diennea S.r.l. All Rights Reserved.
 * -----------------------------------------------------------------------------
 */
package test.jaas.auth;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author Piercarlo Beghetto
 * @version $Id$
 */
public class LoginCallbackHandler implements CallbackHandler {

    String username;

    String password;

    public LoginCallbackHandler(String name, String password) {
        System.out.println("Callback Handler - constructor called");
        this.username = name;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("Callback Handler - handle called");
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callbacks[i];
                nameCallback.setName(username);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
                passwordCallback.setPassword(password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i], "The submitted Callback is unsupported");
            }
        }
    }

}
