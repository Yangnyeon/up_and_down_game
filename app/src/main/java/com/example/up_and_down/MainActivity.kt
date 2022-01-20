package com.example.up_and_down

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random = Random()
        var shuffle = random.nextInt(100) + 1
        var number = shuffle //랜덤숫자

        var i = 0
        try {
                btn1.setOnClickListener {
                    i++
                    var select: String = edt1.text.toString()
                    if (number.toString().toInt() > select.toString().toInt()) {
                        if (i <= 5) {
                            txt1.append(select.toString() + "보다 UP! \n\n")
                            edt1.setText("")
                        } else if (i == 6) {
                            txt1.append("게임이 종료되었습니다. \n\n")
                            txt1.append("정답은 : " + number.toString() + "이 였습니다. \n\n")
                        }
                    } else if (number.toString().toInt() < select.toString().toInt()) {
                        if (i < 5) {
                            txt1.append(select.toString() + "보다 DOWN! \n\n")
                            edt1.setText("")
                        } else if (i == 6) {
                            txt1.append("게임이 종료되었습니다. \n\n")
                            txt1.append("정답은 : " + number.toString() + "이 였습니다. \n\n")
                        }
                    } else if (number.toString().toInt() == select.toString().toInt()) {
                        txt1.append("$select 정답입니다! \n\n")
                        edt1.setText("")
                    }
                }
            }catch (e : Exception) {

            }
        }

    }

