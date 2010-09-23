package de.splitstudio.androidbexample;

import java.lang.reflect.Field;

import android.content.Context;
import de.splitstudio.androidb.Table;
import de.splitstudio.androidb.annotation.Column;

public class Note extends Table {

	Note(final Context context) {
		super(context);
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

	@Override
	protected void setValue(final Field field, final Object value) throws IllegalArgumentException,
			IllegalAccessException {
		field.set(this, value);
	}

	@Override
	protected Object getValue(final Field field) throws IllegalArgumentException, IllegalAccessException {
		return field.get(this);
	}

}