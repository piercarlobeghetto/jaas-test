<%@page session="false" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@taglib prefix="lay" tagdir="/WEB-INF/tags/layout" %>

<s:if test="#parameters['se']">
    <%response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);%>  
</s:if>
<div class="login-box">
    <s:form action="performLogin" cssClass="form-horizontal" key="login.label.title">

        <s:textfield label="username" name="username" requiredLabel="true" />
        <s:password label="password" name="password" showPassword="true" requiredLabel="true"/>

        <div class="form-actions">
            <s:submit key="common.label.login" cssClass="btn btn-primary" />
            <s:reset key="common.label.cancel" cssClass="btn" />
        </div>
    </s:form>
</div>
