# **Bank Account Management System**

This is a simple Java-based console application for managing bank accounts, performing transactions, and viewing transaction history. It includes input validation, account types, customer types, and a transaction logging system.

---

## 📌 **Features**

### **✔ Account Management**

* Create new accounts
* View all accounts
* Load sample accounts on startup

### **✔ Customer Types**

* Regular Customer
* Premium Customer (min deposit & extra benefits)

### **✔ Account Types**

* Savings Account
* Checking Account

### **✔ Transaction System**

* Deposit
* Withdrawal
* Validates insufficient balance
* Records all transactions

### **✔ Transaction History**

* View all transactions for a specific account

### **✔ Input Validation**

* Prevents invalid menu options
* Ensures numeric inputs
* Ensures non-empty text fields
* Ensures valid deposit/withdrawal amounts

---

## 🚀 **How to Run the Project**

### **1. Install Java**

You must have **Java 8 or above** installed.

Check your version:

```bash
java -version
```

If not installed, download from:
[https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

---

### **2. Clone or Download the Project**

If using Git:

```bash
git clone https://github.com/dusengepeggy/Bank_Account_Management_Lab
cd Bank_Account_Management_Lab
```

Or download the ZIP and extract it.

---

### **3. Ensure Your Project Has These Files**

Your project folder must include:

```
/src
   Main.java
   Account.java
   AccountManager.java
   Customer.java
   RegularCustomer.java
   PremiumCustomer.java
   SavingsAccount.java
   CheckingAccount.java
   Transaction.java
   TransactionManager.java
```

Make sure each class is inside the same package (or remove package declarations).

---

### **4. Compile the Program**

Navigate to your `src` folder in terminal:

```bash
cd src
```

Compile all Java files:

```bash
javac *.java
```

---

### **5. Run the Program**

After successful compilation:

```bash
java Main
```

The main menu should appear:

```
=======================================
  BANK ACCOUNT MANAGEMENT - MAIN MENU 
=======================================
    1. Create Account
    2. View Accounts
    3. Process Transaction
    4. View Transaction History
    5. Exit
Enter choice:
```

---

## 🧪 **Sample Data**

When the program starts, it automatically loads 5 sample accounts:

* John Smith – Savings
* Sarah Johnson – Checking
* Michael Chen – Savings
* Emily Brown – Checking
* David Wilson – Savings

You can immediately test:

* Deposits
* Withdrawals
* Viewing transaction history
* Viewing all accounts

---


## 📥 **Running in IntelliJ IDEA**

1. Open IntelliJ
2. Click **Open Project**
3. Select your project folder
4. Mark the `src` folder as **Sources Root** (Right-click → Mark Directory As → Sources Root)
5. Run `Main.java` using the green run button


