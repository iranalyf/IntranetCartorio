package br.com.cartorio.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cartorio.models.PedidoCertidao;
import br.com.cartorio.repository.PedidoCertidaoDAO;

@FacesConverter(forClass = PedidoCertidao.class)
public class PedidoConverter implements Converter {

	private PedidoCertidaoDAO repository;

	public PedidoConverter() {
		this.repository = new PedidoCertidaoDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PedidoCertidao retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.findOne(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			PedidoCertidao pedido = (PedidoCertidao) value;
			return pedido.getIdPedidoCertidao() == null ? null : pedido.getIdPedidoCertidao().toString();
		}

		return "";
	}
}
