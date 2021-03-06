package de.miguel.frozzenlist.frozzenbetaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.HashMap;

/**
    ========================================================================
    @author Miguel Gutierrez, project FrozzenList
    @version 1.0Beta
    @param : freezer: addFreezer(), removeFreezer(), getFrezzer()
           To add Freezer we need to have number of Trays and a frezzer name
           We need to set a error information in editText field for Exceptions
           (parsing)we include to join a frezzermember on the same Activity
     @link Hawk freezerList to save freezer for Account
    ========================================================================

 */

public class FreezerManagment extends AppCompatActivity {

    EditText inputName;
    EditText inputNumberTrays;
    Button addFreezer;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    UserManager userManager;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freezer_manager);
        userManager= new UserManager(this);
        position= getIntent().getIntExtra("position",0);
        inputName = (EditText) findViewById(R.id.editTextName);
        inputNumberTrays = (EditText) findViewById(R.id.editTextNumberTray);
        addFreezer = (Button) findViewById(R.id.btnAdd);
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter= new RecyclerViewAdapter(position,userManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(new TouchCallBack(userManager,position,recyclerView));
        itemTouchHelper.attachToRecyclerView(recyclerView);


        addFreezer.setOnClickListener(view -> onButtonClick());
    }
    void onButtonClick(){
        userManager.userList.get(position).freezers.add(new Freezer(inputName.getText().toString(),Integer.parseInt(inputNumberTrays.getText().toString())));
        userManager.saveList();
        recyclerView.getAdapter().notifyItemInserted(userManager.userList.get(position).freezers.size()-1);
    }
}