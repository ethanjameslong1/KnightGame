import java.util.Random;
import java.util.Scanner;
// A little game to demonstrate my Java
// Currently working on an updated version
// that has a GUI component and items

//This was originically for an assignment
public class JavaBeanForestWalk {
  public static void main(String[] args) {

    Knight user = createUser();
    System.out.printf("%s%s%s%n%s","Great Choice ",user.getName(),". be prepared when entering Java Bean Forest",
        "as every enemy you encounter will only get stronger the deeper you get.");

    Scanner sc = new Scanner(System.in);
    int level = 1;
    while (user.health > 0) {
      System.out.printf("%s%n","While wandering in the forest how many enemies do you see coming?");
      int enemyNum = sc.nextInt();
      Enemy villain = Enemy.getRandomEnemy(level);
      int EachEnemyHealth = villain.health;


      try {
        System.out.printf("The ratio of User's health to Enemies health is %d.%n%n", (user.health / EachEnemyHealth));
      }
      catch (ArithmeticException e) {e.getMessage();}


      for (int i = 0; i<enemyNum; ++i){
        try {
          user.EnemyFight(villain);
        }
        catch (InvalidDamageException e){ System.out.println(e.getMessage()); }
        villain.health = EachEnemyHealth;
      }
      if (user.health > 0) user.Heal();
      level++;
    }
  }



  public static Knight createUser() {
    Random rand = new Random();
    System.out.printf("%s%n%s", "Welcome to the Java Bean Forest!", "Select your Character: ");
    System.out.printf("%s%n%s%n%s%n%s%n",
        "1) Bruce the Mighty",
        "2) Leon the Wicked Mage",
        "3) Eden the Wood Elf",
        "4) Ethan the Deadly");
    Scanner sc = new Scanner(System.in);
    int CharacterChoice = sc.nextInt();
    while (CharacterChoice < 1 || CharacterChoice > 4)
    {
      System.out.printf("%s%n","Please Enter a number from 1 to 4");
      CharacterChoice = sc.nextInt();
    }

    switch (CharacterChoice)
    {
      case 1: return new Knight("Bruce the Mighty");
      case 2: return new Knight("Leon the Wicked Mage");
      case 3: return new Knight("Eden the Wood Elf");
      case 4: return new Knight("Ethan the Deadly");
      default: return new Knight("Normal Guy");
    }
  }
}


