package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.R;

// import from MainActivity
import static com.codepath.simpletodo.MainActivity.ITEM_POSITION;
import static com.codepath.simpletodo.MainActivity.ITEM_TEXT;
import static com.codepath.simpletodo.MainActivity.hideKeyboard;


public class EditItemActivity extends AppCompatActivity {

    EditText etItemText;
    int position;

    @Override
    // edit items with onCreate override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItemText = (EditText) findViewById(R.id.etItemText);
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        getSupportActionBar().setTitle("Edit Item");

    }

    // save edited item to list view
    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position);
        setResult(RESULT_OK, data);
        finish();
        hideKeyboard(this);
    }
}
