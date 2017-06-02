package com.carmudi.test.injection.component;

import dagger.Subcomponent;
import com.carmudi.test.injection.PerFragment;
import com.carmudi.test.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}