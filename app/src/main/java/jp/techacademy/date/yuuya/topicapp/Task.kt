package jp.techacademy.date.yuuya.topicapp

import java.io.Serializable
import java.util.Date
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Task : RealmObject(), Serializable {
    var title: String = ""      // タイトル

    // id をプライマリーキーとして設定
    @PrimaryKey
    var id: Int = 0
}