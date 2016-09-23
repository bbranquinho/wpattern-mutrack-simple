package org.wpattern.mutrack.simple.packagee;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.wpattern.mutrack.simple.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackageeListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<PackageModel> packagees = new PackageModel().findAll();

        PackageeAdapter adapter = new PackageeAdapter(getActivity(), packagees);

        setListAdapter(adapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        getListView().setDividerHeight(2);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

}
