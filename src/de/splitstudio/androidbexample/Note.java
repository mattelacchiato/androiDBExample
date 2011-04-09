package de.splitstudio.androidbexample;

import de.splitstudio.androidb.Table;
import de.splitstudio.androidb.annotation.Column;

public class Note extends Table {

	Note() {
		this(null);
	}

	Note(final Long id) {
		super(id);
	}

	@Column
	private String text;

	@Column
	private String name;

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
