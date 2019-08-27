package acsiustech.wolaapp.Lititon.FilterPkg;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import acsiustech.wolaapp.Categories.ParentAdapter;
import acsiustech.wolaapp.Categories.ParentModel;
import acsiustech.wolaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLeft extends Fragment {


    List<ParcatModel> productList;
    RecyclerView recyclerView;

    // This method will be invoked when the Fragment view object is created.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_left, container);

        // Get Fragment belonged Activity
        final FragmentActivity fragmentBelongActivity = getActivity();

        if(retView!=null)
        {

            recyclerView = (RecyclerView)retView.findViewById(R.id.recyclerView);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);

            productList = new ArrayList<>();

            productList.add(new ParcatModel("BRAND"));
            productList.add(new ParcatModel("SCHEDULED BOOKING"));
            productList.add(new ParcatModel("MORE"));
            productList.add(new ParcatModel("REFER & EARN"));

            ParCatAdapter adapter = new ParCatAdapter(getActivity(), productList);
            recyclerView.setAdapter(adapter);

//            // Click this button will show the text in right fragment.
//            Button androidButton = (Button)retView.findViewById(R.id.fragmentLeftButtonAndroid);
//            androidButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
//                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();
//
//                    // Get right Fragment object.
//                    Fragment rightFragment = fragmentManager.findFragmentById(R.id.fragmentRight);
//
//                    // Get the TextView object in right Fragment.
//                    final TextView rightFragmentTextView = (TextView)rightFragment.getView().findViewById(R.id.fragmentRightTextView);
//
//                    // Set text in right Fragment TextView.
//                    rightFragmentTextView.setText("You click Android button.");
//                }
//            });
//
//
//            // Click this button will show a Toast popup.
//            Button iosButton = (Button)retView.findViewById(R.id.fragmentLeftButtonIos);
//            iosButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(fragmentBelongActivity, "You click IOS button.", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//
//            // Click this button will show an alert dialog.
//            Button windowsButton = (Button)retView.findViewById(R.id.fragmentLeftButtonWindows);
//            windowsButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog alertDialog = new AlertDialog.Builder(fragmentBelongActivity).create();
//                    alertDialog.setMessage("You click Windows button.");
//                    alertDialog.show();
//                }
//            });
        }

        return retView;
    }
}
