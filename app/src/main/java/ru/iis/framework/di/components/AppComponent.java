package ru.iis.framework.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.iis.framework.di.modules.NetworkModule;
import ru.iis.framework.di.modules.RepositoryModule;
import ru.iis.framework.ui.clicker.ClickerFragment;
import ru.iis.framework.ui.initiative.InititativeFragment;
import ru.iis.framework.ui.knowledge.KnowledgeFragment;
import ru.iis.framework.ui.main.profile.ProfileFragment;
import ru.iis.framework.ui.reg.auth.AuthFragment;
import ru.iis.framework.ui.test.TestFragment;

@Singleton
@Component(modules = {RepositoryModule.class, NetworkModule.class})
public interface AppComponent {
    //Инжектить при создании нового фрагмента
    void inject(TestFragment testFragment);
    void inject(AuthFragment authFragment);
    void inject(ProfileFragment profileFragment);
    void inject(ClickerFragment clickerFragment);
    void inject(InititativeFragment inititativeFragment);
    void inject(KnowledgeFragment knowledgeFragment);
}
