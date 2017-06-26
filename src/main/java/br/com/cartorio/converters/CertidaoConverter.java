package br.com.cartorio.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cartorio.models.Certidao;
import br.com.cartorio.repository.CertidaoDAO;

@FacesConverter(forClass = Certidao.class)
public class CertidaoConverter implements Converter {

	private CertidaoDAO repository;

	public CertidaoConverter() {
		this.repository = new CertidaoDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Certidao retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.findOne(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Certidao certidao = (Certidao) value;
			return certidao.getIdCertidao() == null ? null : certidao.getIdCertidao().toString();
		}

		return "";
	}
}
