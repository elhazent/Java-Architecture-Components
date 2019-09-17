package education.elhazent.com.architecturecomponen.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity extends AppCompatActivity implements BaseContract.BaseView {

    protected abstract int setContentView();
    protected abstract void onCreated();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        onCreated();
    }

    @Override
    public void onShowLoading() {
        Log.d("TAG", "show loading !");
    }

    @Override
    public void onHideLoading() {
        Log.d("TAG", "hide loading !");
    }

    @Override
    public void onSuccess(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String message) {

    }

    Context context(){
        return this;
    }
}
