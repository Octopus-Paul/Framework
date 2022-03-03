package ru.iis.framework.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.iis.framework.data.Prefs;
import ru.iis.framework.data.network.NetworkApi;
import ru.iis.framework.data.repository.AuthRepository;
import ru.iis.framework.data.repository.ClickerRepository;
import ru.iis.framework.data.repository.InitiativeRepository;
import ru.iis.framework.data.repository.KnowledgeRepository;
import ru.iis.framework.data.repository.TestRepository;

@Module
public class RepositoryModule {

    private Context context;

    public RepositoryModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Prefs providePrefs(){
        return new Prefs(context);
    }

    @Singleton
    @Provides
    public TestRepository provideTestRepository() {
        return new TestRepository(providePrefs());
    }

    @Singleton
    @Provides
    public AuthRepository provideAuthRepository(NetworkApi api) {
        return new AuthRepository(api, providePrefs());
    }

    @Singleton
    @Provides
    public ClickerRepository provideClickerRepository() {
        return new ClickerRepository(providePrefs());
    }

    @Singleton
    @Provides
    public InitiativeRepository provideInitiativeRepository() {
        return new InitiativeRepository(providePrefs());
    }

    @Singleton
    @Provides
    public KnowledgeRepository provideKnowledgeRepository() {
        return new KnowledgeRepository(providePrefs());
    }
}
