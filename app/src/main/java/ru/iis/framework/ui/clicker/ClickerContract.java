package ru.iis.framework.ui.clicker;

import ru.iis.framework.ui.base.BaseView;
import ru.iis.framework.ui.test.TestContract;

public interface ClickerContract {
    public interface View extends BaseView {
        public void changeCount(float plus);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<ClickerContract.View> {
    }
}
