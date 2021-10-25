# Modifications in this fork


## Changes in the TipsHints branch:

### This branch addresses the following issue:
#### Add tips and hints that would pop up at certain times during play. ([issue #65](https://github.com/hhaslam11/Text-Fighter/issues/65) in the source hhaslam11/Text-Fighter repository, [issue #12](https://github.com/emmamickas/Text-Fighter/issues/12) in the forked emmamickas/Text-Fighter repository)

### Desired Modifications:
#### In the current implementation, there are no tips or hints to help the fighter navigate their journey through the game. In the updated version (**under construction), the fighter will receive a helpful hint after every other enemy or monster they kill. This could be something as simple as "Some monsters may be too powerful to kill at low levels. Come back and fight them after you've gained some experience and gear."

### Modified Files:
* [Enemy](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Enemy)

### Testing:
#### The following tests were performed during TDD: **under construction
* TestTipsHints.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/TestTipsHints.java)

### This issue is not quite completed, but the bones are there to flesh out. The idea is that when an enemy dies, the player's Stats.kill % 2 == 0. This makes it true on even number kills. When true, the function tipsHints() is called where a string array containing all of the tips lives. A random number is chosen and the message in that index is displayed on the screen.


