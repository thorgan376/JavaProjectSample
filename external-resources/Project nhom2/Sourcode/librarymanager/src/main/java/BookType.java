/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class BookType {
    String id;
    String type;

    static String getIdType()
            {
                String IdTypeString = "QWERTYUIOPASDFGHJKLZXCVBNM";
                StringBuilder sb = new StringBuilder(1);
                do {
                    sb = new StringBuilder(1);
                    int index = (int)(IdTypeString.length() * Math.random());
                    sb.append(IdTypeString.charAt(index));
                }while(BookModify.checkIdType(sb.toString()) == 1);
                return sb.toString();
            }
    
    public BookType(String type) {
        this.id = getIdType();
        this.type = type;
    }

    public BookType(String id, String type) {
        this.id = id;
        this.type = type;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String typr) {
        this.type = typr;
    }
    
}
