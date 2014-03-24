/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.validation;

import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Changes style of every element with class <pre>loginInput</pre> to 
 * 
 * @author Piotr
 */
public class ValidationStylePhaseListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent pe) {
        FacesContext context = pe.getFacesContext();
        String focus = null;
        StringBuilder highlight = new StringBuilder();

        Iterator<String> it = context.getClientIdsWithMessages();

        while (it.hasNext()) {
            final String clientId = it.next();
            if(focus == null) {
                focus = clientId;
            }
            highlight.append(clientId);
            if(it.hasNext()) highlight.append(',');
        }
        
        context.getExternalContext().getRequestMap().put("focus", focus);
        context.getExternalContext().getRequestMap().put("highlight", highlight.toString());
    }

    @Override
    public void afterPhase(PhaseEvent pe) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
