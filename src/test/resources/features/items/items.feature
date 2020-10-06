Feature: Adding and removing items in the shopping cart

  Background:
  Given John is an email registered user
@This
  Scenario: Adding items to the cart
    When he adds an item to the cart
    Then the cart counter is updated with the extra item

  Scenario: Removing items from the cart
    Given he has items in his shopping cart
    When he removes an item from the the cart
    Then the cart counter updates with the decrement

  #Scenario: Loggin in
  # Given John is an email registered user
  # When he logs in with valid credentials
  #  Then he should see a list of categories in the home page
#adding elements to the cart
  #checking total
  #removing elements
  #less than 1 elements
  #api testing