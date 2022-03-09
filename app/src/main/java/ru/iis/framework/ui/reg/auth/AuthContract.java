package ru.iis.framework.ui.reg.auth;

import ru.iis.framework.ui.base.BaseView;
//Осталось от шаблона
public class AuthContract {

    public interface View extends BaseView {
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<AuthContract.View> {
    }
}
