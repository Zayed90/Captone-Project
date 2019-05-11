package p.a.capstoneproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterMain extends AppCompatActivity {
    DatabaseHelper db;
    EditText user1;
    EditText pass;
    EditText vrf_pass;
    Button btnregis;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);

        db = new DatabaseHelper(this);
        user1 = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        vrf_pass = (EditText)findViewById(R.id.vrf_password);
        btnregis = (Button) findViewById(R.id.btn_regis);
        login = (TextView) findViewById(R.id.txt_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterMain.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user1.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                String vrf_pwd = vrf_pass.getText().toString().trim();

                if(pwd.equals(vrf_pwd)){
                    long val= db.addUser(user,pwd);
                    if(val > 0 ){
                        Toast.makeText(RegisterMain.this,"You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveTologin = new Intent(RegisterMain.this, LoginActivity.class);
                        startActivity(moveTologin);
                    }else{
                        Toast.makeText(RegisterMain.this,"Registration Error", Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(RegisterMain.this,"Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
