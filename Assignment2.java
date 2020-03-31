import java.util.Scanner;

public class Assignment2{

    public static void bmi(int height, int weight){

        double sq = height * height;
        double bmi = 703 * (weight / sq);

        System.out.println("\nYour BMI is " + (String.format("%.2f", bmi)) + ".\n");
        if(bmi < 18.5){
            System.out.println("Your BMI classification is Underweight.");
        }else if(bmi >= 18.5 && bmi <= 24.9){
            System.out.println("Your BMI classification is Normal Weight.");
        }else if(bmi >= 25 && bmi <= 29.9){
            System.out.println("Your BMI classification is Overweight.");
        }else if(bmi > 30){
            System.out.println("Your BMI classification is Obese.");
        }
    }

    public static void retire(int age, Long salary, int saved, Long goal){
        double percent = (double)saved / 100.0;
        double yearlySaved = (salary * percent) + ((salary * percent) * 0.35);
        int finalAge = (int) ((Math.ceil(goal / yearlySaved)) + age);

        if(finalAge > 100){
            System.out.println("\nYou would be " + finalAge + " by the time you saved $" + goal + ", by which point, you would be dead");
        }else{
            System.out.println("\nYou would be " + finalAge + " by the time you saved " + goal + ".");
        }
    }

    public static boolean bmiInput(String[] height, String weight){
        try{
            int foot = Integer.parseInt(height[0]);
            int inch = Integer.parseInt(height[1]);
            int inches = (foot * 12) + inch;
            int pounds = Integer.parseInt(weight);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static boolean retireInput(String age, String salary, String saved, String goal){
        try{
            Integer.parseInt(age);
            Long.parseLong(salary);
            Integer.parseInt(saved);
            Long.parseLong(goal);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
            while(!exit){
            System.out.println("\nWelcome to the limited use calculator!\nType exit at any point to exit\n\nPlease select the calculator number you would like to use:\n\n" +
                    "1. Body Mass Index (BMI)\n" +
                    "2. Retirement\n" +
                    "3. Exit");

            String selection = scan.nextLine();
                switch (selection) {
                    case "1":
                        boolean x = false;
                        while(!x){
                            x = true;
                            System.out.println("\nPlease put in your height in the following format (feet, inches):");
                            String height = scan.nextLine();
                            if(height.equals("exit") || height.equals("Exit")){
                                System.exit(1);
                            }

                            height = height.replaceAll("\\s", "");
                            String[] heightA = height.split(",");

                            System.out.println("\nPlease put in your weight in pounds:");
                            String weight = scan.nextLine();
                            if(weight.equals("exit") || weight.equals("Exit")){
                                System.exit(1);
                            }

                            boolean exe = bmiInput(heightA, weight);

                            if(exe) {
                                int foot = Integer.parseInt(heightA[0]);
                                int inch = Integer.parseInt(heightA[1]);
                                int inches = (foot * 12) + inch;
                                int pounds = Integer.parseInt(weight);

                                if((foot <= 0 && inch <= 0) || (foot >= 10 && inch >= 0) || pounds <= 0 || pounds >= 1000){
                                    System.out.println("\nInvalid input. Please make all numbers positive.\n");
                                    x = false;
                                }else{
                                    bmi(inches, pounds);
                                }
                            }else{
                                System.out.println("\nInvalid input. Please make all inputs numbers and put them in the requested format.\n");
                                x = false;
                            }
                        }

                        break;
                    case "2":
                        boolean y = false;
                        while(!y) {
                            y = true;
                            System.out.println("\nPlease put in your current age (min: 14, max: 99): ");
                            String age = scan.nextLine();
                            if(age.equals("exit") || age.equals("Exit")){
                                System.exit(1);
                            }

                            System.out.println("\nPlease put in your annual salary (min: 1, max: 1850000000): ");
                            String salary = scan.nextLine();
                            if(salary.equals("exit") || salary.equals("Exit")){
                                System.exit(1);
                            }

                            System.out.println("\nPlease put in your percentage saved annually as a whole number less than 100 (excluding employer matching): ");
                            String saved = scan.nextLine();
                            if(saved.equals("exit") || saved.equals("Exit")){
                                System.exit(1);
                            }

                            System.out.println("\nPlease put in your retirement savings goal (min: 1): ");
                            String goal = scan.nextLine();
                            if(goal.equals("exit") || goal.equals("Exit")){
                                System.exit(1);
                            }

                            boolean exe = retireInput(age, salary, saved, goal);

                            if (exe) {
                                int a = Integer.parseInt(age);
                                long sl = Long.parseLong(salary);
                                int sv = Integer.parseInt(saved);
                                long g = Long.parseLong(goal);

                                if(a < 14 || a >= 100 || sl <= 0 || sl > 1850000000 || sv <=0 || sv >= 100 || g <= 0) {
                                    System.out.println("\nInvalid input. Please make all numbers positive.\n");
                                    y = false;
                                }else{
                                    retire(a, sl, sv, g);
                                }
                            }else {
                                System.out.println("\nInvalid input. Please make all inputs numbers and put them in the requested format.\n");
                                y = false;
                            }
                        }
                        break;
                    case "3":
                        exit = true;
                        break;
                }
        }
    }
}