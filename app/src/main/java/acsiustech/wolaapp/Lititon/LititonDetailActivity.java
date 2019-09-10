package acsiustech.wolaapp.Lititon;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.R;

public class LititonDetailActivity extends AppCompatActivity {

    List<LititonModel> productList;
    RecyclerView recyclerView;

    Button addtocart;
    Vibrator vibrator;

    TextView litiontxt;
    CardView desccard;
    ImageView downare,uparw;
    int minteger=1;
    ImageButton fav,fav1, share;
    boolean isFav=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lititon_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Kyodo Swing Chaire with stand </font>"));
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

//        litiontxt=(TextView)findViewById(R.id.textViewDesc);
//        downare=(ImageView)findViewById(R.id.arrow1);
//        uparw=(ImageView)findViewById(R.id.arrow);
//        desccard=(CardView)findViewById(R.id.desccard);
//
//        desccard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (litiontxt.getVisibility()==View.VISIBLE){
//
//                    litiontxt.setVisibility(View.GONE);
//                    uparw.setVisibility(View.VISIBLE);
//                    downare.setVisibility(View.GONE);
//                }
//                else {
//                    litiontxt.setVisibility(View.VISIBLE);
//                    uparw.setVisibility(View.GONE);
//                    downare.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        productList = new ArrayList<>();

        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new LititonModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));

        LititonAdapter adapter = new LititonAdapter(this, productList);
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
        if (minteger>1){
            minteger = minteger - 1;
            display(minteger);
        }
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.editqnty);
        displayInteger.setText("" + number);
    }
}
