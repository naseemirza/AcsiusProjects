package acsiustech.wolaapp.Lititon.FilterPkg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import acsiustech.wolaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRight extends Fragment {

    // This method will be invoked when the Fragment view object is created.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_right, container);

//        if(retView!=null) {
//            TextView fragmentRightTextView = (TextView)retView.findViewById(R.id.fragmentRightTextView);
//            fragmentRightTextView.setText("This is the default right fragment.");
//        }
        return retView;
    }

}
