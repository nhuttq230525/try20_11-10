package vn.edu.ute.try_20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName = findViewById<EditText>(R.id.etName)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = etName.text.toString().trim()
            val quantityStr = etQuantity.text.toString().trim()

            if (name.isEmpty()) {
                tvResult.text = "Lỗi: Tên không được để trống!"
                return@setOnClickListener
            }

            val quantity = quantityStr.toIntOrNull()
            if (quantity == null || quantity !in 1..9) {
                tvResult.text = "Lỗi: Số lượng phải từ 1 đến 9!"
                return@setOnClickListener
            }
            tvResult.text = "Xin chào $name, số lượng: $quantity"
        }
        btnReset.setOnClickListener {
            etName.text.clear()
            etQuantity.text.clear()
            tvResult.text = ""
        }
    }
}