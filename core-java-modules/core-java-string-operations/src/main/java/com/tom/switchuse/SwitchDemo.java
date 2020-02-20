package com.tom.switchuse;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
public class SwitchDemo {
    public String exampleOfIF(String animal) {
        String result;
        if (animal.equals("DOG") || animal.equals("CAT")) {
            result = "domestic animal";
        } else if (animal.equals("TIGER")) {
            result = "wild animal";
        } else {
            result = "unknown animal";
        }
        return result;
    }
    public String exampleOfSwitch(String animal) {
        String result;
        switch (animal) {
            case "DOG":
                result = "domestic animal";
                break;
            case "CAT":
                result = "domestic animal";
                break;
            case "TIGER":
                result = "wild animal";
                break;
            default:
                result = "unknown animal";
                break;
        }
        return result;
    }
    public void forgetBreakInSwitchWithoutBreak(String animal) {
        switch (animal) {
            case "DOG":
                System.out.println("domestic animal");
            default:
                System.out.println("unknown animal");
        }
    }
    public String exampleOfSwitchWithBreak(String animal) {
        String result;
        switch (animal) {
            case "DOG":
            case "CAT":
                result = "domestic animal";
                break;
            case "TIGER":
                result = "wild animal";
                break;
            default:
                result = "unknown animal";
                break;
        }
        return result;
    }

    /*public void test(){
        final String dog="DOG";
        String cat="CAT";

        switch (animal) {
            case dog: //compiles
                result = "domestic animal";
            case cat: //does not compile
                result = "feline"
        }
    }*/
}
