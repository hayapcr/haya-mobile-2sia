//import android.Manifest
//import android.icu.util.Calendar
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.appcompat.app.AppCompatActivity
//import com.example.haya_sparkle.databinding.ActivityReminderBinding
//import com.example.haya_sparkle.utils.PermissionHelper
//import com.example.haya_sparkle.utils.ReminderHelper
//
//class ReminderActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityReminderBinding
//
//    private val requestPermissionLauncher =
//        registerForActivityResult(
//            ActivityResultContracts.RequestPermission()
//        ) { }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityReminderBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        if (
//            PermissionHelper.isNotificationPermissionRequired() &&
//            !PermissionHelper.hasPermission(
//                this,
//                Manifest.permission.POST_NOTIFICATIONS
//            )
//        ) {
//
//            PermissionHelper.requestPermission(
//                requestPermissionLauncher,
//                Manifest.permission.POST_NOTIFICATIONS
//            )
//
//        }
//
//        binding.btnSetReminder.setOnClickListener {
//
//            val menit =
//                binding.etMenit.text.toString()
//                    .toIntOrNull()
//
//            if (menit == null || menit <= 0) {
//
//                Toast.makeText(
//                    this,
//                    "Masukkan jumlah menit",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                return@setOnClickListener
//            }
//
//            val calendar =
//                Calendar.getInstance().apply {
//                    add(Calendar.MINUTE, menit)
//                }
//
//            ReminderHelper.setReminder(
//                context = this,
//                hour = calendar.get(Calendar.HOUR_OF_DAY),
//                minute = calendar.get(Calendar.MINUTE),
//                title = "SiBansos",
//                message = "Jangan lupa memperbarui data warga"
//            )
//
//            Toast.makeText(
//                this,
//                "Reminder berhasil dibuat",
//                Toast.LENGTH_SHORT
//            ).show()
//
//        }
//
//    }
//}