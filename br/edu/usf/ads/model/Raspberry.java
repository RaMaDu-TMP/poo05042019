package br.edu.usf.ads.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import br.edu.usf.ads.controller.Controller;

public class Raspberry {

	private Leitor l;
	private ExecutorService executor;
	private Future<?> future;
	
	public Raspberry() {
		config();
	}
	
	private void config() {
		l = new Leitor();
		
		executor = Executors.newCachedThreadPool();
		
		future = executor.submit(() -> {
			while(!executor.isShutdown()) {
				loop();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		});
	}
	
	private void loop() {
		Tag tag = l.lerTag();
		if (tag == null) {
			return;
		}
		sendTagToView(tag);
	}
	
	public void shutdown() {
		if (future != null) {
			future.cancel(true);
		}
		executor.shutdownNow();
	}
	
	private void sendTagToView(Tag tag) {
		Controller.gi().sendTag(tag);
	}
}
