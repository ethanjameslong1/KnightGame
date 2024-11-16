public class EnemySorcerer extends Enemy{
  EnemySorcerer(int level) {
    this.health = 10*level;
    this.armour = 'r';
    this.weapon = 'w';
    this.name = "Sorcerer";

  }
}
