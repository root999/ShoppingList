package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private EditText shopItem;
    private Button sendButton;
    public static final String EXTRA_MESSAGE = "com.example.shoppinglist.filename";
    private static final String filename = "thelist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopItem = findViewById(R.id.shop_item);
        sendButton = findViewById(R.id.send_button);

    }
    public void sendItem(View view){
        String item = shopItem.getText().toString();
        Intent intent = new Intent(this,viewList.class);
        intent.putExtra(EXTRA_MESSAGE,filename);
        startActivity(intent);
    }
    public void saveItem(View view){
        String item = shopItem.getText().toString();
        try {
            FileOutputStream fos = getApplicationContext().openFileOutput(filename,Context.MODE_APPEND);
            fos.write("\n".getBytes());
            fos.write(item.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}