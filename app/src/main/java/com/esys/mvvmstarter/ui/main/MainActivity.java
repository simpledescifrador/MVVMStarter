package com.esys.mvvmstarter.ui.main;

import static com.esys.mvvmstarter.utils.RequestCodes.STORAGE_PERMISSION_CODE;

import android.Manifest;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import com.esys.mvvmstarter.databinding.ActivityMainBinding;
import com.esys.mvvmstarter.ui.base.BaseActivity;
import com.esys.mvvmstarter.utils.PermissionUtility;
import com.esys.mvvmstarter.utils.ViewModelFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    private MainViewModel mMainViewModel;

    private ActivityMainBinding mMainBinding;

    private static final String[] WRITE_READ_STORAGE =
            {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate View Binding here inside onCreate()
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String @NotNull [] permissions, int @NotNull [] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(final int requestCode, @NonNull final List<String> perms) {
        if (STORAGE_PERMISSION_CODE == requestCode) {
            newSampleModel();
        }
    }

    @Override
    public void onPermissionsDenied(final int requestCode, @NonNull final List<String> perms) {
        if (STORAGE_PERMISSION_CODE == requestCode) {
            //Ask User to go settings manually allow permission
            PermissionUtility.openSettings(this);
        }
    }

    @Override
    protected void loadViewModels() {
        mMainViewModel = ViewModelProviders.of(this, new ViewModelFactory(getApplication())).get(MainViewModel.class);
    }

    @Override
    protected void initViews() {
        requestReadWrite();
    }

    @Override
    protected void observers() {
        //Observer Loading Dialog
        mMainViewModel.observerLoading().observe(this, loading -> {
            if (loading) {
                //Show Loading Here
            } else {
                //Hide Loading Here
            }
        });
    }

    private boolean hasWriteAndReadExternalStorage() {
        return EasyPermissions.hasPermissions(this, WRITE_READ_STORAGE);
    }

    @AfterPermissionGranted(STORAGE_PERMISSION_CODE)
    private void requestReadWrite() {
        if (hasWriteAndReadExternalStorage()) {
            newSampleModel();
        } else {
            EasyPermissions.requestPermissions(
                    this,
                    "This app need to write and read storage to store data",
                    STORAGE_PERMISSION_CODE,
                    WRITE_READ_STORAGE);
        }
    }
    private void newSampleModel() {
        mMainViewModel.sampleInsert();
    }

}