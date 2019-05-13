package com.example.bluetooth

import a5.com.a5bluetoothlibrary.A5Device
import android.app.Activity
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.device_item.view.*

class DeviceAdapter(private val activity: Activity) : RecyclerView.Adapter<DeviceAdapter.DeviceRecyclerViewHolder>() {

    private var list = arrayListOf<A5Device>()
    private var positionSelected = -1

    inner class DeviceRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName = view.title_text_view!!
    }

    fun addDevice(a5Device: A5Device) {
        this.list.add(a5Device)
        notifyDataSetChanged()
    }

    fun clearDevices() {
        this.list.clear()
        positionSelected = -1
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceRecyclerViewHolder =
        DeviceRecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.device_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DeviceRecyclerViewHolder, position: Int) {
        val device = list[position]

        if (positionSelected == position) {
            holder.deviceName.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))
        } else {
            holder.deviceName.setBackgroundColor(ContextCompat.getColor(activity, android.R.color.transparent))
        }
        holder.deviceName.text = device.device.name

        holder.deviceName.setOnClickListener {
            (activity as MainActivity).deviceSelected(device)
            positionSelected = holder.adapterPosition
            notifyDataSetChanged()
        }
    }
}