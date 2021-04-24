package com.esys.mvvmstarter;

import static org.mockito.Mockito.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import com.esys.mvvmstarter.data.repository.SampleRepositoryImpl;
import com.esys.mvvmstarter.data.repository.repo_interfaces.ISampleRepository;
import com.esys.mvvmstarter.ui.main.MainViewModel;
import com.esys.mvvmstarter.utils.threads.Threader;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.mockito.*;

@RunWith(JUnit4.class)
public class MainViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Observer<Boolean> mLoadingObserver;

    @Mock
    private SampleRepositoryImpl mSampleRepository;

    private MainViewModel mMainViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mMainViewModel = new MainViewModel(mSampleRepository);
    }

    @After
    public void tearDown() {
        mMainViewModel = null;
    }

    @Test
    public void insertSampleModel_ShouldDisplayLoading() {
        mMainViewModel.observerLoading().observeForever(mLoadingObserver);
        mMainViewModel.sampleInsert();

        verify(mLoadingObserver).onChanged(true);

    }
}
