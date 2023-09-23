package com.codeenemies.ecosync.firebase

import android.app.Activity
import android.util.Log
import com.codeenemies.ecosync.activities.MainActivity
import com.codeenemies.ecosync.activities.SignInActivity
import com.codeenemies.ecosync.activities.SignUpActivity
import com.codeenemies.ecosync.models.User
import com.codeenemies.ecosync.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error writing document.", e)
            }
    }

//    fun signInUser(activity: Activity) {
//        mFireStore.collection(Constants.USERS)
//            .document(getCurrentUserId())
//            .get()
//            .addOnSuccessListener { document ->
//                val loggedInUser = document.toObject(User::class.java)!!
//                when (activity) {
//                    is SignInActivity -> {
//                        activity.signInSuccess(loggedInUser)
//
//                    }
//
//                    is MainActivity -> {
////                        activity.updateNavigationUserDetails(loggedInUser)
//                    }
//                }
//            }.addOnFailureListener { e ->
//                when (activity) {
//                    is SignInActivity -> {
//                        activity.hideProgressDialog()
//
//                    }
//
//                    is MainActivity -> {
//                        activity.hideProgressDialog()
//                    }
//                }
//                Log.e("SignInUser", "Error occur while registering", e)
//            }
//    }

    fun getCurrentUserId(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
}