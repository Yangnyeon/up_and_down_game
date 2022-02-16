package com.example.up_and_down

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
                    var chancenumber = 6 - i ;
                    var select: String = edt1.text.toString()
                    if (number.toString().toInt() > select.toString().toInt()) {
                        if (i <= 5) {
                            txt1.append(select.toString() + "보다 UP! \n\n")
                            edt1.setText("")
                            chance.text = "남은 기회는 $chancenumber 번 입니다. "
                        } else if (i == 6) {
                            txt1.append("게임이 종료되었습니다. \n\n")
                            txt1.append("정답은 : " + number.toString() + "이 였습니다. \n\n")
                            chance.text = "남은 기회는 $chancenumber 번 입니다. "
                        }
                    } else if (number.toString().toInt() < select.toString().toInt()) {
                        if (i <= 5) {
                            txt1.append(select.toString() + "보다 DOWN! \n\n")
                            edt1.setText("")
                            chance.text = "남은 기회는 $chancenumber 번 입니다. "
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

        var refresh = findViewById<SwipeRefreshLayout>(R.id.updown)
        refresh.setOnRefreshListener {

            txt1.setText("새로고침 되었습니다!")
            shuffle = random.nextInt(100) + 1
            number = shuffle //랜덤숫자
            chance.text = "당신에게 총 6번의 기회가 주어집니다."
            i = 0
            refresh.isRefreshing = false

        }
        }

    }

