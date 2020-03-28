package com.tom.kotlin.jpa

import javax.persistence.*

@Entity
data class Person @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        @Column(nullable = false)
        val name: String,
        @Column(nullable = true)
        val email: String? = null,
        @OneToMany(cascade = [CascadeType.ALL])
        val phoneNumbers: List<PhoneNumber>? = null)
