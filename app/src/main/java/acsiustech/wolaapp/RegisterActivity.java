package acsiustech.wolaapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button LoginBtn,RegisterBtn, regbutton;
    EditText editTextname,editusername, editTextEmail,editTextPhn,editTextPass,editTextConfPass;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Register </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        LoginBtn=(Button)findViewById(R.id.loginbtn);
        RegisterBtn=(Button)findViewById(R.id.regbtn);

        editTextname=(EditText)findViewById(R.id.editTextNm);
        editusername=(EditText)findViewById(R.id.editUsername);
        editTextEmail=(EditText)findViewById(R.id.editTextem);
        editTextPhn=(EditText)findViewById(R.id.editTextphn);
        editTextPass=(EditText)findViewById(R.id.editTextpas);
        editTextConfPass=(EditText)findViewById(R.id.editTextps1);

        regbutton=(Button)findViewById(R.id.buttonS);

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

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate())
                {
                    Regst();
                }
            }
        });
    }

    private boolean isValidate()
    {
        final String email = editTextEmail.getText().toString().trim();

        if (editTextname.getText().toString().length() == 0) {
            editTextname.setError("Name not entered");
            editTextname.requestFocus();
            return false;
        }

        if (editusername.getText().toString().length() == 0) {
            editusername.setError("Username not entered");
            editusername.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return false;
        }
        if (editTextPhn.getText().toString().length() == 0) {
            editTextPhn.setError("Phone number not entered");
            editTextPhn.requestFocus();
            return false;
        }

        if (editTextPass.getText().toString().length() == 0) {
            editTextPass.setError("Password not entered");
            editTextPass.requestFocus();
            return false;
        }

        if (editTextConfPass.getText().toString().length() == 0) {
            editTextConfPass.setError("Please confirm password");
            editTextConfPass.requestFocus();
            return false;
        }

        if (!editTextPass.getText().toString().equals(editTextConfPass.getText().toString())) {
            editTextConfPass.setError("Password Not matched");
            editTextConfPass.requestFocus();
            return false;
        }

        if (editTextPass.getText().toString().length() < 5) {
            editTextPass.setError("Password should be atleast of 5 charactors");
            editTextPass.requestFocus();
            return false;
        }
        return true;
    }

    private void Regst(){
        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        final String name = editTextname.getText().toString().trim();
        final String Uname = editusername.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String phone = editTextPhn.getText().toString().trim();
        final String password = editTextPass.getText().toString().trim();

        //String url="https://demotbs.com/dev/grocery/webservices/registration?";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://1seoindia.com/wola/api/User/signup.php?",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("resp",response);
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            String success= obj.getString("s");
                            String error= obj.getString("e");
                            String msg=obj.getString("message");

                            if (success.equalsIgnoreCase("1"))
                            {

                                //SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                               // SharedPreferences.Editor edit = pref.edit();
                               // edit.putString("Myname",name);
                               // edit.putString("Myemail",email);
                               // edit.putString("Myphone",phone);
                                //edit.apply();

                                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                progressDialog.dismiss();
                                editTextname.setText("");
                                editusername.setText("");
                                editTextEmail.setText("");
                                editTextPhn.setText("");
                                editTextPass.setText("");
                                editTextConfPass.setText("");

                            }
//                            else {
//                                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
//                            }
//                            if (error.equalsIgnoreCase("0")){
//                                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
//                            }
                            else {
                                Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_name", name);
                params.put("user_login", Uname);
                params.put("user_email", email);
                params.put("user_phone", phone);
                params.put("user_pass ", password);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
