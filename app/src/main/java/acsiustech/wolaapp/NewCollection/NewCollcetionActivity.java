package acsiustech.wolaapp.NewCollection;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.Lititon.LititonAdapter;
import acsiustech.wolaapp.Lititon.LititonModel;
import acsiustech.wolaapp.R;

public class NewCollcetionActivity extends AppCompatActivity {

    List<NewCollcModel> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_collcetion);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>New Collctions </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
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


    }
}
