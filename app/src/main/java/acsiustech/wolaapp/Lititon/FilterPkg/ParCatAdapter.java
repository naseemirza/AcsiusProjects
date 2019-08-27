package acsiustech.wolaapp.Lititon.FilterPkg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import acsiustech.wolaapp.Categories.ChildActivity;
import acsiustech.wolaapp.Categories.ParentAdapter;
import acsiustech.wolaapp.Categories.ParentModel;
import acsiustech.wolaapp.R;
import acsiustech.wolaapp.RecyclerViewItemClickListener;

public class ParCatAdapter extends RecyclerView.Adapter<ParCatAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<ParcatModel> productList;

    public ParCatAdapter(Context mCtx, List<ParcatModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ParCatAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.filterleft, null);
        return new ParCatAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParCatAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ParcatModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(product.getName());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

//                final Intent intent;
//                if (position == 0){
//                    intent =  new Intent(context, OneActivity.class);
//                } else if (getPosition() == sth2){
//                    intent =  new Intent(context, SecondActivity.class);
//                } else {
//                    intent =  new Intent(context, DifferentActivity.class);
//                }
//                context.startActivity(intent);

                //Intent intent = new Intent(view.getContext(), ChildActivity.class);
                //view.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.lblListHeader);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onClick(v, getLayoutPosition());
        }

        public void setItemClickListener(RecyclerViewItemClickListener ic) {
            this.itemClickListener = ic;

        }
    }
}
