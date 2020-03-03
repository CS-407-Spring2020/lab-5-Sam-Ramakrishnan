package c.sakshi.lab5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    TextView tvWelcome;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvWelcome = findViewById(R.id.tv_welcome);
         sharedPreferences =
                getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
         tvWelcome.setText("Welcome " + sharedPreferences.getString("username","") +"!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_welcome_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menu_item_logout){
            sharedPreferences.edit().remove("username").apply();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
