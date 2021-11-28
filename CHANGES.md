# Modifications in this branch

## [Game.java](https://github.com/emmamickas/Text-Fighter/blob/Kyle-Deliverable-2/src/com/hotmail/kalebmarc/textfighter/main/Game.java)
### Long Method : start()
* Used the extract method to create new functions in order to shorten the start() method.
* Refactored duplicate code from the start(), town(), and home() methods. 
* Removed unused switch case (duplicate).
* Commented out unused code. Would delete, but there are plans to use it in the future.

### Dead / Unused Code: start() and variable declarations
* Corrected instances of dead code that cannot be reached by any means.
* Removed (block commented) unused code pertaining to items not yet implemented.
  * I would delete, but the dev has plans to use that code in the future.


# See below for more changes from the main branch from previous deliverables.

## Changes in the ShowSpecificPotionStats branch

### This branch addresses the following issue:
#### Show Specific Potion Stats, ([issue #58](https://github.com/hhaslam11/Text-Fighter/issues/58) in the source hhaslam11/Text-Fighter repository, [issue #7](https://github.com/emmamickas/Text-Fighter/issues/7) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current functionality, when a player views their stats, they are only able to view a total number of potions used, but not individual totals for different types of potions that they have used. The changes include separating the totals for individual potion types to display each total, while also keeping a total of all potions used by the player.

