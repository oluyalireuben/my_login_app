package com.example.sheriff

class Donate {
    var name_donate:String = ""
    var phone_donate:String = ""
    var county_donate:String = ""
    var village_donate:String = ""
    var goods_donate:String = ""
    var pass_donate:String = ""

    constructor(name_donate:String, phone_donate:String, county_donate:String, village_donate:String, goods_donate:String, pass_donate:String){
        this.name_donate = name_donate
        this.phone_donate = phone_donate
        this.county_donate = county_donate
        this.village_donate = village_donate
        this.goods_donate = goods_donate
        this.pass_donate = pass_donate

    }
    constructor(){}
}