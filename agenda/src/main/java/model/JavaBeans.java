package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String valor;
	private String quantidade;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcon, String nome, String valor, String quantidade) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}
