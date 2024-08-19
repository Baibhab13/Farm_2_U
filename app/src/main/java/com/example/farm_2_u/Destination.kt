package com.example.farm_2_u

interface Destination {
    val route : String
}

object Homepage: Destination {
    override val route = "home"
}

object Landingpage:Destination{
    override val route = "landingpage"
}

object Loginpage:Destination{
    override val route = "login"
}

object GetOTPpage:Destination{
    override val route = "getotp"
}