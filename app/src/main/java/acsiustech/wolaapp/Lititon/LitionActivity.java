package acsiustech.wolaapp.Lititon;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.R;

public class LitionActivity extends AppCompatActivity {

    TextView litiontxt;
    CardView desccard;
    ImageView downare,uparw;

    List<LititonModel> productList;
    RecyclerView recyclerView;
    TextView ViewAlltxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lition);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Lititon </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrolview);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        litiontxt=(TextView)findViewById(R.id.textViewDesc);
        downare=(ImageView)findViewById(R.id.arrow1);
        uparw=(ImageView)findViewById(R.id.arrow);
        desccard=(CardView)findViewById(R.id.desccard);

        desccard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (litiontxt.getVisibility()==View.VISIBLE){

                    litiontxt.setVisibility(View.GONE);
                    uparw.setVisibility(View.VISIBLE);
                    downare.setVisibility(View.GONE);
                }
                else {
                    litiontxt.setVisibility(View.VISIBLE);
                    uparw.setVisibility(View.GONE);
                    downare.setVisibility(View.VISIBLE);
                }
            }
        });

        ViewAlltxt=(TextView)findViewById(R.id.vwall);
        ViewAlltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LitionActivity.this, ViewAllLititonActivity.class));

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
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

    }
}
