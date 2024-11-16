import java.util.Random;

public class EnemyOgre extends Enemy {
  EnemyOgre(int level) {
    this.health = 25*level;
    this.armour = 'l';
    this.weapon = 'c';
    this.name = "Ogre";
  }

}
