package de.splitstudio.androidbexample;

import android.app.Activity;
import android.os.Bundle;
import de.splitstudio.androidb.Base;
import de.splitstudio.androidbexample.storage.Note;

public class Main extends Activity { 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Base base = new Base(this,"foo",1);
		Note note = new Note();
		note.setName("name");
		note.setText("sometext");
		base.save(note);
	}
}