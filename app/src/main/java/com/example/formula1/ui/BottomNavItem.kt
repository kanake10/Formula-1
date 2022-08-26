package com.example.formula1.ui

import com.example.formula1.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Drivers : BottomNavItem("Drivers", R.drawable.ic_home,"Drivers")
    object GrandPix: BottomNavItem("GrandPix", R.drawable.ic_network,"GrandPix")
    object Constructors: BottomNavItem("Constructor",R.drawable.ic_post,"Constructors")
}
