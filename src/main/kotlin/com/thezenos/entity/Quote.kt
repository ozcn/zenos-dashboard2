package com.thezenos.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(val type: String, val value: Value)
