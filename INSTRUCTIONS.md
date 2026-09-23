**Crime Investigation API - Participant Guide**

_Your Mission_
A suspicious transaction has been detected.
Your task is to investigate the transaction, follow the money trail, identify the account owner and create an investigation.
During the investigation, you will use a REST API and Swagger UI to work with the available data.
Swagger UI: http://localhost:8080/swagger-ui/index.html#/

_Your Goal_
By the end of the investigation, you should be able to answer:
Who is behind the suspicious transaction?

_Suspicious Transaction Criteria_
A transaction is considered suspicious if it meets one or more of the following criteria:
1. The transaction amount is greater than or equal to €50,000.
2. The transaction involves a currency other than EUR.
3. The same account is involved in more than 3 transactions within a short period.

_Available Operations_
* GET - find and inspect information
* POST - create an investigation
* PUT - update an investigation
* DELETE - remove a false lead

_Final Result_
Identify the suspicious account and its owner and leave the relevant investigation with the status: UNDER_INVESTIGATION
Use Swagger UI to explore the API and follow the money trail.

**Unit Testing - Participant Guide**

_Your Mission_
The REST API is working, but how do we know that the application logic continues to work correctly?
In this part of the workshop, you will work with unit tests for the investigation service.

_Your Task_
Run the existing unit tests and investigate the result.
You should:

Run the InvestigationServiceTest class
Check which tests pass and which test fails
Read and understand the error message
Determine what is causing the failure
Fix the problem
Run the tests again

_Your Goal_
All tests should pass:
4 / 4 TESTS PASSED

Remember: a failing test does not necessarily mean that the application code is wrong. The test itself can contain a mistake.

**Additional Task - Suspicious Transactions Endpoint**

_Your Mission_
The existing endpoint returns all transactions, but investigators need a focused view of potentially suspicious activity.
Add an additional endpoint that returns only suspicious transactions according to the criteria from the first task.

_Your Task_
You should:

Add a dedicated endpoint for suspicious transactions
Document the new endpoint in Swagger UI
Add unit tests for new code - covering suspicious and non-suspicious transactions

_Your Goal_
The new endpoint returns only suspicious transactions

**Optional Tasks**

1. **Add Validation to Endpoints**
    - Add input validation to the @Controller endpoints (e.g., ensure `transactionId` is not null or negative, `reason` is not empty).
    - Use Spring Boot's `@Valid` and validation annotations like `@NotNull`, `@Size`, etc.

2. **Improve Swagger Documentation**
    - Add more detailed descriptions to the Swagger annotations for all endpoints.
    - Include examples for request parameters and responses.

3. **Add Logging**
    - Add basic logging to the @Service methods
    - Log method entry, exit, and any important events (e.g., when an investigation is created or updated).

4. **Add Pagination to Transactions Endpoint**
    - Modify the `getAllTransactions` endpoint to support pagination using query parameters (`page`, `size`).
    - Return paginated results instead of the full list.

5. **Add Filtering to Investigations**
    - Add query parameters to the `getAllInvestigations` endpoint to filter investigations by `status` or `reason`.
    - Implement the filtering logic in the `InvestigationRepository`.

6. **Refactor Repositories to Use Spring Data JPA**
    - Replace the current in-memory repository implementations with Spring Data JPA repositories.
    - Use an embedded database like H2 for persistence.

7. **Add Unit Tests for Edge Cases**
    - Write additional unit tests for edge cases in the `InvestigationService` and `TransactionService`.
    - Examples: invalid IDs, null inputs, or empty lists.

8. **Optimize Suspicious Transactions Logic**
    - Refactor the logic for identifying suspicious transactions to make it more efficient.


**Bonus Task**
- **Design a Dashboard**
    - Create a simple HTML page (or use Swagger UI) to display investigations and suspicious transactions in a user-friendly format.
There is no change old enpoints
All tests should pass
