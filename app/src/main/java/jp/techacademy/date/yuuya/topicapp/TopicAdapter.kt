package jp.techacademy.date.yuuya.topicapp

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class TopicAdapter : BaseAdapter() {
    var topicList = mutableListOf<String>()

    override fun getCount(): Int {
        return topicList.size
    }

    override fun getItem(position: Int): Any {
        return topicList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}