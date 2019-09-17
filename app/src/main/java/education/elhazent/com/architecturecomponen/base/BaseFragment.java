package education.elhazent.com.architecturecomponen.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

abstract class BaseFragment extends Fragment implements BaseContract.BaseView {

    protected abstract int setContentView();
    protected abstract void onCreatedView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setContentView(),container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onCreatedView();
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
        Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String message) {

    }

    Context context(){
        return getContext();
    }
}
