package com.visionvera.md.base.di

import javax.inject.Scope

/*
    组件级别 作用域
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerComponentScope
