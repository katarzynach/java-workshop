# SOLUTION.md

## Crime Investigation API - Solution Guide

### Task 1: Investigate Suspicious Transactions

#### Steps:
1. **Implement the Endpoint**:
    - Implement the `POST /api/investigations` endpoint in the `InvestigationController` class.
    - Ensure it validates input parameters (`transactionId` and `reason`) and delegates the creation logic to the `InvestigationService`.

2. **Identify Suspicious Transactions**:
    - A transaction is suspicious if:
        - The amount is greater than or equal to €50,000.
        - The currency is not EUR.
        - The same account is involved in more than 3 transactions within a short period.

3. **Follow the Money Trail**:
    - Use the `/api/transactions` endpoint to retrieve all transactions.
    - Identify accounts involved in suspicious transactions.

4. **Create an Investigation**:
    - Use the `/api/investigations` endpoint to create an investigation for the suspicious transaction.
    - Provide the `transactionId` and `reason` as request parameters.

5. **Update Investigation Status**:
    - Update the investigation status using the `/api/investigations/{id}` endpoint.


---

### Task 2: Unit Testing

#### Steps:
1. **Run Tests**:
    - Execute the `InvestigationServiceTest` class.
    - Identify failing tests and analyze error messages.

2. **Fix Issues**:
    - Debug the failing tests and fix the underlying issues in the code or test logic.

3. **Verify**:
    - Re-run the tests to ensure all pass.

---

### Task 3: Add Suspicious Transactions Endpoint

#### Code Changes:

1. **Add Method in `TransactionService`**:
   Add a method to filter suspicious transactions.

   ```java
   public List<Transaction> getSuspiciousTransactions() {
       return transactionRepository.findAll().stream()
           .filter(transaction -> transaction.getAmount() >= 50000 ||
                                  !transaction.getCurrency().equals("EUR"))
           .collect(Collectors.toList());
   }
