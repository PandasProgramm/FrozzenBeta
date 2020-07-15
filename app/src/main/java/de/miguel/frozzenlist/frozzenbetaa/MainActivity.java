package de.miguel.frozzenlist.frozzenbetaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

   /**
   =============================================================================================
   @author Miguel Gutierrez, project FrozzenList
   @version 1.0Beta
   @param: set Loginscreen to insert frezzermanagment activity: Button for sign in and register.
   @Link to FreezerManager, Register
   =============================================================================================
    */

import static android.app.PendingIntent.getActivity;

public class MainActivity extends Activity{

    Button btnRegister;
    Button btnSignIn;
    EditText inputEmail;
    EditText inputPasswort;

    ArrayList<Serializable> userArrayList= new ArrayList<java.io.Serializable>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister= (Button)findViewById(R.id.bntRegister);
        btnRegister.setOnClickListener(view -> registerClick());

        btnSignIn= (Button)findViewById(R.id.bntSignIn);
        inputEmail= (EditText)findViewById(R.id.bntViewEmail);
        inputPasswort= (EditText)findViewById(R.id.btnViewPasswort);

        // sign in condition
        btnSignIn.setOnClickListener(view-> signInClick());
    }
    void signInClick(){
        Log.d("MainActivity","test");
        String userEmail = inputEmail.getText().toString();
        String passwort = inputPasswort.getText().toString();
        if(userEmail.isEmpty()) {
            inputEmail.setError("Bitte Email eingeben");
            inputEmail.requestFocus();
        }
        else if(passwort.isEmpty()){
            inputPasswort.setError("Bitte Passwort eingeben");
            inputPasswort.requestFocus();
        }
        if(!userEmail.isEmpty()&&!passwort.isEmpty()) {

            UserManager userManager= new UserManager(this);
            User user= new User(passwort,userEmail);
            for(int i=0;i<userManager.userList.size();i++){

                User compareUser= userManager.userList.get(i);
                Log.d("MainActivity", compareUser.getUserName());
                if(compareUser.getEmail().equals(user.getEmail())&&compareUser.getPasswort().equals(user.getPasswort())){

                    Intent intent= new Intent(MainActivity.this, FreezerManagment.class);
                    intent.putExtra("position", i);
                    startActivity(intent);
                }
            }
        }
    }
     //register button
        void registerClick(){
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);

    }
}