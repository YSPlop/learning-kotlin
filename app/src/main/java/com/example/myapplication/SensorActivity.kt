package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView

class SensorActivity : Activity(), SensorEventListener {

    private lateinit var textview: TextView
    private lateinit var sensorManager: SensorManager
    private var temperature: Sensor? = null
    private var isTemperatureSensorAvailable: Boolean = false

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
            isTemperatureSensorAvailable = true
        }else{
        }else{
            textview.text = "Temperature Sensor is not available"
            isTemperatureSensorAvailable = false
        }

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = event.values[0].toString()
        // Do something with this sensor data.
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        if (isTemperatureSensorAvailable) {
            sensorManager.registerListener(this, temperature, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        if (isTemperatureSensorAvailable) {
            sensorManager.unregisterListener(this)
        }
    }
}