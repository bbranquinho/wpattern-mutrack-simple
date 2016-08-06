package org.wpattern.mutrack.simple.packagee;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.wpattern.mutrack.simple.R;

import java.util.ArrayList;

public class PackageeListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] values = new String[] { "Android", "Windows 10", "Mac OS X" };

        ArrayList<PackageeBean> packagees = new ArrayList<>();

        packagees.add(new PackageeBean("Package 1", "BR12341ASD", "Gradle build finished in 3s 580ms"));
        packagees.add(new PackageeBean("Package 2", "CN13444DDF", "Executing tasks: [:app:assembleDebug]"));
        packagees.add(new PackageeBean("Package 3", "XP123663DF", "Arduino"));
        packagees.add(new PackageeBean("Package 4", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 5", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 6", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 7", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 8", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 9", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 10", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 11", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 12", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 13", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 14", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 15", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 16", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageeBean("Package 17", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));


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
