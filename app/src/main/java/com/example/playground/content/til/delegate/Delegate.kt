package com.example.playground.content.til.delegate

import kotlin.reflect.KProperty

// 고기 굽는 interface
interface Roasting {
    fun rare()
    fun medium()
    fun wellDone()
}

// 상속을 이용한다면 클래스를 만들때마다 일일이 override 진행
class Person(): Roasting {
    override fun rare() {
        // ...
    }

    override fun medium() {
        //...
    }

    override fun wellDone() {
        //...
    }
}

// 고기굽기 관련된 권한들
interface Authority {
    fun rare()
    fun medium()
    fun wellDone()
}

//////////////////////////////////////////////
// 일반적인 Delegate
//////////////////////////////////////////////
// 먹는거에 대해서 내가 뭘로먹을지 정할수 있는 권리.
class CustomerA(private val meat: String) : Authority {
    // Authority 인터페이스 구현
    override fun rare() {
        println("!!! $meat 레어로 굽기 !!!")
    }

    override fun medium() {
        println("!!! $meat 미디엄으로 굽기 !!!")
    }

    override fun wellDone() {
        println("!!! $meat 웰던으로 굽기 !!!")
    }
}

// 저는 요리사 입니다. 제가 대신 손님을 대신해 구워드립니다.
class ChefA(private val customer: Authority) : Authority {
    override fun rare() {
        customer.rare()
    }

    override fun medium() {
        customer.medium()
    }

    override fun wellDone() {
        customer.wellDone()
    }
}

fun mainA() {
    // 손님 D씨
    val customerD = CustomerA("소고기 등심")
    // 요리사 P씨
    val chefP = ChefA(customerD)

    chefP.medium() // 미디움으로 구워드리겠습니다.
}
////////////////////////////////////////////////////


//////////////////////////////////////////////
// by 키워드 이용한 Delegate
//////////////////////////////////////////////
class CustomerB(private val meat: String) : Authority {
    // Authority 인터페이스 구현
    override fun rare() {
        println("!!! $meat 레어로 굽기 !!!")
    }

    override fun medium() {
        println("!!! $meat 미디엄으로 굽기 !!!")
    }

    override fun wellDone() {
        println("!!! $meat 웰던으로 굽기 !!!")
    }
}

// 저는 요리사 입니다. 제가 대신 손님을 대신해 구워드립니다.
class ChefB(private val customer: Authority) : Authority by customer {
    // by 키워드로 customer 파라미터에게 권한을 위임.
}

fun mainB() {
    // 손님 D씨
    val customerD = CustomerB("소고기 등심")

    // 요리사 P씨
    val chefP = ChefB(customerD)

    chefP.medium() // 미디움으로 구워드리겠습니다.
}

//////////////////////////////////////////////
// 변수에서 바로 Delegate 사용
//////////////////////////////////////////////
class CustomerC(private val meat: String) : Authority {
    // Authority 인터페이스 구현
    override fun rare() {
        println("!!! $meat 레어로 굽기 !!!")
    }

    override fun medium() {
        println("!!! $meat 미디엄으로 굽기 !!!")
    }

    override fun wellDone() {
        println("!!! $meat 웰던으로 굽기 !!!")
    }

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): ChefC {
        return ChefC(this)
    }
}

// 저는 요리사 입니다. 제가 대신 손님을 대신해 구워드립니다.
class ChefC(private val customer: Authority) : Authority by customer { }

fun mainC() {
    // 손님 C의 권한을 받은 요리사
    val chefP : ChefC by CustomerC("소고기 등심")


    chefP.medium() // 미디움으로 구워드리겠습니다.
}