package p.a.capstoneproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user1;
    EditText pass;
    Button btnlogin;
    TextView regis;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        user1 = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.login);
        regis = (TextView) findViewById(R.id.register);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterMain.class);
                startActivity(registerIntent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user1.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true){
                    Intent HomePage = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(HomePage);
                }else{
                    Toast.makeText(LoginActivity.this,"Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
