package part4.ru.part4.fragments.DeviceActivityNavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import part4.ru.part4.R;

public class DevicePartsFragment extends Fragment {
    public static final String ARG_MODEL = "ARG_MODEL";

    public static DevicePageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_MODEL, page);
        DevicePageFragment fragment = new DevicePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        mPage = getArguments().getInt(ARG_MODEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device_page_fragment, container, false);
        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPage);
        return view;
    }

}
