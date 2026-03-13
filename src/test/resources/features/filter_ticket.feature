#author: Matias Nuñez
#language: en
Feature: Filter ticket for priority

  @FilterTicketForPriorityMedium
  Scenario Outline: Filter ticket for selected priority
    Given the operator is in view ticket window
    When select priority "<priority>"
    Then only show tickets from priority "<expected>"
    Examples:
        | priority | expected |
        | MEDIUM   | Media    |