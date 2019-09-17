package education.elhazent.com.architecturecomponen.base;

import androidx.annotation.StringRes;

public interface BaseContract {
    interface BasePresenter<V> {
        void onAttachView(V view);

        void onDettachView();

        V view();

        void onFinish();

        void catchError(Throwable error);
    }

    interface BaseView {
        void onShowLoading();

        void onHideLoading();

        void onSuccess(String string);

        void onError(String message);

        void onError(@StringRes int resId);
    }
}
