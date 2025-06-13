package com.bugsmirror.samplehost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugsmirror.permissionchecker.PermissionChecker
import com.bugsmirror.samplehost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var permissionChecker: PermissionChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        permissionChecker = PermissionChecker(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.queryButton.setOnClickListener {
            val userInput = binding.permissionInput.text.toString()
            val perms = userInput.split(",").map { it.trim() }
            val apps = permissionChecker.getAppsByPermissions(perms)

            binding.recyclerView.adapter = AppAdapter(apps) {
                permissionChecker.openAppSettings(it.packageName)
            }
        }
    }
}
