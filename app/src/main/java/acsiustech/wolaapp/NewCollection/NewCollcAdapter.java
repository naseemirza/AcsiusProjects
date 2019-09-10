package acsiustech.wolaapp.NewCollection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import acsiustech.wolaapp.DetailPageActivity;
import acsiustech.wolaapp.R;
import acsiustech.wolaapp.RecyclerViewItemClickListener;

/**
 * Created by SAI on 09-07-2019.
 */

public class NewCollcAdapter extends RecyclerView.Adapter<NewCollcAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<NewCollcModel> productList;

    public NewCollcAdapter(Context mCtx, List<NewCollcModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.litionlayout, null);  //collectionlayout

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        NewCollcModel product = productList.get(position);

        holder.textViewCurrncy.setText(product.getCurrency());
        holder.textViewPrice.setText(product.getPrice());
        holder.textViewName.setText("Kyodo Swing Chair "+"\n"+" with stand"); //product.getName()
        holder.textViewofftxt.setText(product.getOfftxt());
       // holder.textsold.setText(product.getSoldItems());
       // holder.textordrd.setText(product.getOrdrdItems());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(view.getContext(), DetailPageActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName,textViewofftxt,textsold,textordrd, textViewCurrncy,textViewPrice;
        ImageView imageView;
        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewCurrncy = itemView.findViewById(R.id.ftcdsgn);
            textViewPrice = itemView.findViewById(R.id.vwall);
            textViewName = itemView.findViewById(R.id.txtname);
            textViewofftxt = itemView.findViewById(R.id.txtoff);
            //textsold = itemView.findViewById(R.id.txtsold);
           // textordrd = itemView.findViewById(R.id.txtordered);
            imageView = itemView.findViewById(R.id.imageview);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onClick(v,getLayoutPosition());
        }

        public void setItemClickListener(RecyclerViewItemClickListener ic)
        {
            this.itemClickListener=ic;

        }
    }
}
