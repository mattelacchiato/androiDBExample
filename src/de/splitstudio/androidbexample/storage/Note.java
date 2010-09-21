package de.splitstudio.androidbexample.storage;

import de.splitstudio.androidb.Table;
import de.splitstudio.androidb.annotation.Column;

public class Note implements Table {

	@Column(autoIncrement = true, primaryKey = true)
	public Long id;

	@Column
	public String text;

	@Column
	public String name;

	public long getId() {
		return id;
	}

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

	@Override
	public boolean isNew() {
		return id == null;
	}

}
