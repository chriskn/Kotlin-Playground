package com.github.chriskn.kotlin.playground

class User(var name: String, var email: String?)

fun main(args: Array<String>) {
    var user: User? = null

    //val name = user.name

    checkForNull(user)
    safeCalls(user)
    elvis(user)
    nonNullAssertion(user)
}

private fun safeCalls(user: User?) {
    var username = user?.name
    //var nameLength = username.length // compiler error: username:String?

    var nameLength = user?.name?.length // ok: nameLength:Int?

    user?.email = user?.email + ".de" // conditional assignment
}

private fun checkForNull(user: User?) {
    var username = if (user != null) user.name else ""
    var nameLength = username.length // ok: username:String

    var email = if (user != null) user.email else ""
    //var emailLength = email.length // compiler error: email:String?
}

private fun elvis(user: User?) {
    //var email = user?.email ?: throw IllegalArgumentException("email expected")
    var email = user?.email ?: "default"
    var emailLength = email.length // ok: email is „default" if user or user.email is null
}

private fun nonNullAssertion(user: User?) {
    var username = user!!.name //NPE
}