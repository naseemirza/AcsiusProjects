package acsiustech.wolaapp.WishList;

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

import acsiustech.wolaapp.Cart.CartAdapter;
import acsiustech.wolaapp.Cart.CartModel;
import acsiustech.wolaapp.R;

public class WishlistActivity extends AppCompatActivity {

    List<WishListModel> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Wishlist </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair Lounge Chair Longue Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair Lounge Chair Longue Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new WishListModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));


        WishListAdapter adapter = new WishListAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
