package br.com.cc.phase;

import java.util.regex.Pattern;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


public class AutenticacaoPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 829468072179887258L;
	
	private static final String RESTRICTION_PATTERN = "/.*";

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		FacesContext context = phaseEvent.getFacesContext();
		String viewId = context.getViewRoot().getViewId();
		
		boolean urlProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);
		
		Object usuario = context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if (urlProtegida && usuario == null) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		}

	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
