package br.edu.usf.ads.controller;

import br.edu.usf.ads.model.Tag;
import br.edu.usf.ads.view.View;

public class Controller {
	private static Controller instance;
	
	private View view;
	
	public static Controller gi() {
		
		if (instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}
	
	private Controller() {
		config();
	}

	private void config() {
		view = new View();
	}
	
	public void sendTag(Tag tag) {
		view.showAlert(mountMessage(tag));
	}
	
	private String mountMessage(Tag tag) {
		return tag.toString();
	}
}
