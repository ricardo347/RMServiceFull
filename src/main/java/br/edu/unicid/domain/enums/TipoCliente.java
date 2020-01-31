package br.edu.unicid.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int code;
	private String desc;
	
	private TipoCliente(int cod, String desc) {
		this.code = cod;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return desc;
	}
	
	public static TipoCliente toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException();
	}
}
