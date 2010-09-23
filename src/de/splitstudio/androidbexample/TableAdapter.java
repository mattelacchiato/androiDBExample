package de.splitstudio.androidbexample;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TableAdapter extends CursorAdapter {

	public TableAdapter(final Context context) {
		super(context, new Note(context).all());
	}

	@Override
	public void bindView(final View view, final Context context, final Cursor cursor) {
		int nameCol = cursor.getColumnIndex("name");

		String name = cursor.getString(nameCol);

		/**
		 * Next set the name of the entry.
		 */
		TextView name_text = (TextView) view.findViewById(R.id.name);
		if (name_text != null) {
			name_text.setText(name);
		}
	}

	@Override
	public View newView(final Context context, final Cursor cursor, final ViewGroup parent) {
		final LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.notes_row, parent, false);

		int nameCol = cursor.getColumnIndex("name");
		String name = cursor.getString(nameCol);

		TextView name_text = (TextView) v.findViewById(R.id.name);
		if (name_text != null) {
			name_text.setText(name);
		}

		return v;
	}

}
