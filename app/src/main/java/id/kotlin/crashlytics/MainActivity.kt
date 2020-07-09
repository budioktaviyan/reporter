package id.kotlin.crashlytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import id.kotlin.crashlytics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var crashlytics: FirebaseCrashlytics

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    crashlytics = FirebaseCrashlytics.getInstance()

    val view = binding.root
    setContentView(view)
    setupListener()
  }

  private fun setupListener() {
    binding.btnCrash.setOnClickListener { throw RuntimeException("Crash me!") }
  }
}