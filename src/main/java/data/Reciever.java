package data;

public class Reciever {

    // soads
    // Data --> functions: code
    // Object --> User { name, lastName,}
    //        --> UserService --- UserRepository
    //
    public static void main(String[] args) {

        RiceCook iranna = new Cooker();
        try {
            boolean b = iranna.cookRice(6, 12, 1);
            if (b) {
                System.out.println("Successfully cooked " + 4);
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }

        cookChappathi(2);

    }

    private static void cookChappathi(int i) {
        System.out.println("Preparing chapathi.");
    }

    public static void work(String address) {
        System.out.println("STarted executing");
        work2(address);
    }

    private static void work2(String address) {
        System.out.println("Wrok2 started started");
        if (address == null) {

        }
    }


    public interface RiceCook {
        boolean cookRice(int akki, int water, int spices) throws Exception;
    }

    public static class Cooker implements RiceCook {

        private int amountRice = 5;

        @Override
        public boolean cookRice(int akki, int water, int spices) throws Exception {
            if (amountRice < akki) {
                throw new Exception("Rice is less then requested");
            }
            turnOnGas();
            addWater(water);
            addRice(akki);
            addSPice(spices);
            closeCooker();
            amountRice = amountRice - akki;
            System.out.println("Remaining rice " + amountRice);
            return true;


            // read file
            // exists not -- no => exception scenario
            // read each
            // print
        }

        private void closeCooker() {

        }

        private void addSPice(int spices) {

        }

        private void addRice(int akki) {

        }

        private void addWater(int water) {
        }

        private void turnOnGas() {

        }
    }

    public static class COntainerCook implements RiceCook {

        @Override
        public boolean cookRice(int akki, int water, int spices) {
            return false;
        }
    }
}
