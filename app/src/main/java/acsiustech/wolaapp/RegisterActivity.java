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

public class RegisterActivity extends AppCompatActivity {

    Button LoginBtn,RegisterBtn, regbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       // getSupportAc
        // tionBar().setTitle("Register");
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Register </font>"));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        LoginBtn=(Button)findViewById(R.id.loginbtn);
        RegisterBtn=(Button)findViewById(R.id.regbtn);

        regbutton=(Button)findViewById(R.id.buttonL);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginBtn.setBackgroundColor(Color.BLACK);
                LoginBtn.setTextColor(Color.WHITE);
                RegisterBtn.setBackgroundColor(Color.WHITE);
                RegisterBtn.setTextColor(Color.BLACK);

                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

    }
}
