class Solution {
    fun myAtoi(s: String): Int {
        var ptr = 0
        var signedness = 1
        val str = StringBuilder()

        try {
            // step 1: whitespace
            while (s[ptr] == ' ') {
                ptr++
            }

            // step 2: signedness
            if (s[ptr] == '+') {
                ptr++
            } else if (s[ptr] == '-') {
                ptr++
                signedness = -1
            }

            // step 3: conversion
            // remove leading zeros
            while (s[ptr] == '0') {
                ptr++
            }
        } catch (e: Exception) {
            return 0
        }

        // read numbers
        while (ptr < s.length && s[ptr] in ('0'..'9')) {
            str.append(s[ptr])
            ptr++
        }

        // step 4: rounding
        if (str.length > 10) {
            return if (signedness == -1) Int.MIN_VALUE
            else Int.MAX_VALUE
        } else if (str.length == 0) {
            return 0
        }

        val answer = String(str).toLong() * signedness
        
        if (answer <= Int.MIN_VALUE) return Int.MIN_VALUE
        if (answer >= Int.MAX_VALUE) return Int.MAX_VALUE

        return answer.toInt()
    }
}