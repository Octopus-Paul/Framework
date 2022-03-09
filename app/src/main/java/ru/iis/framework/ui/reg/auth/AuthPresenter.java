package ru.iis.framework.ui.reg.auth;

import javax.inject.Inject;

import ru.iis.framework.data.repository.AuthRepository;
import ru.iis.framework.ui.base.BasePresenter;
//Осталось от шаблона
public class AuthPresenter extends BasePresenter<AuthContract.View> implements AuthContract.Presenter {

    public AuthRepository authRepository;

    @Inject
    public AuthPresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void attachView(AuthContract.View view) {
        super.attachView(view);
    }
}
