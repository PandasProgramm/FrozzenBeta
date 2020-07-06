package de.miguel.frozzenlist.frozzenbetaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class Freezer extends AppCompatActivity {

    ArrayList<Tray>trays=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freezer);
    }
    public ArrayList<Tray> getTrays(){
        UserManager userManager= new UserManager(this);

        return trays;
    }

}