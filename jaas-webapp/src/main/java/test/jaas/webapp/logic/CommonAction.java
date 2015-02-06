/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jaas.webapp.logic;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

/**
 *
 * @author marco.malavolta
 */
public abstract class CommonAction extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware, Preparable {

    @Inject
    protected Configuration configuration;

    protected ServletContext servletContext;

    protected HttpServletRequest servletRequest;

    protected HttpServletResponse servletResponse;

    @Override
    public void prepare() throws Exception {
    }
    
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public HttpServletResponse getServletResponse() {
        return servletResponse;
    }
    
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
