package acsiustech.wolaapp.Lititon;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.Lititon.FilterPkg.FilterActivity;
import acsiustech.wolaapp.R;

public class ViewAllLititonActivity extends AppCompatActivity {

    List<LititonModel> productList;
    RecyclerView recyclerView;
    RelativeLayout sortrltv, filterreltv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_lititon);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>All Products </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);



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

        sortrltv=(RelativeLayout)findViewById(R.id.sortrelatv);
        filterreltv=(RelativeLayout)findViewById(R.id.filterrelatv);


        sortrltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(ViewAllLititonActivity.this);
                View mView = View.inflate(ViewAllLititonActivity.this, R.layout.sortlayout, null);
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();
                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                TextView srttxt=dialog.findViewById(R.id.sorttexttitle);
                srttxt.setPaintFlags(srttxt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                ImageView imageView=dialog.findViewById(R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

//                Button canclbtn=dialog.findViewById(R.id.cancl);
//                canclbtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });


            }
        });

        filterreltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ViewAllLititonActivity.this, FilterActivity.class));
            }
        });

    }
}
