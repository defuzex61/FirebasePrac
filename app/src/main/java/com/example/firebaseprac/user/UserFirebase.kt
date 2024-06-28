package com.example.firebaseprac.user

class UserFirebase(email1: String?, key1: String?) {

    var email: String? = email1
        set(email: String?){
            field = email
        }
        get() {
            return field
        }
    var key: String? = key1
        set(key: String?){
            field = key
        }
        get() {
            return field
        }




}