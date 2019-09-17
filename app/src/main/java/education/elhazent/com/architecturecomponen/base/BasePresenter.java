package education.elhazent.com.architecturecomponen.base;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;
import io.reactivex.disposables.Disposable;
import java.lang.NullPointerException;

public class BasePresenter<V extends BaseContract.BaseView> implements BaseContract.BasePresenter<V> {

    V view;
    CompositeDisposable composite = new CompositeDisposable();

    void subscribe(Disposable disposable) {
        composite.add(disposable);
    }

    @Override
    public void onAttachView(V view) {
        if (view != null) {
            this.view = view;
        } else{
            throw new NullPointerException("View is null : Please attach your view on onCreated()");
        }
    }

    @Override
    public void onDettachView() {
        composite.clear();
    }

    @Override
    public V view() {
        return view;
    }

    @Override
    public void onFinish() {
        view.onHideLoading();
    }

    @Override
    public void catchError(Throwable error) {
        try {
            Log.e("TAG", error.getMessage());
            view.onHideLoading();
        } catch (Exception e) {
            view.onError(e.getMessage());
        }
    }
}
