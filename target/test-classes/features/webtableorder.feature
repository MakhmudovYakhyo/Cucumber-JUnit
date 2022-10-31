Feature: Web table user order feature

  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "american express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table

  Scenario Template: User should be able to place order seen in web table with using DDT
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<ExpireDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    Examples: Famous male people
      | productType | quantity | customerName    | street            | city      | state   | zipCode | cardType         | cardNumber           | ExpireDate | expectedName    |
      | FamilyBae   | 2        | Sherlock Holmes | 221B Baker Street | London    | England | 50505   | american express | 1111222233334444     | 12/23      | Sherlock Holmes |
      | MoneyCog    | 4        | John Watson     | 117A New Street   | Cambridge | England | 31243   | mastercard       | 55556666777744448888 | 11/22      | John Watson     |
      | Screenable  | 7        | Jo Black        | 42AC Wolf Street  | New York  | USA     | 64234   | visa             | 9999000011112222     | 07/14      | Jo Black        |

    Examples: Famous female people
      | productType | quantity | customerName    | street            | city      | state   | zipCode | cardType         | cardNumber           | ExpireDate | expectedName    |
      | FamilyBae   | 2        | Sherlock Holmes | 221B Baker Street | London    | England | 50505   | american express | 1111222233334444     | 12/23      | Sherlock Holmes |
      | MoneyCog    | 4        | John Watson     | 117A New Street   | Cambridge | England | 31243   | mastercard       | 55556666777744448888 | 11/22      | John Watson     |
      | Screenable  | 7        | Jo Black        | 42AC Wolf Street  | New York  | USA     | 64234   | visa             | 9999000011112222     | 07/14      | Jo Black        |