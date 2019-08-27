package acsiustech.wolaapp.Categories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import acsiustech.wolaapp.R;
import acsiustech.wolaapp.RecyclerViewItemClickListener;

/**
 * Created by SAI on 16-07-2019.
 */

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<ParentModel> productList;

    public ParentAdapter(Context mCtx, List<ParentModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ParentAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_group_header, null);
        return new ParentAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParentAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ParentModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(product.getName());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(view.getContext(), ChildActivity.class);
                view.getContext().startActivity(intent);

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
            this.itemClickListener.onClick(v,getLayoutPosition());
        }

        public void setItemClickListener(RecyclerViewItemClickListener ic)
        {
            this.itemClickListener=ic;

        }
    }
}
