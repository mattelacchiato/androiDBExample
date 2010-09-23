package de.splitstudio.androidbexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class Main extends ListActivity {
	private static final int DELETE_ID = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Note note = new Note(this);
		note.setName("foo");
		note.setText("bar");
		note.save();

		fillList();
		registerForContextMenu(getListView());
	}

	@Override
	protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
		super.onListItemClick(l, v, position, id);
		Note note = new Note(this, id);
		if (note.find()) {
			Toast.makeText(this, note.getText(), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onCreateContextMenu(final ContextMenu menu, final View v, final ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, DELETE_ID, 0, R.string.menu_delete);
	}

	@Override
	public boolean onContextItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
		case DELETE_ID:
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
			new Note(this, info.id).delete();
			fillList();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	private void fillList() {
		NoteAdapter tableAdapter = new NoteAdapter(this);
		setListAdapter(tableAdapter);
	}

}
