/*
 * -----------------------------------------------------------------------------
 * Copyright (c) Diennea S.r.l.
 * This software is the proprietary 
 * information of Diennea S.r.l. All Rights Reserved.
 * -----------------------------------------------------------------------------
 */
package test.jaas.auth;

/**
 *
 * @author Piercarlo Beghetto
 * @version $Id$
 */
public class RolePrincipal implements java.security.Principal {

    private String name;

    public RolePrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
