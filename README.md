# IDEA-Cypher

**IDEA-Cypher** is a secure email exchange software that ensures confidentiality, authenticity, and integrity of email communication. The system uses modern cryptographic algorithms for secure encryption and key exchange.

## 🛠️ Technologies Used
- **Java**: Programming language used to develop the application.
- **JavaFX**: Framework for building the graphical user interface (GUI).
- **Scene Builder**: Tool for designing the GUI.
- **RSA**: Asymmetric encryption algorithm for secure key delivery.
- **IDEA (International Data Encryption Algorithm)**: Symmetric encryption algorithm for email encryption.
- **El-Gamal**: Digital signature algorithm for ensuring authenticity and integrity of the message.
- **SHA-256**: Cryptographic hash function used for additional security.

## 🌟 Features
- **Secure email exchange** using IDEA and RSA encryption.
- **Key exchange** secured with RSA encryption and El-Gamal signatures.
- **Message authentication** and integrity verification using El-Gamal.
- **SHA-256** for hashing the email content and providing security.

## 📚 Project Description

### Overview
The **IDEA-Cypher** project is a secure email system that ensures email messages are transmitted securely, without interception or tampering. It combines several cryptographic algorithms to protect data and verify sender identity.

### Core Functionalities:
1. **Key Generation and Secure Delivery**:
   - Alice and Bob exchange public keys and generate mutual private keys using RSA.
   - Alice encrypts the private key with Bob's public key and signs it using El-Gamal to ensure secure key exchange.

2. **Email Encryption/Decryption**:
   - The email content is encrypted and decrypted using the **IDEA algorithm** in OFB mode, providing robust encryption for secure communication.

3. **Digital Signature (El-Gamal)**:
   - **El-Gamal** is used to sign the encryption key and the encrypted email message. This guarantees the authenticity of the message and ensures that the sender cannot deny sending the email.

## 🔒 Security Highlights
- **Encryption**: Protects email content using the IDEA algorithm with a 128-bit key.
- **Key Exchange**: Secured with RSA and signed with El-Gamal for non-repudiation.
- **Message Integrity**: SHA-256 ensures the message has not been altered during transmission.

## 🎯 Conclusion
The **IDEA-Cypher** project demonstrates how combining RSA, IDEA, El-Gamal, and SHA-256 can create a highly secure email system. This system ensures that email communications are private, authentic, and tamper-proof.

---

## 📌 Getting Started
To run the application, simply clone the repository and compile the project in your Java IDE. No specific installation instructions are needed.

```bash
git clone https://github.com/MohamedAboSaleh/IDEA-Cipher.git
```
---
## 📄 License
This project was developed as part of academic coursework and is free to use for educational purposes.

