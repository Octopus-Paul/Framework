package ru.iis.framework.ui.main.profile;

import ru.iis.framework.ui.base.BaseView;

public class ProfileContract {

    public interface View extends BaseView {
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<ProfileContract.View> {
    }
}
