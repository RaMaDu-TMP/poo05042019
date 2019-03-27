package br.edu.usf.ads.model;

public class Tag {

	private String id;
	private String sala;
	private String aula;
	private String professor;
	
	public Tag(String id) {
		this(id, null, null, null);
	}
	
	public Tag(String id, String sala, String aula, String professor) {
		this.id = id;
		this.sala = sala;
		this.aula = aula;
		this.professor = professor;
	}
	
	public String getId() {
		return id;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public String getAula() {
		return aula;
	}
	
	public void setAula(String aula) {
		this.aula = aula;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		String message = "";
		if (validField(sala)) {
			message += "SALA: " + sala;
		}
		
		if (validField(aula)) {
			if (!message.isEmpty()) {
				message += ", ";
			}
			message += "AULA: " + aula;
		}
		
		if (validField(professor)) {
			if (!message.isEmpty()) {
				message += ", ";
			}
			message += "PROFESSOR: " + professor;
		}
		
		message = "[" + id + "] " + message;
		return message;
	}
	
	private boolean validField(String field) {
		return field != null && !field.isEmpty();
	}
}
