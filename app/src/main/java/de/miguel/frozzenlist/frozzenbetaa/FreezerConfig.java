package de.miguel.frozzenlist.frozzenbetaa;

        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class FreezerConfig extends AppCompatActivity {

    User user;
    Button btnFreezerAdd;
    Button btnFreezerJoin;
    Button btnBack;
    TextView etDisplay;
    EditText input;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freezer_managment);

        btnFreezerAdd=(Button)findViewById(R.id.btnFreezerAdd);
        btnFreezerJoin=(Button)findViewById(R.id.btnFreezerJoin);
        btnBack=(Button)findViewById(R.id.btnBack);
        etDisplay=(TextView) findViewById(R.id.etDisplay);
        input= (EditText)findViewById(R.id.editTextInput);

        UserManager userManager= new UserManager(this);
        user=  userManager.userList.get(getIntent().getIntExtra("position",0));
        etDisplay.setText(user.getUserName()+"\n"+user.getEmail());



        btnFreezerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FreezerConfig.this,Freezer.class);
                startActivity(intent);
            }
        });
    }

}