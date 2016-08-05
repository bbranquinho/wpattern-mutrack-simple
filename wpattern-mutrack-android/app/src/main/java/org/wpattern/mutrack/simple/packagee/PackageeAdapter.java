package org.wpattern.mutrack.simple.packagee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.wpattern.mutrack.simple.R;

import java.util.ArrayList;

public class PackageeAdapter extends ArrayAdapter<PackageeBean> {

    public PackageeAdapter(Context context, ArrayList<PackageeBean> packagees) {
        super(context, 0, packagees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PackageeBean packagee = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.packagee_row_fragment, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.namePackageRow);
        TextView codeTextView = (TextView) convertView.findViewById(R.id.codePackageRow);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.descriptionPackageRow);

        nameTextView.setText(packagee.getName());
        codeTextView.setText(packagee.getCode());
        descriptionTextView.setText(packagee.getDescription());

        return convertView;
    }
}
