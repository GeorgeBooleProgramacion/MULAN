package msj;

public class Mensaje {
	
	private String msj;
	private String user;
	private String sala;
	
	public Mensaje(String msj, String user, String sala) {
		this.msj = msj;
		this.user = user;
		this.sala = sala;
	}

	public String getMsj() {
		return msj;
	}

	public String getUser() {
		return user;
	}

	public String getSala() {
		return sala;
	}

}
