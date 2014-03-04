package edu.bard.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity {
	public static final String TAG = "lab02";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate your View
        setContentView(R.layout.activity_to_do_list);
        
        // Get references to UI widgets
        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        
        // Create the Array List of to do items
        final ArrayList<String> todoItems = new ArrayList<String>();
        
        // Create the Array Adapter to bind the array to the List View
        final ArrayAdapter<String> aa;
        
        aa = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,
        		todoItems);
        
        // Bind the Array Adapter to the List View
        myListView.setAdapter(aa);
        
        myEditText.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
							(keyCode == KeyEvent.KEYCODE_ENTER)) {
						todoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				return false;
			}
		});
        Log.i(TAG, "onCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_list, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i(TAG, "onResume");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i(TAG, "onDestroy");
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.i(TAG, "onStart");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.i(TAG, "onStop");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.i(TAG, "onPause");
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	Log.i(TAG, "onSaveInstanceState");
    }
    
}
