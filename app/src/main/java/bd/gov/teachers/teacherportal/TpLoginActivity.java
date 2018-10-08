package bd.gov.teachers.teacherportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TpLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       Button loginButton = (Button) findViewById(R.id.logbutton);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                loginCheck();
            }
        });
    }

    protected void loginCheck(){
        Intent myIntent = new Intent(TpLoginActivity.this, ProfileActivity.class);
       // myIntent.putExtra("key", value); //Optional parameters
        TpLoginActivity.this.startActivity(myIntent);

    }

}
