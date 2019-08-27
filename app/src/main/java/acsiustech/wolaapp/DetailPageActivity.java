package acsiustech.wolaapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.Lititon.LititonAdapter;
import acsiustech.wolaapp.Lititon.LititonModel;
import acsiustech.wolaapp.NewCollection.NewCollcAdapter;
import acsiustech.wolaapp.NewCollection.NewCollcModel;

public class DetailPageActivity extends AppCompatActivity {

    List<NewCollcModel> productList;
    RecyclerView recyclerView;

    int minteger=1;
    Button addtocart;
    Vibrator vibrator;
    ImageButton fav,fav1, share;
    boolean isFav=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Lounge Chair </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrolview);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        addtocart=(Button)findViewById(R.id.Addtocart);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        fav=(ImageButton)findViewById(R.id.imgfav);
        fav1=(ImageButton)findViewById(R.id.imgfav1);
        share=(ImageButton)findViewById(R.id.imgshare);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        productList = new ArrayList<>();

        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));


        NewCollcAdapter adapter = new NewCollcAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isFav){
                    v.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    isFav=true;
                }
                else {
                    v.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                    isFav=false;
                }

            }
        });

//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentInvite = new Intent(Intent.ACTION_SEND);
//                intentInvite.setType("text/plain");
//                String body = "Link to your app";
//                String subject = "Your Subject";
//                intentInvite.putExtra(Intent.EXTRA_SUBJECT, subject);
//                intentInvite.putExtra(Intent.EXTRA_TEXT, body);
//                startActivity(Intent.createChooser(intentInvite, "Share using"));
//            }
//        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(TopOfferDetaillsActivity.this, CheckOutActivity.class));
//                if(v.getId() == prdid) {
//                    addtocart.setText("Applied");
//                    addtocart.setBackgroundResource(R.drawable.aftrapplybtn);
//                }
                //AddTocart();
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(500);
                }
            }
        });

    }

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }
    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.editqnty);
        displayInteger.setText("" + number);
    }
}
