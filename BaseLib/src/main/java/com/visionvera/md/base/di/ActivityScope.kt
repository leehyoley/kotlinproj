package com.visionvera.md.base.di

import javax.inject.Scope
import kotlin.annotation.Retention

/*
    Activity级别 作用域
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
