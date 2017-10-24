package com.morfly.cleanarchitecture.core.di.scope;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Dagger annotation
 * Custom scope for fragment
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
