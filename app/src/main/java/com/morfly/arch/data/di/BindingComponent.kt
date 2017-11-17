package com.morfly.arch.data.di

import android.databinding.DataBindingComponent
import com.morfly.cleanarchitecture.core.presentationlayer.databinding.DataBindingAdapters
import com.morfly.cleanarchitecture.core.presentationlayer.databinding.DataBindingAdaptersDefault


class BindingComponent : DataBindingComponent {

    override fun getDataBindingAdapters(): DataBindingAdapters = DataBindingAdaptersDefault()
}