package org.wpattern.mutrack.simple.packagee;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class PackageeListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<PackageModel> packagees = new ArrayList<>();

        packagees.add(new PackageModel("Package 1 asdf asdf asdfa asdf adf", "BR12341ASD", "Gradle build finished in 3s 580ms"));
        packagees.add(new PackageModel("Package 2", "CN13444DDF", "Executing tasks: [:app:assembleDebug]"));
        packagees.add(new PackageModel("Package 3", "XP123663DF", "Arduino"));
        packagees.add(new PackageModel("Package 4", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 5", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 6", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 7", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 8", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 9", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 10", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 11", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 12", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 13", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 14", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 15", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 16", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));
        packagees.add(new PackageModel("Package 17", "FD234566DF", "org.wpattern.mutrack.simple D/Atlas: Validating map"));


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
