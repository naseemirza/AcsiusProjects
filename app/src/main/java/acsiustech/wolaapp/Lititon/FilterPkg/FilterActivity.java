package acsiustech.wolaapp.Lititon.FilterPkg;

import android.app.Dialog;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import acsiustech.wolaapp.Categories.ChildAdapter;
import acsiustech.wolaapp.Categories.ChildModel;
import acsiustech.wolaapp.Categories.ParentAdapter;
import acsiustech.wolaapp.Categories.ParentModel;
import acsiustech.wolaapp.R;

public class FilterActivity extends AppCompatActivity {

//    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
//    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();
//
//    private CustomAdapter listAdapter;
//    private ExpandableListView simpleExpandableListView;

//    List<ParcatModel> productListL;
//    RecyclerView recyclerViewL;
//
//    List<ChildcatModel> productListR;
//    RecyclerView recyclerViewR;

    //List<ParcatModel> productList;
   // RecyclerView recyclerView;

    ImageButton addmin,addmax;
    public TextView textViewmin, textViewmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#0000'>Filter by </font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        addmin=(ImageButton)findViewById(R.id.add);
        addmax=(ImageButton)findViewById(R.id.add1);
        textViewmin=(TextView)findViewById(R.id.editqnty);
        textViewmax=(TextView)findViewById(R.id.editqnty1);

        addmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(FilterActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.minprice);

                final EditText qunty = dialog.findViewById(R.id.et);
                textViewmin.setText(qunty.getText().toString());

                Button btnok = (Button) dialog.findViewById(R.id.btnok);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // long result =  ((CheckOutActivity)mCtx).AddMethod(cartID, Integer.parseInt(qunty.getText().toString()));
                        // if (result == 1) {

                        if (qunty.getText().toString().length() == 0) {
                            qunty.setError("Please enter min price");
                            qunty.requestFocus();
                            return;
                        }
                        textViewmin.setText(qunty.getText().toString());
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

        addmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(FilterActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.maxprice);

                final EditText qunty = dialog.findViewById(R.id.et);
                textViewmax.setText(qunty.getText().toString());


                Button btnok = (Button) dialog.findViewById(R.id.btnok);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // long result =  ((CheckOutActivity)mCtx).AddMethod(cartID, Integer.parseInt(qunty.getText().toString()));
                        // if (result == 1) {

                        if (qunty.getText().toString().length() == 0) {
                            qunty.setError("Please enter max price");
                            qunty.requestFocus();
                            return;
                        }
                        textViewmax.setText(qunty.getText().toString());
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

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setHasFixedSize(true);
//
//        productList = new ArrayList<>();
//
//        productList.add(new ParcatModel("Price"));
//        productList.add(new ParcatModel("Category"));
//        productList.add(new ParcatModel("Brand"));
//        productList.add(new ParcatModel("Offers"));
//        productList.add(new ParcatModel("Discount"));
//
//        ParCatAdapter adapter = new ParCatAdapter(this, productList);
//        recyclerView.setAdapter(adapter);



//        recyclerViewL = (RecyclerView)findViewById(R.id.recyclrL);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerViewL.setLayoutManager(layoutManager);

        //Left view

       // recyclerViewL.setNestedScrollingEnabled(false);
       // recyclerViewL.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
       // recyclerViewL.setHasFixedSize(true);

//        productListL = new ArrayList<>();
//
//        productListL.add(new ParcatModel("Price"));
//        productListL.add(new ParcatModel("Category"));
//        productListL.add(new ParcatModel("Brand"));
//        productListL.add(new ParcatModel("Offers"));
//        productListL.add(new ParcatModel("Discount"));
//
//        ParCatAdapter adapterL = new ParCatAdapter(this, productListL);
//        recyclerViewL.setAdapter(adapterL);


        // Right View

//        recyclerViewR = (RecyclerView)findViewById(R.id.recyclerviewR);
//        final LinearLayoutManager layoutManagerR = new LinearLayoutManager(this);
//        layoutManagerR.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerViewR.setLayoutManager(layoutManagerR);

//        recyclerViewR = (RecyclerView)findViewById(R.id.recyclrR);
//        recyclerViewR.setNestedScrollingEnabled(false);
//        recyclerViewR.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        recyclerViewR.setHasFixedSize(true);

//        productListR = new ArrayList<>();
//
//        productListR.add(new ChildcatModel("BRAND"));
//        productListR.add(new ChildcatModel("SCHEDULED BOOKING"));
//        productListR.add(new ChildcatModel("MORE"));
//        productListR.add(new ChildcatModel("REFER & EARN"));
//
//
//        ChildcatAdapter adapterR = new ChildcatAdapter(this, productListR);
//        recyclerViewR.setAdapter(adapterR);

        // add data for displaying in expandable list view
//        loadData();
//
//        //get reference of the ExpandableListView
//        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
//        // create the adapter by passing your ArrayList data
//        listAdapter = new CustomAdapter(FilterActivity.this, deptList);
//        // attach the adapter to the expandable list view
//        simpleExpandableListView.setAdapter(listAdapter);
//
//        //expand all the Groups
//        expandAll();
//
//        // setOnChildClickListener listener for child row click
//        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                //get the group header
//                GroupInfo headerInfo = deptList.get(groupPosition);
//                //get the child info
//                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
//                //display it or do something with it
//                Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
//                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
//        // setOnGroupClickListener listener for group heading click
//        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                //get the group header
//                GroupInfo headerInfo = deptList.get(groupPosition);
//                //display it or do something with it
//                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
//                        Toast.LENGTH_LONG).show();
//
//                return false;
//            }
//        });


    }

    //method to expand all groups
//    private void expandAll() {
//        int count = listAdapter.getGroupCount();
//        for (int i = 0; i < count; i++){
//            simpleExpandableListView.expandGroup(i);
//        }
//    }
//
//    //method to collapse all groups
//    private void collapseAll() {
//        int count = listAdapter.getGroupCount();
//        for (int i = 0; i < count; i++){
//            simpleExpandableListView.collapseGroup(i);
//        }
//    }
//
//    //load some initial data into out list
//    private void loadData(){
//
//        addProduct("Android","ListView");
//        addProduct("Android","ExpandableListView");
//        addProduct("Android","GridView");
//
//        addProduct("Java","PolyMorphism");
//        addProduct("Java","Collections");
//
//    }
//
//
//
//    //here we maintain our products in various departments
//    private int addProduct(String department, String product){
//
//        int groupPosition = 0;
//
//        //check the hash map if the group already exists
//        GroupInfo headerInfo = subjects.get(department);
//        //add the group if doesn't exists
//        if(headerInfo == null){
//            headerInfo = new GroupInfo();
//            headerInfo.setName(department);
//            subjects.put(department, headerInfo);
//            deptList.add(headerInfo);
//        }
//
//        //get the children for the group
//        ArrayList<ChildInfo> productList = headerInfo.getProductList();
//        //size of the children list
//        int listSize = productList.size();
//        //add to the counter
//        listSize++;
//
//        //create a new child and add that to the group
//        ChildInfo detailInfo = new ChildInfo();
//        detailInfo.setSequence(String.valueOf(listSize));
//        detailInfo.setName(product);
//        productList.add(detailInfo);
//        headerInfo.setProductList(productList);
//
//        //find the group position inside the list
//        groupPosition = deptList.indexOf(headerInfo);
//        return groupPosition;
//    }

}