### Modified files:
#### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Dependency%20References), the following files were modified in the change:
* [Potion.java](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/Potion.java)
* [Stats.java](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/Stats.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [Potion](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java)
##### See [here](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/TESTING.md) for more information on testing.

### Resolution:
#### The branch was merged with master, closing issue #58:
[Pull request #125](https://github.com/hhaslam11/Text-Fighter/commit/659955becfa0eb803f4b214821f18dbef9419da8)

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Class%20Diagram) of modified classes.
* [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Dependency%20References) of modified or dependent classes.
* [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Sequence%20Diagrams) of modified or dependent methods.

## Changes in the AddConstantArrayListAccessModifiers branch

### This branch addresses the following issue:
#### Show Specific Potion Stats, ([issue #46](https://github.com/hhaslam11/Text-Fighter/issues/46) in the source hhaslam11/Text-Fighter repository, [issue #4](https://github.com/emmamickas/Text-Fighter/issues/4) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current implementation, when accessing an array from a static class including Weapon, Enemy, and Food, the array is accessed directly. The changes include implementing an access modifier to these arrays.

### Modified files:
#### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References), the following files were modified in the change:
* [Armour.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/item/Armour.java)
* [Weapon.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Weapon.java)
* [Enemy.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Enemy.java)
* [Food.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Food.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [Armour](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/item/ArmourTest.java)
* [Weapon](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/WeaponTest.java)
* [Enemy](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java)
* [Food](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/FoodTest.java)
* [Cheats](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java)
* [Debug](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/DebugTest.java)
##### See [here](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/TESTING.md) for more information on testing.

### Resolution:
#### The branch was merged with master:
[Pull request #127](https://github.com/hhaslam11/Text-Fighter/commit/555f73191bb4e5476f82c6f481dd3b8190866159)

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Class%20Diagram) of modified classes.
* [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References) of modified or dependent classes.
* [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Sequence%20Diagrams) of modified or dependent methods.

## Changes in the CriticalHits branch

### This branch addresses the following issue:
#### Critical Hits, ([issue #25](https://github.com/hhaslam11/Text-Fighter/issues/25) in the source hhaslam11/Text-Fighter repository, [issue #1](https://github.com/emmamickas/Text-Fighter/issues/1) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current functionality, the damage that a weapon can do can be increased by a critical multiplier based upon the weapon's type. The changes include adding another critical modifier that increases the damage done by weapons with bullets only. This modifier has a 0.01% chance to activate and increases damage by a factor of 10.

### Modified files:
#### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Dependency%20References), the following files were modified in the change:
* [Weapon.java](https://github.com/emmamickas/Text-Fighter/blob/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main/Weapon.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [Weapon](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main)
* [Enemy](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/src/com/hotmail/kalebmarc/textfighter/main)
##### See [here](https://github.com/emmamickas/Text-Fighter/blob/CriticalHits/TESTING.md) for more information on testing.

### Resolution:
#### Pending
A [pull request](https://github.com/hhaslam11/Text-Fighter/pull/129) has been made to merge the change onto the master branch of the source repo.

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Class%20Diagram) of modified classes.
* [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Dependency%20References) of modified or dependent classes.
* [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CriticalHits/Sequence%20Diagrams) of modified or dependent methods.

## Changes in the CheatsIndexOutOfBoundsFix

### This branch addresses the following issue:
#### Critical Hits, ([issue #130](https://github.com/hhaslam11/Text-Fighter/issues/130) in the source hhaslam11/Text-Fighter repository, [issue #9](https://github.com/emmamickas/Text-Fighter/issues/9) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current implementation, selecting the weaponstash cheat involves accessing an array of weapons in which the final index being referenced is the size of the array, which is out of the bounds of the array. The changes involve updating the condition of the loop that accesses the array to prevent the violation of the index.

### Modified files:
#### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Dependency%20References), the following files were modified in the change:
* [Cheats.java](https://github.com/emmamickas/Text-Fighter/blob/CheatsIndexOutOfBoundsFix/src/com/hotmail/kalebmarc/textfighter/main/Cheats.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [Cheats](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java)
##### See [here](https://github.com/emmamickas/Text-Fighter/blob/CheatsIndexOutOfBoundsFix/TESTING.md) for more information on testing.

### Resolution:
#### Pending
A [pull request](https://github.com/hhaslam11/Text-Fighter/pull/131) has been made to merge the change onto the master branch of the source repo.

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Class%20Diagram) of modified classes.
* [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Dependency%20References) of modified or dependent classes.
* [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/CheatsIndexOutOfBoundsFix/Sequence%20Diagrams) of modified or dependent methods.

## Changes in the InlineDocumentation Branch

#### This branch addresses the following issue:
#### Add better in-line documentation, ([issue #32](https://github.com/hhaslam11/Text-Fighter/issues/32) in the source hhaslam11/Text-Fighter repository, [issue #2](https://github.com/emmamickas/Text-Fighter/issues/2) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current implementation, there is no documentation throughout the project.
#### In the updated implementation, classes and methods will be documented.

### Modified files:
#### The following packages were modified in the change:
* [Casino Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/casino)
* [Item Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/item)
* [Main Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/main)
* [Player Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/player)

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Dependency Analysis](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/Dependency%20Analysis) of modified files.
* [Program Comprehension](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/Program%20Comprehension) of project.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/Class%20Diagram) of project.

## Changes in the HealthHelpSection

### This branch addresses the following issue:
#### Add more health info in Help section, ([issue #37](https://github.com/hhaslam11/Text-Fighter/issues/37) in the source hhaslam11/Text-Fighter repository, [issue #3](https://github.com/emmamickas/Text-Fighter/issues/3) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current implementation, the Health section of the Help Menus doesn't go into detail of the features available that affect player and enemies health.
#### In the updated implementation, the Health section describes all aspect of the game pertaining to player and enemy health.

### Modified files:
#### The following files were modified in the change:
* [Help.java](https://github.com/emmamickas/Text-Fighter/blob/HelpSectionUpdate/src/com/hotmail/kalebmarc/textfighter/main/Help.java)


### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/HealthHelpSection/Class%20Diagrams) of modified classes.
* [Dependency Reference](https://github.com/emmamickas/Text-Fighter/tree/HealthHelpSection/Dependency%20Reference) of Health class.

## Changes in the AddingPotions branch

### This branch addresses the following issue:
#### Potion Brewing and more options, ([issue #87](https://github.com/hhaslam11/Text-Fighter/issues/87) in the source hhaslam11/Text-Fighter repository, [issue #8](https://github.com/emmamickas/Text-Fighter/issues/8) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### In the current implementation, there are only two potion types and the player can only purchase potions. In the updated version there are now three types of potions and players can brew potions.

### Modified files:
#### The following files were modified in the change:
* [Chest.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/item/Chest.java)
* [Food.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Food.java)
* [Game.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Game.java)
* [Help.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Help.java)
* [Saves.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Saves.java)
* [Shop.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Shop.java)
* [Potion.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Potion.java)
* [Settings.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Settings.java)
* [Stats.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Stats.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [Potion](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java)
* [Settings](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/SettingsTest.java)
* [Enemy](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java)
* [Food](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/FoodTest.java)

##### See [here](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/TESTING.md) for more information on testing.

### Additional resources:
#### Please view the following to find additional documentation of the changes and the code involved in the changes.
* [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddingPotions/Class%20Diagram) of modified classes.
* [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/AddingPotions/Dependency%20Matrix) of modified or dependent classes.

## Changes in the AddTimeFeatures branch

### This branch addresses the following issue:
#### Time, ([issue #72](https://github.com/hhaslam11/Text-Fighter/issues/72) in the source hhaslam11/Text-Fighter repository, [issue #5](https://github.com/emmamickas/Text-Fighter/issues/5) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### Add a game clock that would keep track of time, days, months, and years. The game time would be faster than real world time by a certain amount.

### Modified files:
* [Game](https://github.com/emmamickas/Text-Fighter/blob/AddTimeFeatures/src/com/hotmail/kalebmarc/textfighter/main/Game.java)

### Added Files:
* [GameClock](https://github.com/emmamickas/Text-Fighter/blob/AddTimeFeatures/src/time/GameClock.java)


## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [TestGameClock](https://github.com/emmamickas/Text-Fighter/blob/AddTimeFeatures/src/tests/TestGameClock.java)


## Changes in the TrackGamePlayTime branch

### This branch addresses the following issue:
#### Time, ([issue #128](https://github.com/hhaslam11/Text-Fighter/issues/128) in the source hhaslam11/Text-Fighter repository, [issue #10](https://github.com/emmamickas/Text-Fighter/issues/10) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### Add a feature that will keep track of the total time played and the current session game play.

### Modified files:
* [Game](https://github.com/emmamickas/Text-Fighter/blob/AddTimeFeatures/src/com/hotmail/kalebmarc/textfighter/main/Game.java)
* [Saves](https://github.com/emmamickas/Text-Fighter/blob/TrackGamePlayTime/src/com/hotmail/kalebmarc/textfighter/main/Saves.java)

### Added Files:
* [TestTimeTrack](https://github.com/emmamickas/Text-Fighter/blob/TrackGamePlayTime/src/tests/TestTimeTrack.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
* [TestGameClock](https://github.com/emmamickas/Text-Fighter/blob/AddTimeFeatures/src/tests/TestGameClock.java)


## Changes in the UpdateReadme branch

### This branch addresses the following issue:
#### Time, ([issue #74](https://github.com/hhaslam11/Text-Fighter/issues/74) in the source hhaslam11/Text-Fighter repository, [issue #6](https://github.com/emmamickas/Text-Fighter/issues/6) in the forked emmamickas/Text-Fighter repository)

### Desired modifications:
#### Update the README.md file since because it hasn't been updated for a while.

### Modified files:
* [README](https://github.com/hhaslam11/Text-Fighter/blob/master/README.md)
    - Updated running instructions for IntelliJ and Gradle.
    - Added a clip that shows game play.
    - Updated contributors.

## Changes in the Achievements branch

### This branch addresses the following issue:

#### Add More Achievements, ([issue #94](https://github.com/hhaslam11/Text-Fighter/issues/94) in the source hhaslam11/Text-Fighter repository, [issue #11](https://github.com/emmamickas/Text-Fighter/issues/11) in the forked emmamickas/Text-Fighter repository)

### Desired Modifications:
#### There are currently 21 achievements in the game. They are also not very creative (i.e. level up, kill a specific monster, etc.).
#### The changes to this issue is that a handful of more creative and desireable achievements were added. Some are easy to achieve, some are not.

### Modified Files:
#### The following packages were modified in the change:
* [Main Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/main)
* [Player Package](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/player)

### Testing:
#### The following tests were performed during TDD:
* [TestAchievements.java](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/player/TestAchievements.java)


## Changes in the MoreEnemies branch

### This branch addresses the following issue:
#### Add way more enemies and monsters into the game, ([issue #19](https://github.com/hhaslam11/Text-Fighter/issues/19) in the source hhaslam11/Text-Fighter repository, [issue #13](https://github.com/emmamickas/Text-Fighter/issues/13) in the forked emmamickas/Text-Fighter repository)

### Desired Modifications:
#### In the current game, there are 10 enemies and monsters for the fighter to kill. The monsters typically come from a fantasy world. In the changes, the number of monsters have now more than doubled up to a total of 23 enemies and monsters spanning all genres of monsters (Greek mythology, Anglo Saxon legends, and good old folk stories).

### Modified Files:
#### The following packages were modified in the change
* [Game.java](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/main/Game.java)
* [Settings.java](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/player/Settings.java)
* [Help.java](https://github.com/emmamickas/Text-Fighter/tree/InlineDocumentationUpdate/src/com/hotmail/kalebmarc/textfighter/main/Help.java)

### Testing:
#### Testing for this issue was fairly straightforward. There wasn't much required for testing before the enemies were created, but regression testing and playtesting after implementation were both important to confirm accuracy and truancy.

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

