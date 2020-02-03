package br.edu.unicid.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int code;
	private String desc;
	
	private EstadoPagamento(int cod, String desc) {
		this.code = cod;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return desc;
	}
	
	public static EstadoPagamento toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException();
	}
}
