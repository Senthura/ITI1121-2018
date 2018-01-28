class TestTime{
    
    public static void main(String[] args){
 
        Time t;
        t = new Time(10,45,11);

 
        System.out.println("t: " + t);
        
        Time t2 = new Time(10,45,12);
        
        System.out.println("t2: " + t2);

        System.out.println("t equals t2: " + t.equals(t2));


        t.increase();
        System.out.println("t: " + t);
        System.out.println("t equals t2: " + t.equals(t2));

        
        Time t3 = new Time(3210,435,1287);
        System.out.println("t3: " + t3);


    } 
}
