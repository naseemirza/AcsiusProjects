package acsiustech.wolaapp.Cart;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import acsiustech.wolaapp.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>  {

    private List<CartModel> mApps;
    private Context mContext;

    public CartAdapter(Context context,List<CartModel> apps){
        mContext=context;
        mApps=apps;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.cartlayout, parent, false);
        return new CartAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder holder, int position) {
        final CartModel app=mApps.get(position);


        // String imageUrl = app.getImageUrl();
        String productName = app.getPName();
        String totalPrice = app.getPPrice();
        String totalCurncy = app.getPcurrn();


        holder.mTextViewName.setText(productName);
        holder.mTextViewCurncy.setText(totalCurncy);
        holder.mTextViewPrice.setText(totalPrice);


//        Glide.with(mContext)
//                .load(imageUrl)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .fitCenter()
//                .into(holder.mImageView);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.quantitytxt);

                final EditText qunty = dialog.findViewById(R.id.et);
                holder.textViewQty.setText(qunty.getText().toString());


                Button btnok = (Button) dialog.findViewById(R.id.btnok);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       // long result =  ((CheckOutActivity)mCtx).AddMethod(cartID, Integer.parseInt(qunty.getText().toString()));
                       // if (result == 1) {
                            holder.textViewQty.setText(qunty.getText().toString());
                            dialog.dismiss();

                       // }
                    }
                });

                Button btncn = (Button) dialog.findViewById(R.id.btncn);
                btncn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public int getItemViewType(int position){

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    //implements View.OnClickListener
    public class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewCurncy, textViewQty;
        public TextView mTextViewPrice;
        ImageButton add, remove;

        //private RecyclerViewItemClickListener itemClickListener;


        public ViewHolder(View itemView ) {

            super(itemView);
            mImageView=(ImageView)itemView.findViewById(R.id.compid);
            mTextViewName=(TextView) itemView.findViewById(R.id.prodname);
            mTextViewPrice=(TextView) itemView.findViewById(R.id.prdprice);
            textViewQty = itemView.findViewById(R.id.editqnty);
            mTextViewCurncy=(TextView) itemView.findViewById(R.id.prdcrncy);
            add=itemView.findViewById(R.id.add);

            //itemView.setOnClickListener(this);

        }
//        @Override
//        public void onClick(View v) {
//            this.itemClickListener.onClick(v,getLayoutPosition());
//        }
//
//        public void setItemClickListener(RecyclerViewItemClickListener ic)
//        {
//            this.itemClickListener=ic;
//
//        }
    }
}

