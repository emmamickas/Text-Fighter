# Devliverable 2 Changes


### This branch addresses the following issue:
#### The [Quest.java](https://github.com/hhaslam11/Text-Fighter/blob/master/src/com/hotmail/kalebmarc/textfighter/main/Quest.java) class constructor has a long parameter list code smell, poor encapsulation, and no tests written for it. The metrics of assessment that were focused on were analyzability, changeability, and testability.

### Desired modifications:
#### Fix the long parameter list code smell by introducing a parameter object. The parameter object that is passed to the Quest class constructor will be from a QuestBuilder class that is created when implementing a builder pattern. The poor encapsulation will be fixed by implementing getter and setter methods that will enable testing for the class.

### Modified files:
#### The following files were modified in the change:
 * [Quest.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/main/Quest.java)

### Added files:
#### The following files were created in the change:
 * [QuestBuilder.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/main/QuestBuilder.java)
 * [QuestCoins.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/item/QuestCoins.java)
 * [QuestHealth.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/item/QuestHealth.java)
 * [QuestStats.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/item/QuestStats.java)
 * [QuestXp.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/item/QuestXp.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [TestQuests.java](https://github.com/emmamickas/Text-Fighter/blob/Colin-Deliverable-2/src/tests/TestQuests.java)

 
 
 



