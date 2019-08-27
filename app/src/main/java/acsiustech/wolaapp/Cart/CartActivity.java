package acsiustech.wolaapp.Cart;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.Payment.PaymentActivity;
import acsiustech.wolaapp.R;

public class CartActivity extends AppCompatActivity {

    List<CartModel> productList;
    RecyclerView recyclerView;
    Button continuebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Cart </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        continuebtn=(Button)findViewById(R.id.checkout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair Lounge Chair Longue Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));
        productList.add(new CartModel(R.drawable.lounge_chair,"Lounge Chair","$","110"));


        CartAdapter adapter = new CartAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
              //  SharedPreferences.Editor edit = pref.edit();
               // edit.putString("Tprice", String.valueOf(total));

               // edit.apply();
                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                startActivity(intent);
                //intent.putExtra("Tprice", String.valueOf(total));
            }
        });
    }
}
