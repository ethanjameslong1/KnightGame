public class EnemyUndeadKnight extends Enemy {
  EnemyUndeadKnight(int level) {
    this.health = 7*level;
    this.armour = 'c';
    this.weapon = 's';
    this.name = "Undead Knight";

  }
}
