package acsiustech.wolaapp.WishList;

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

import acsiustech.wolaapp.Cart.CartAdapter;
import acsiustech.wolaapp.Cart.CartModel;
import acsiustech.wolaapp.R;

public class WishListAdapter  extends RecyclerView.Adapter<WishListAdapter.ViewHolder>  {

    private List<WishListModel> mApps;
    private Context mContext;

    public WishListAdapter(Context context,List<WishListModel> apps){
        mContext=context;
        mApps=apps;
    }

    @Override
    public WishListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.wishlistlayout, parent, false);
        return new WishListAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final WishListAdapter.ViewHolder holder, int position) {
        final WishListModel app=mApps.get(position);


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
        ImageButton add;


        //private RecyclerViewItemClickListener itemClickListener;


        public ViewHolder(View itemView ) {

            super(itemView);
            mImageView=(ImageView)itemView.findViewById(R.id.compid);
            mTextViewName=(TextView) itemView.findViewById(R.id.prodname);
            mTextViewPrice=(TextView) itemView.findViewById(R.id.prdprice);
            mTextViewCurncy=(TextView) itemView.findViewById(R.id.prdcrncy);
            textViewQty = itemView.findViewById(R.id.editqnty);
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
