# Changes in this branch (to be used in maintainability measurement work).

## Changes in the duplicateCodeRefactor branch

### This branch addresses instances of duplicate code fragments 
### Desired modifications:
#### In the current project, there are multiple instances of unnecessary duplicate code. The changes include refactoring these instances to reduce redundancy.

### Modified files:
#### The following files were modified in the change:
 * [InstaHealth.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/item/InstaHealth.java)
 * [FirstAid.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/item/FirstAid.java)
 * [Shop.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Shop.java)
 * [Weapon.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Weapon.java)
 * [Food.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Food.java)
 * [Armour.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/item/Armour.java)
 * [Enemy.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Enemy.java)
 * [UI.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Ui.java)
 * [Game.java](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/Game.java)

### Testing:
####  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [InstaHealth](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/item/InstaHealthTest.java)
 * [FirstAid](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/item/FirstAidTest.java)
 * [Shop](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/src/com/hotmail/kalebmarc/textfighter/main/ShopTest.java)

 ##### See [here](https://github.com/emmamickas/Text-Fighter/blob/duplicateCodeRefactor/TESTING.MD) for more information on testing.

 ### Additional resources:
 #### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [LOC per unit and method](https://github.com/emmamickas/Text-Fighter/blob/LongMethods/Maintenance%20Measurement/LOC.pdf) of modified classes.
  * [CBO](https://github.com/emmamickas/Text-Fighter/blob/LongMethods/Maintenance%20Measurement/CBO.pdf) of modified classes
  * [General Complexity Analysis](https://github.com/emmamickas/Text-Fighter/tree/LBSExtremeContraction/Maintenance%20Measurement/General%20Complexity)
  * [Code Analysis](https://github.com/emmamickas/Text-Fighter/tree/duplicateCodeRefactor/Code%20Analysis)



