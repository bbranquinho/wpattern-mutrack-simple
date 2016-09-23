package org.wpattern.mutrack.simple.packagee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.wpattern.mutrack.simple.R;

public class NewPackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_package);
        setActions();
    }

    private void setActions() {
        Button cancelButton = (Button) findViewById(R.id.cancelPackage);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewPackageActivity.this.finish();
            }
        });

        Button saveButton = (Button) findViewById(R.id.savePackage);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) NewPackageActivity.this.findViewById(R.id.namePackage);
                EditText codeText = (EditText) NewPackageActivity.this.findViewById(R.id.codePackage);
                EditText descriptionText = (EditText) NewPackageActivity.this.findViewById(R.id.descriptionPackage);

                PackageModel packagee = new PackageModel();

                packagee.setName(nameText.getText().toString());
                packagee.setCode(codeText.getText().toString());
                packagee.setDescription(descriptionText.getText().toString());

                packagee.save();
            }
        });
    }
}
