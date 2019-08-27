package acsiustech.wolaapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import static acsiustech.wolaapp.MainActivity.logintxt;
import static acsiustech.wolaapp.MainActivity.logntxt;

public class LoginActivity extends AppCompatActivity {

    Button LoginBtn,RegisterBtn, loginbutton;
    EditText editTextEmail,editTextPass;
    TextView fortpasstxt;
    ProgressDialog progressDialog;
   //public TextView logouttxt,logntxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Login </font>"));
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

                if (isOnline()) {

                } else {
                    try {
                        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(LoginActivity.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                        alertDialog.setIcon(R.drawable.ic_warning_black_24dp);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(LoginActivity.this,LoginActivity.class));
                            }
                        });
                        alertDialog.show();

                    } catch (Exception e) {
                    }
                }

                if(isValidate())
                {
                    Loginbtn();
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

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            // Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private boolean isValidate()
    {
        final String email = editTextEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return false;
        }

//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            editTextEmail.setError("Enter a valid email");
//            editTextEmail.requestFocus();
//            return false;
//        }

        if (editTextPass.getText().toString().length() == 0) {
            editTextPass.setError("Password not entered");
            editTextPass.requestFocus();
            return false;
        }
        if (editTextPass.getText().toString().length() < 5) {
            editTextPass.setError("Password should be atleast of 5 charactors");
            editTextPass.requestFocus();
            return false;
        }

        return true;
    }


    private void Loginbtn() {

        // Log.e("token", token);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPass.getText().toString().trim();

        // String url="https://demotbs.com/dev/grocery/webservices/login?";
        //String url="https://demotbs.com/dev/grocery/webservices/login?email="+email+"&password="+password;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://1seoindia.com/wola/api/User/login.php?user_login="+email+"&user_pass="+password,
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
                           // String user_id=obj.getString("user_id");
                            // Log.e("uid",success);
                            // String name=obj.getString("user_name");
                            //  String email=obj.getString("user_email");
                            //String phone=obj.getString("user_phone");

                            if (success.equalsIgnoreCase("1"))
                            {
                                //booltype=true;
                               // ads=true;
//                                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor edit = pref.edit();
//                                edit.putString("Myname",name);
//                                edit.putString("user_id",user_id);
//                                // edit.putString("name",name);
//                                edit.putString("Myemail",email);
//                                edit.putBoolean("Booltype",booltype);
//                                edit.putBoolean("Booltype1",ads);
//                                edit.putString("Myphone",phone);

                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                               // edit.apply();
                                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                editTextEmail.setText("");
                                editTextPass.setText("");
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                           // progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
                       // progressDialog.dismiss();
                    }
                });

//        {
//            @Override
//
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("user_name", email);
//                params.put("user_pass", password);
//
//                return params;
//            }
//        };

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(stringRequest);
    }

}
