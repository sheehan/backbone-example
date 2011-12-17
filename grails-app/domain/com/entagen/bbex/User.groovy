package com.entagen.bbex

import java.security.MessageDigest

class User {

    static expose = 'user'

    String firstName
    String lastName
    String email

    static constraints = {
    }

    static transients = ['emailMd5Hash']

    String getEmailMd5Hash() {
        MessageDigest digest = MessageDigest.getInstance("MD5")
        digest.update(email.bytes)
        BigInteger big = new BigInteger(1, digest.digest())
        String md5 = big.toString(16).padLeft(32, "0")
        md5
    }
    
    Map mapify() {
        [
            id: id,
            firstName: firstName,
            lastName: lastName,
            email: email,
            emailMd5Hash: emailMd5Hash
        ]
    }
}
