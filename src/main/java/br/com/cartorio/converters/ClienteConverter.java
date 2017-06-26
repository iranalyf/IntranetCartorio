package br.com.cartorio.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cartorio.models.Cliente;
import br.com.cartorio.repository.ClienteDAO;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	private ClienteDAO repository;

	public ClienteConverter() {
		this.repository = new ClienteDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.findOne(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Cliente cliente = (Cliente) value;
			return cliente.getIdCliente() == null ? null : cliente.getIdCliente().toString();
		}

		return "";
	}
}
