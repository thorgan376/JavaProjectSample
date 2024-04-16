/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Book {
        String id;
        String name;
        String type;
        String Producer;
        Float borrowFee;
        int Amount;
        String borrowBy="";

        static String getAlphaNumericString()
            {
                String AlphaNumericString = "0123456789";
                StringBuilder sb = new StringBuilder(4);
                for (int i = 0; i < 4; i++) {
                    int index = (int)(AlphaNumericString.length() * Math.random());
                    sb.append(AlphaNumericString.charAt(index));
                }
                return sb.toString();
            }

  
    

    public String getBorrowBy() {
        return borrowBy;
    }

    public void setBorrowBy(String borrowBy) {
        this.borrowBy = borrowBy;
    }
        
        public Book() {
        }

        public Book(String id ,String name ,String type ,String Producer ,float borrowFee ,int Amount ,String borrowBy) {
            this.name = name;
            this.type = type;
            this.Producer = Producer;
            this.borrowFee = borrowFee;
            this.Amount = Amount;
            this.id = id;
            this.borrowBy = borrowBy;
        }
        public Book(String name ,String type ,String Producer ,float borrowFee ,int Amount) {
            this.name = name;
            this.type = type;
            this.Producer = Producer;
            this.borrowFee = borrowFee;
            this.Amount = Amount;
            String idHead = "";
            do{
            idHead = "";
            idHead += BookModify.getIdHead(type);
            idHead += getAlphaNumericString();
            }while(BookModify.checkIdBook(idHead) == 1);
            this.id = idHead;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getProducer() {
            return Producer;
        }

        public void setProducer(String phoneNumber) {
            this.Producer = Producer;
        }

        public Float getBorrowFee() {
            return borrowFee;
        }

        public void setBorrowFee(Float borrowFee) {
            this.borrowFee = borrowFee;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }
}
