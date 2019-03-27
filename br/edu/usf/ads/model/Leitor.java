package br.edu.usf.ads.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Leitor {
	
	Set<Tag> fakeTags = new HashSet<>();
	
	public Leitor() {
		config();
	}
	
	public Tag lerTag() {
		return readFakeTag();
	}
	
	private void config() {
		fillFakeTags();
	}
	
	private Tag readFakeTag() {
		Optional<Tag> findAny = fakeTags.stream().findAny();
		if (findAny.isPresent()) {
			Tag tag = findAny.get();
			fakeTags.remove(tag);
			return tag;
		}
		return null;
	}
	
	private void fillFakeTags() {
		for (int i = 0; i < 10; i++) {
			Tag tag = new Tag("i" + i, "s" + i, "" + i, "p" + i);
			fakeTags.add(tag);
		}
	}
}
