package org.wpattern.mutrack.simple.packagee;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.wpattern.mutrack.simple.R;

import java.util.ArrayList;
import java.util.List;

public class PackageeAdapter extends ArrayAdapter<PackageModel> {

    public PackageeAdapter(Context context, List<PackageModel> packagees) {
        super(context, 0, packagees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PackageModel packagee = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.packagee_row_fragment, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.namePackageRow);
        TextView codeTextView = (TextView) convertView.findViewById(R.id.codePackageRow);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.descriptionPackageRow);

        nameTextView.setText(packagee.getName());
        codeTextView.setText(packagee.getCode());
        descriptionTextView.setText(packagee.getDescription());

        final View.OnClickListener codeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Code: " + packagee.getCode(), Snackbar.LENGTH_LONG).show();
            }
        };

        View.OnClickListener fabListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deleted the package \"" + packagee.getName() + "\"", Snackbar.LENGTH_LONG)
                        .setAction("Code", codeListener).show();
            }
        };

        FloatingActionButton fab = (FloatingActionButton)convertView.findViewById(R.id.buttonDelete);
        fab.setOnClickListener(fabListener);

        return convertView;
    }
}
