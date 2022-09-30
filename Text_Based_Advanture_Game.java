

import java.util.Random;
import java.util.Scanner;

public class Text_Based_Advanture_Game {
    public static void main (String arge [ ]){
    Scanner sc = new Scanner (System.in);
    Random rand = new Random();

    String [ ] enemies = {"Skeleton"," Zombie"," Robot", "Warrior"};
    int maxEnemyHealth = 80;
    int enemyAttackDamage= 25;

    int health = 100;
    int attackDamage = 30;
    int numofHealthPotion = 3;
    int maxHealPotion = 30;
    int healthPotionDropChance= 50;

    boolean running = true;

    GAME :
    while(running) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Dungeon...");
        String enemy = enemies [rand.nextInt(enemies.length)];
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        System.out.println("\t# " + enemy +" has appeared #\n" );
        LOGIC:
        while (maxEnemyHealth>0){
            System.out.println("\tYour Health =" + health);
            System.out.println("\t " + enemy+ " health ="+enemyHealth);
            System.out.println("\t What would you like to choose  ");
            System.out.println("\t \n\t1. Attack");
            System.out.println("\t \n\t 2. Drink Potion");
            System.out.println("\t \n\t 3. Run");
            int input = sc.nextInt();
            if (input ==1){
                int damageDealt = rand.nextInt(attackDamage);
                int damageRecieve= rand.nextInt(enemyAttackDamage);

                health = health - damageRecieve;
                enemyHealth = enemyHealth-damageDealt;
                System.out.println("\tYou strike the "+enemy+" by ="+damageDealt+" damage ");
                System.out.println("\tYou received = "+damageRecieve+ " damage ");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                if (health<1){
                    System.out.println("You received too much damage!!!");
                }
                if (enemyHealth<=0){
                    System.out.println(enemy +" is dead....");
                }
                else{
                    continue LOGIC;
                }
                break;
            }

            else if (input ==2){
               if (numofHealthPotion>0){
                   health += maxHealPotion;
                   numofHealthPotion--;
                   System.out.println("\tYou drank a Health Potion , you healed up for "+maxHealPotion
                                         + "\t\nYor current Health is" +health+
                                            "\t\nHealth Potion=  "+numofHealthPotion+" left\n ");
                   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
               }
                   else
                   {
                       System.out.println("\tYou have no Health Potion left ... Defeat an enemy to have a chance");
                   }

            }

            else if (input ==3){
                System.out.println("\tYou ran away from the " +enemy+"!" );
                continue GAME;
            }
            else {
                System.out.println("Invalid Error ! ! !");

            }
        }
            if (health <1 ){
                System.out.println("You limp out of the enemy, weak from battle.");
                break;
            }

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            System.out.println("Your health is =  " +health+ " left ");

        if (rand.nextInt(100)< healthPotionDropChance){
            numofHealthPotion++;
            System.out.println("# The "+enemy+" dropped the Health Potion ! #");
            System.out.println("You have "+numofHealthPotion+"Health Potion !");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("What would you like to do now ? ");
        System.out.println("1. Continue");
        System.out.println("2. Exit Dungeon");

        int choose =sc.nextInt();

        while (choose != 1 && choose!= 2){
            System.out.println("Invalid command ! ! !");
            choose= sc.nextInt();
        }
        if (choose ==1){
            System.out.println("You can continue the your game...");
        }
        else if (choose == 2 ){
            System.out.println("You eit the Dungeon Successfully...");
            break;
        }
    }                                 // while loop terminates
        System.out.println("##################################");
        System.out.println("# Thanks for Playing ! ! ! #");
        System.out.println("##################################");

    }
}