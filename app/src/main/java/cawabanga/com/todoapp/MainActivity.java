package cawabanga.com.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private TextView AppNameTextView;
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView listViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readItems();

        AppNameTextView = (TextView) findViewById(R.id.app_name);
        AppNameTextView.setTypeface(EasyFonts.caviarDreamsBold(this));

        listViewID = (ListView) findViewById(R.id.listViewID);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listViewID.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
        setupListViewListener();

    }

    private void setupListViewListener(){
        listViewID.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                saveItems();
                return true;
            }
        });


    }

    public void addTodoItem(View v){ //addTodoItem is onClick id from Button!!!!!*****
        EditText textBoxID = (EditText) findViewById(R.id.text_boxID);
        itemsAdapter.add(textBoxID.getText().toString()); //Adding text from textBox to items Adapter
        textBoxID.setText("");
        saveItems(); //write to file

    }

    private void readItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        }   catch (IOException e){
                items = new ArrayList<String>();
                e.printStackTrace();
        }

    }

    private void saveItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e){
            e.printStackTrace();
        }

    }



}
