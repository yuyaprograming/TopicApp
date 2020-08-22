package jp.techacademy.date.yuuya.topicapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var mTopicAdapter: TopickAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        // ListViewの設定
        mTaskAdapter = TaskAdapter(this@InputActivity)

        // ListViewをタップしたときの処理
        listView2.setOnItemClickListener { parent, view, position, id ->
            // 入力・編集する画面に遷移させる
        }

        // ListViewを長押ししたときの処理
        listView2.setOnItemLongClickListener { parent, view, position, id ->
            // タスクを削除する
            true
        }

        reloadListView()
    }

    private fun reloadListView() {
        // 後でTaskクラスに変更する
        val taskList = mutableListOf("aaa", "bbb", "ccc")

        mTaskAdapter.taskList = taskList
        listView1.adapter = mTaskAdapter
        mTaskAdapter.notifyDataSetChanged()
    }
}
