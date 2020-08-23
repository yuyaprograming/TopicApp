package jp.techacademy.date.yuuya.topicapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.topic_input.*

class TopicActivity : AppCompatActivity() {

    private var mTopic: Topic? = null

    private val mOnDoneClickListener = View.OnClickListener {
        addTask()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        // ActionBarを設定する
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        done_button.setOnClickListener(mOnDoneClickListener)

        // EXTRA_TASK から Task の id を取得して、 id から Task のインスタンスを取得する
        val intent = intent
        val taskId = intent.getIntExtra(EXTRA_TOPIC, -1)
        val realm = Realm.getDefaultInstance()
        mTopic = realm.where(Topic::class.java).equalTo("id", taskId).findFirst()
        realm.close()

        if (mTopic == null) {
            // 新規作成の場合
        } else {
            // 更新の場合
            content_edit_text.setText(mTopic!!.contents)
        }
    }

    private fun addTask() {
        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()

        if (mTopic == null) {
            // 新規作成の場合
            mTopic = Topic()

            val topicRealmResults = realm.where(Topic::class.java).findAll()

            val identifier: Int =
                if (topicRealmResults.max("id") != null) {
                    topicRealmResults.max("id")!!.toInt() + 1
                } else {
                    0
                }
            mTopic!!.id = identifier
        }

        val content = content_edit_text.text.toString()

        mTopic!!.contents = content

        realm.copyToRealmOrUpdate(mTopic!!)
        realm.commitTransaction()

        realm.close()
    }
}
