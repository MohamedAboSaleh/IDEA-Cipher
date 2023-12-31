# IDEA-Cipher
I collaborated with three other students on a project to develop a secure email exchange software. Our system incorporated encryption and decryption using IDEA in OFB mode, ensuring secure transmission of the secret key using RSA, and implementing a signature based on ElGamal. Additionally, we enhanced security using the SHA-256 hash function. Our collaborative efforts resulted in the successful development of a robust and secure email system.

## The project requirements:
In this assignment, we were required to develop an application for secure email exchange.
The implementation was divided into 3 parts:
*	Generate private key and apply secure delivery using RSA.
*	Email Encryption using IDEA algorithm in OFB mode.
*	The ability to validate the message's authenticity and integrity using the El-Gamal signature algorithm.

## Project Implementation:
Generate mutual key:
To allow members to communicate securely, we construct a shared private key using an asymmetric algorithm RSA.
Example: Alice wants to send Bob an E-mail, and they want to apply secure key delivery.
The flow of events:
*	Alice publishes her public key for El-Gamal signature.
*	Bob publishes his public key {e,n} for RSA.
*	Alice chooses the private key for Email encryption.
*	Alice encrypts the key using RSA with Bob’s public key.
*	Alice Signs the encrypted key.
*	Alice sends to Bob the encrypted key along with the signature.
*	Bob decrypt the cipher key and verify that Alice is the sender.

## Message encryption/decryption:
In this project we use IDEA algorithm to encrypt/decrypt 64-bit cipher text.
The algorithm uses 128-bit key and generates 52 subkeys.
The cipher text is generated by iterating through 8 and half rounds while each round uses 6 keys and encrypt the text using the algebraic operations XOR, modular addition, modular multiplication.

## Digital signature El Gamal:
In this assignment we used El-Gamal digital signature to guarantee authentication, integrity of data and non-repudiation.
El-Gamal signature was used to sign the encryption key and the cipher text (Email).
The flow went this way:
*	Alice sent Bob her El Gamal public key {q,a,Ya}
*	Bob verifies that Alice sent him the key and the cipher text
This way Alice and Bob are sure that they are Emailing each other.

## Conclusion:
In this assignment we bring out the symmetric encryption/decryption algorithm that allow us to send and receive Email with a complete privacy without anyone interfering or trying to change our texts with the ability of identifying the sender identity.
