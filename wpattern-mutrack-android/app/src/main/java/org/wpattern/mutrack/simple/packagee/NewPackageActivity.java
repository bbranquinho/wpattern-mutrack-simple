package org.wpattern.mutrack.simple.packagee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.wpattern.mutrack.simple.R;

public class NewPackageActivity extends AppCompatActivity {

    private PackageModel packagee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_package);
        setActions();

        packagee = (PackageModel) getIntent().getSerializableExtra("package");

        if (packagee == null) {
            packagee = new PackageModel();
        } else {
            packagee = packagee.findById();
            ((EditText) NewPackageActivity.this.findViewById(R.id.namePackage)).setText(packagee.getName());
            ((EditText) NewPackageActivity.this.findViewById(R.id.codePackage)).setText(packagee.getCode());
            ((EditText) NewPackageActivity.this.findViewById(R.id.descriptionPackage)).setText(packagee.getDescription());
        }
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

                packagee.setName(nameText.getText().toString());
                packagee.setCode(codeText.getText().toString());
                packagee.setDescription(descriptionText.getText().toString());

                packagee.save();

                NewPackageActivity.this.finish();
            }
        });
    }
}
