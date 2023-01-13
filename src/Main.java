public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);
        System.out.println("Ваш счет: "+bankAccount.getAmount());
        while (true){
            try {
                bankAccount.withDraw(6000);
                System.out.println("Успешно. У вас осталось: "+bankAccount.getAmount());
            } catch (LimitException e) {
                try {
                    bankAccount.withDraw((int) e.getRemainingAmount());
                    System.out.println("Успешно. У вас осталось: "+bankAccount.getAmount());
                    break;
                } catch (LimitException ex) {
                    System.out.println("ERROR: "+ex.getMessage());
                }
            }
        }
    }
}