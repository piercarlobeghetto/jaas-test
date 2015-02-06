<%@page session="false" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@taglib prefix="lay" tagdir="/WEB-INF/tags/layout" %>

<s:if test="!exceptionStack.startsWith('ClientAbortException')">
    <%response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);%>
</s:if>

<script type="text/javascript">
    if (top.location !== location) {
        top.location.href = document.location.href;
    }

    function showHide(handler, elementToToggle) {
        if ($(handler).hasClass('opened')) {
            $(handler).attr("value", '<s:text name="errors.label.show"/>');
            $(handler).removeClass("opened").addClass("closed");
            $(elementToToggle).hide('Blind');
        } else {
            $(handler).attr("value", '<s:text name="errors.label.hide"/>');
            $(handler).removeClass("closed").addClass("opened");
            $(elementToToggle).show('Blind');
        }
    }
</script>


<div class="well">
    <fieldset>
        <legend><s:text name="errors.label.error"/></legend>
        <s:text name="errors.message.generic"/>
        <input id="toggle_button" type="button" class="btn" href="#" onclick="showHide('#toggle_button', '#errors_pane');return false;" value="<s:text name="errors.label.show"/>">
        <div id="errors_pane" class="toggle-pane" style="display:none;">
            <pre><s:property value="%{exceptionStack}"/></pre>
        </div>
    </fieldset>
</div>