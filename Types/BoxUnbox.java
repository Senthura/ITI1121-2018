public class BoxUnbox {

    private static  long iterations = 100000000; // 100 millions

  
    private static long loopUsingPrimitiveType(){

        long counter = 0L;       
        long start =System.currentTimeMillis();
        for(long i = 0L ; i < iterations; i++){
            counter = counter + 1L;
        } 
        return (System.currentTimeMillis() - start);
    }


    private static long loopUsingWrapper(){

        Long counter = (long)0;       
        long start =System.currentTimeMillis();
        for(long i = 0 ; i < iterations; i++){
            counter = counter + (long)1;
        } 
        return (System.currentTimeMillis() - start);
    }

    public static void main(String[] args){
        System.out.println("loopUsingPrimitiveType: " + 
                loopUsingPrimitiveType());
        System.out.println("loopUsingWrapper: " + 
                loopUsingWrapper());

    }
}

