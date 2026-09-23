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
There is no change old enpoints
All tests should pass
