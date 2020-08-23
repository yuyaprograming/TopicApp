package jp.techacademy.date.yuuya.topicapp

import java.io.Serializable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class Topic : RealmObject(), Serializable {
    var title: String = ""      // タイトル
    var contents: String = ""   // 内容

    // id をプライマリーキーとして設定
    @PrimaryKey
    var id: Int = 0
}