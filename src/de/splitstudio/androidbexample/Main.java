package de.splitstudio.androidbexample;

import android.app.ListActivity;
import android.os.Bundle;

public class Main extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Note note = new Note(this);
		note.setName("foo");
		note.setText("bar");
		note.save();
		setListAdapter(new TableAdapter(this));
	}
}
