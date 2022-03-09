package ru.iis.framework.ui.clicker;

import ru.iis.framework.ui.base.BaseView;
import ru.iis.framework.ui.test.TestContract;

public interface ClickerContract {
    interface View extends BaseView {
        //Отслежевание изменения цены
        void changeCount(float plus);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<ClickerContract.View> {
    }
}
