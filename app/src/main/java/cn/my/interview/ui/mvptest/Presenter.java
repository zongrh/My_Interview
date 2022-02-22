package cn.my.interview.ui.mvptest;

/**
 * FileName: Presenter
 * Author: nanzong
 * Date: 2022/2/18 3:48 上午
 * Description:
 * History:
 */
class Presenter {
    private MVPView mMVPView;
    private HttpModel mHttpModel;

    public Presenter(MVPView MVPView) {
        mMVPView = MVPView;
        mHttpModel = new HttpModel(new Callback() {
            @Override
            public void onResult(String text) {
                Presenter.this.mMVPView.updateTv(text);
            }
        });
    }
    public void request() {
        mHttpModel.request();
    }

}
