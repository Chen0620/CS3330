public class CS 
{
      public static void main(String[] args) 
      {
              Terrorist t1 = new Terrorist(100, 101, 42, "HellBoy", Rifle.AK47);
              MySerialization ser1 = new MySerialization();
              ser1.serializeT(t1, "t1.ser");
              MyDeSerialization deSer1 = new MyDeSerialization();
              Terrorist t2 = deSer1.deSerializeT("t1.ser");
              System.out.println(t2.getName() + " "+t2.getHealthPoint() + " "+ t2.getWeapon() + " "+t2.getX() + " "+ t2.getY());
         }
}