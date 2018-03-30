package FizzBuzz;

import javax.rmi.CORBA.Util;

public class FizzBuzz{
    private Util util;

    public FizzBuzz(){

    }

    public FizzBuzz(Util util){

        this.util = util;
    }

    public String number(int num1){
        util.equals(num1);
        return String.valueOf(num1);
    }

    public String lammalammadingdong(int num1) {
        if (num1%3 == 0)
            return "fizz";
        else if(num1%5 == 0)
            return "buzz";
        else return null;
    }
}
