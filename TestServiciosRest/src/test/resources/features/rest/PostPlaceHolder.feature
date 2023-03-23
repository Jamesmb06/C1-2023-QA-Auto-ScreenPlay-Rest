Feature: Create a Post
  As a user of JSONPlaceholder API
  I want to create a new post
  So that I can share my thoughts with other users

  @CreatePost
  Scenario Outline: Create a Post Successful
    Given the user has a valid authentication token
    When the user sends a POST request to <endpoint> with the <title> and <body>
    Then the user receives a <status> response code and the <id> of the created post
    Examples:
      | title             | body                           | status | id  |
      | "My First Post"   | "This is my first post"        | 201    | 101 |
      | "My Second Post"  | "This is my second post"       | 201    | 102 |
      | "Invalid Request" | "This request should fail"     | 400    |     |
      | "Unauthorized"    | "This request should fail too" | 401    |     |