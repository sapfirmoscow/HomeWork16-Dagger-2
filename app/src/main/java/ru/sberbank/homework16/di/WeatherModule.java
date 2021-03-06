package ru.sberbank.homework16.di;

import dagger.Module;
import dagger.Provides;
import ru.sberbank.homework16.MainThreadImpl;
import ru.sberbank.homework16.data.ForecastRepositoryImpl;
import ru.sberbank.homework16.domain.executor.Executor;
import ru.sberbank.homework16.domain.executor.MainThread;
import ru.sberbank.homework16.domain.executor.impl.ThreadExecutor;
import ru.sberbank.homework16.domain.repository.ForecastRepository;
import ru.sberbank.homework16.presentation.presenters.MainPresenter;
import ru.sberbank.homework16.presentation.presenters.impl.MainPresenterImpl;

@Module
public class WeatherModule {

    @Provides
    public MainPresenter provideMainPresenter(Executor executor, MainThread mainThread, MainPresenter.View view, ForecastRepository forecastRepository) {
        return new MainPresenterImpl(executor, mainThread, view, forecastRepository);
    }

    @Provides
    public Executor provideExecute() {
        return ThreadExecutor.getInstance();
    }

    @Provides
    public MainThread provideMainThread() {
        return MainThreadImpl.getInstance();
    }


    @Provides
    public ForecastRepository provideForecastRepository() {
        return new ForecastRepositoryImpl();
    }


}
