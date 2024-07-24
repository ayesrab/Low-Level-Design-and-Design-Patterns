package DesignATM;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void getAllTransationType(){
        for(TransactionType t : TransactionType.values()){
            System.out.println(t);
        }
    }
}
