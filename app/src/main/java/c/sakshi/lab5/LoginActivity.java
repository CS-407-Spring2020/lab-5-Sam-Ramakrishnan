package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsername;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences =
                getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

        if(!sharedPreferences.getString("username","").equals("")){
            startWelcomeActivity();

        }
        else {

            setContentView(R.layout.activity_login);
            btnLogin = findViewById(R.id.btn_login);
            txtUsername = findViewById(R.id.txt_username);


            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    sharedPreferences.edit().putString("username", txtUsername.getText() + "").apply();
                    startWelcomeActivity();

                }
            });
        }
    }

    void startWelcomeActivity(){
        Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
