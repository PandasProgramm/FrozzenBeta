package de.miguel.frozzenlist.frozzenbetaa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.UnknownServiceException;
import java.util.ArrayList;

public class Register extends AppCompatActivity {




    Button regristryFinish;
    EditText inputName;
    EditText inputEmail;
    EditText setPasswort;
    EditText setControlPasswort;
    User user;
    UserManager userManager;







    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       regristryFinish=(Button)findViewById(R.id.btnRegistry);
       inputName= (EditText)findViewById(R.id.bntInputName);
       inputEmail=(EditText)findViewById(R.id.bntInputEmail);
       setPasswort=(EditText)findViewById(R.id.bntsetPasswort);
       setControlPasswort=(EditText)findViewById(R.id.bntControlPasswort);

       userManager= new UserManager(this);
       regristryFinish.setOnClickListener(view-> onFinishClick());


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void onFinishClick(){

        String newUser= inputName.getText().toString();
        String newEmail= inputEmail.getText().toString();
        String newPasswort= setPasswort.getText().toString();
        String newPasswortCommit= setControlPasswort.getText().toString();

        if(newPasswort.equals(newPasswortCommit)&&newUser.length()>0&&newEmail.length()>0){

            user= new User(newUser,newPasswort,newEmail);

            userManager.addUser(user);

            Intent loginScreen = new  Intent(Register.this,MainActivity.class);
            startActivity(loginScreen);


        }
    }
}
