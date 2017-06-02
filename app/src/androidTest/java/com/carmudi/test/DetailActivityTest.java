package com.carmudi.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import com.carmudi.test.common.TestComponentRule;
import com.carmudi.test.common.TestDataFactory;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.detail.DetailActivity;
import com.carmudi.test.util.ErrorTestUtil;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<DetailActivity> main =
            new ActivityTestRule<>(DetailActivity.class, false, false);

    // TestComponentRule needs to go first to make sure the Dagger ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Test
    public void checkCarDisplays() {
        ResultsItem car = TestDataFactory.makeItem();
//        stubDataManagerGetPokemon(Single.just());
        main.launchActivity(
                DetailActivity.getStartIntent(InstrumentationRegistry.getContext(), car.getId()));
    }

    @Test
    public void checkErrorViewDisplays() {
        ResultsItem resultsItem = TestDataFactory.makeItem();
        main.launchActivity(
                DetailActivity.getStartIntent(InstrumentationRegistry.getContext(), resultsItem.getId()));
        ErrorTestUtil.checkErrorViewsDisplay();
    }


}