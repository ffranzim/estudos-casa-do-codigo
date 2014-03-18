package br.com.cc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cc.persistence.JpaUtil;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent conComponent, String texto) {
		if (texto == null || texto.isEmpty())
			return null;

		try {
			String[] values = texto.split("-");
			return JpaUtil.getEntityManager().find(Class.forName(values[0]), Long.valueOf(values[1]));
		} catch (Exception e) {
			// logger.error("Erro ao converter String em entidade", e);
			System.out.println("Erro ao converter String em entidade : " + e);
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		if (objeto == null) {
			return null;
		}

		try {
			Class<?> classe = objeto.getClass();
			Long id = (Long) classe.getMethod("getId").invoke(objeto);

			return classe.getName() + "-" + id;
		} catch (Exception e) {
			// logger.error("Erro ao converter entidade em String", e);
			System.out.println("Erro ao converter entidade em String : " + e);
			return null;
		}
	}

}
