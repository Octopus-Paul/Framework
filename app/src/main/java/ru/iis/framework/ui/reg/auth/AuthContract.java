package ru.iis.framework.ui.reg.auth;

import ru.iis.framework.ui.base.BaseView;

public class AuthContract {

    public interface View extends BaseView {
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<AuthContract.View> {
    }
}
