package acsiustech.wolaapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static acsiustech.wolaapp.MainActivity.logintxt;
import static acsiustech.wolaapp.MainActivity.logntxt;

public class LoginActivity extends AppCompatActivity {

    Button LoginBtn,RegisterBtn, loginbutton;
    EditText editTextEmail,editTextPass;
    TextView fortpasstxt;

   //public TextView logouttxt,logntxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // getSupportActionBar().setTitle("Register");
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Login </font>"));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        LoginBtn=(Button)findViewById(R.id.loginbtn);
        RegisterBtn=(Button)findViewById(R.id.regbtn);

        loginbutton=(Button)findViewById(R.id.buttonL);
        editTextEmail=(EditText)findViewById(R.id.editTextU);
        editTextPass=(EditText)findViewById(R.id.editTextP);

//        logouttxt=(TextView)findViewById(R.id.logouttxt);
//         logntxt=(TextView)findViewById(R.id.logintxt);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterBtn.setBackgroundColor(Color.BLACK);
                RegisterBtn.setTextColor(Color.WHITE);
                LoginBtn.setBackgroundColor(Color.WHITE);
                LoginBtn.setTextColor(Color.BLACK);

                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextEmail.getText().toString().equals("naseem@gmail.com")||editTextPass.getText().toString().equals("naseem12"))
                {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));

                       // logintxt.setText("Logout");
                }
                else {
                    Toast.makeText(LoginActivity.this,"Invalid mail id and pass",Toast.LENGTH_SHORT).show();
                }

            }
        });

        fortpasstxt=(TextView)findViewById(R.id.textViewfrgt);
        fortpasstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
            }
        });

    }


}
