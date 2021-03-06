# Requirements

Start with a class following this structure

```java
public class AccountService {
public void deposit(int amount);
public void withdraw(int amount);
public void printStatement();
}
```

Rule:

1. You are not allowed to add any other public methods on the class
2. Use strings and integers for dates and amounts (keep it simple)
3. Dont worry about the spacing in the statement printed in the console

# Acceptance Criteria

Statements should have transactions in this format

>	DATE		| AMOUNT  | BALANCE

>	10/04/2014	| 500.00  | 1400.00

>	02/04/2014	| -100.00 | 900.00

>	01/04/2014	| 1000.00 | 1000.00

Scenario:
Given a client makes a deposit of 1000 on the first date

And a withdrawal of 100 on the next date

And a deposit of 500 on a final date

When they print their bank statements

Then they should see

>	DATE | AMOUNT | BALANCE

>	10/04/2014	| 500.00  | 1400.00

>	02/04/2014	| -100.00 | 900.00

>	01/04/2014	| 1000.00 | 1000.00


Feature: [Story 1] AccountFeature
In order to print transactions
As a user
I want to print my bank statement

Scenario: [Print Account Statement] PrintStatement

> STEP 1/6: GIVEN A Client Makes A Deposit [amount: "1000"]...

> STEP 2/6: AND A Client Makes A Withdrawal [amount: "100"]...

> STEP 3/6: AND A Client Makes A Deposit [amount: "500"]...

> STEP 4/6: WHEN A Client Prints A Statement...

> STEP 5/6: THEN They Should See Three Transactions In Reverse Order...

> STEP 6/6: AND They Should See A Formatted Statement...

FEATURE FINISHED: AccountFeature (Passed)