package acsiustech.wolaapp.Lititon.FilterPkg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import acsiustech.wolaapp.Categories.ChildAdapter;
import acsiustech.wolaapp.Categories.ChildModel;
import acsiustech.wolaapp.Lititon.LitionActivity;
import acsiustech.wolaapp.R;
import acsiustech.wolaapp.RecyclerViewItemClickListener;

public class ChildcatAdapter extends RecyclerView.Adapter<ChildcatAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<ChildcatModel> productList;

    public ChildcatAdapter(Context mCtx, List<ChildcatModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }
    @Override
    public ChildcatAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.filterright, null);
        return new ChildcatAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildcatAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ChildcatModel product = productList.get(position);
        //binding the data with the viewholder views
        holder.textViewName.setText(product.getName());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

               // Intent intent = new Intent(view.getContext(), LitionActivity.class);
               // view.getContext().startActivity(intent);

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

            textViewName = itemView.findViewById(R.id.lblListItem);

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