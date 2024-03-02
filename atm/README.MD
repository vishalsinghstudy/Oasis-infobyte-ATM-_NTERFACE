# ATM System in Java

This is a simple implementation of an Automated Teller Machine (ATM) system in Java. The system allows users to perform various transactions such as viewing transaction history, withdrawing money, depositing money, and transferring money to other users.

# Classes

The following classes are used in this implementation:

- `User`: Represents a user of the ATM system with a unique user ID and a PIN.
- `Transaction`: Represents a transaction performed by a user, with a transaction type and an amount.
- `Withdrawal`, `Deposit`, and `Transfer`: Subclasses of Transaction, representing specific types of transactions.
- `ATMSystem`: Represents the ATM system itself, including the current user, transaction history, and methods for performing various transactions.
- `Main`: The main class that creates an instance of `ATMSystem` and starts the system.

# Usage
To use the ATM system, run the `Main` class. The system will prompt you to enter your user ID and PIN. If the credentials are valid, you will be logged in and presented with a menu of options.

1. Transactions History: View the history of transactions performed by the current user.
2. Withdraw: Withdraw a specified amount of money from the current user's account.
3. Deposit: Deposit a specified amount of money into the current user's account.
4. Transfer: Transfer a specified amount of money to another user's account.
5. Quit: Exit the ATM system.

# Limitations
This implementation is a simplified example and does not include certain features that would be present in a real-world ATM system, such as:

- Persisting user data and transaction history between sessions.
- Validating user credentials against a database or external service.
- Handling errors and exceptions that may occur during transactions.
- Implementing proper encryption and security measures to protect user data and transactions.

# License
This implementation is released under the MIT License. See LICENSE for more information.

## 🔗 Contact 
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/vishalsinghstudy)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](linkedin.com/in/vishal-kumar-singh-492920256)