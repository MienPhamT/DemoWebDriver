Feature: Order a Kindle

 Scenario Outline: Order a Kindle
    Given go to Tiki
    When login Tiki by facebook "<username>" "<pass>"
    And choose product
    And order product
    Examples:
    |username|pass|
    |0332212277|PTM NQB 232711|




