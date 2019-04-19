package com.example.bluetooth

import a5.com.a5bluetoothlibrary.A5DeviceManager
import android.app.Application

class A5App : Application() {

    companion object {
        private lateinit var instance: A5App
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        A5DeviceManager.initializeDeviceManager(this)
    }

    fun getInstance(): A5App {
        return instance
    }
}