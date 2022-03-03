package ru.iis.framework.ui.test;

import ru.iis.framework.ui.base.BaseView;

public class TestContract {

    public interface View extends BaseView {
        void testItemResult(Object test);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<View> {
        void getTestItems();
    }
}
