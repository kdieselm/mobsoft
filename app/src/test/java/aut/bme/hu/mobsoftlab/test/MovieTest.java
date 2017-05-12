package aut.bme.hu.mobsoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import aut.bme.hu.mobsoftlab.BuildConfig;
import aut.bme.hu.mobsoftlab.ui.main.MainPresenter;
import aut.bme.hu.mobsoftlab.ui.main.MainScreen;
import aut.bme.hu.mobsoftlab.utils.RobolectricDaggerTestRunner;

import static aut.bme.hu.mobsoftlab.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MovieTest {
    private MainPresenter mianPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mianPresenter = new MainPresenter();
    }



    @Test
    public void testTodo() {
        MainScreen mainScreen = mock(MainScreen.class);
        mianPresenter.attachScreen(mainScreen);
        mianPresenter.getMovies();

        ArgumentCaptor<String> movieCaptor = ArgumentCaptor.forClass(String.class);
        verify(mainScreen, times(2)).showMessage(movieCaptor.capture());

        List<String> capturedMovies = movieCaptor.getAllValues();
        assertEquals("movie1", capturedMovies.get(0));
        assertEquals("movie2", capturedMovies.get(1));
    }



    @After
    public void tearDown() {
        mianPresenter.detachScreen();
    }
}
