package org.wpattern.mutrack.simple.packagee;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.wpattern.mutrack.simple.MainActivity;

import java.util.List;

public class PackageeListFragment extends ListFragment {

    private PackageeAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadPackages();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent (getActivity().getApplicationContext(), NewPackageActivity.class);

        PackageModel packagee = adapter.getItem(position);
        packagee.setMyId();
        intent.putExtra("package", packagee);

        startActivity(intent);
    }

    @Override
    public void onResume() {
        loadPackages();

        super.onResume();
    }

    private void loadPackages() {
        List<PackageModel> packagees = new PackageModel().findAll();

        adapter = new PackageeAdapter(getActivity(), packagees);

        setListAdapter(adapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        getListView().setDividerHeight(2);
    }
}
