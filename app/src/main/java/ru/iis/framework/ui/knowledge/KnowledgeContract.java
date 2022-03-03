package ru.iis.framework.ui.knowledge;

import ru.iis.framework.ui.base.BaseView;

public interface KnowledgeContract {
    public interface View extends BaseView {
        public void changeCount(float plus);
        public void buyButton(float bonus, float minus, int position);
    }

    interface Presenter extends ru.iis.framework.ui.base.Presenter<KnowledgeContract.View> {
    }
}
