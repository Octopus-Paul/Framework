package ru.iis.framework.ui.initiative;

import ru.iis.framework.ui.base.BaseView;

public interface InitiativeContract {
    interface View extends BaseView {
        //Отслежевание изменения цены
        void changeCount(float plus);
        //Отслежевание клика на кнопку покупки
        void buyButton(float bonus, float minus);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<InitiativeContract.View> {
    }
}
