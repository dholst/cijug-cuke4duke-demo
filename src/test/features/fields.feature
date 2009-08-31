Feature: Fields
  Api users should have access to fields

  Scenario: should return a list of fields in xml format
    Given the following fields are in the database
      |id|name   |
      |1 |field 1|
      |2 |field 2|
    When an api user requests a field list in "application/xml" format
    Then the user should have received a "200" status code
    And the returned xml should be
      """
      <fields>
        <field>
          <id>1</id>
          <name>field 1</name>
        </field>
        <field>
          <id>2</id>
          <name>field 2</name>
        </field>
      </fields>
      """
