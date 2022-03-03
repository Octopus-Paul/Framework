package ru.iis.framework.ui.initiative;

import ru.iis.framework.ui.base.BaseView;

public interface InitiativeContract {
    public interface View extends BaseView {
        public void changeCount(float plus);
        public void buyButton(float bonus, float minus);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<InitiativeContract.View> {
    }
}
