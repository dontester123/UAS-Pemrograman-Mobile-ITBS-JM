package com.example.projectuasramadhan.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projectuasramadhan.Domain.ItemsModel
import com.example.projectuasramadhan.Domain.BannerModel
import com.example.projectuasramadhan.Domain.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
 private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        val listdata= MutableLiveData<MutableList<BannerModel>>()
        val ref=firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list=mutableListOf<BannerModel>()
                for (childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(BannerModel::class.java)
                    item?. let {list.add(it) }
                }
                listdata.value=list


            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listdata
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        val listdata= MutableLiveData<MutableList<CategoryModel>>()
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list=mutableListOf<CategoryModel>()
                for (childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(CategoryModel::class.java)
                    item?. let {list.add(it) }
                }
                listdata.value=list


            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listdata
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        val listdata= MutableLiveData<MutableList< ItemsModel>>()
        val ref=firebaseDatabase.getReference("Popular")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list=mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(ItemsModel::class.java)
                    item?. let {list.add(it) }
                }
                listdata.value = list


            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listdata
    }
}