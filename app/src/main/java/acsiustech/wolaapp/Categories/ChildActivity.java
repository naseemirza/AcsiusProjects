package acsiustech.wolaapp.Categories;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.R;

public class ChildActivity extends AppCompatActivity {

    List<ChildModel> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Child list </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

        productList = new ArrayList<>();

        productList.add(new ChildModel("LITITON"));
        productList.add(new ChildModel("WALLOWIN"));
        productList.add(new ChildModel("PAPA"));
        productList.add(new ChildModel("COLLABORATIONS"));

        ChildAdapter adapter = new ChildAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
