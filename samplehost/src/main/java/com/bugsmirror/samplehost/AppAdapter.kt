package com.bugsmirror.samplehost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugsmirror.permissionchecker.AppInfo
import com.bugsmirror.samplehost.databinding.ItemAppBinding

class AppAdapter(
    private val apps: List<AppInfo>,
    private val onClick: (AppInfo) -> Unit
) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    inner class AppViewHolder(val binding: ItemAppBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppViewHolder(binding)
    }

    override fun getItemCount() = apps.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps[position]
        holder.binding.appName.text = app.appName
        holder.binding.icon.setImageDrawable(app.icon)
        holder.binding.root.setOnClickListener { onClick(app) }
    }
}
