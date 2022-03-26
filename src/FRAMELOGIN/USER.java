
package FRAMELOGIN;

public class USER {
    String username;
    String ingame;
    String password;


    

    int record1;
    int record2;
    int record3;
    int record4;
    
    public USER(){
        this.username = "";
        this.ingame = "";
        this.record1 = 0;
        this.record2 = 0;
        this.record3 = 0;
        this.record4 = 0;
    }
    
    public USER(String username, String ingame, String password){
        this.username = username;
        this.ingame = ingame;
        this.password = password;
        this.record1 = 0;
        this.record2 = 0;
        this.record3 = 0;
        this.record4 = 0;

    }

    public USER(String username, String ingame, String password, int record1, int record2, int record3, int record4){
        this.username = username;
        this.ingame = ingame;
        this.password = password;
        this.record1 = record1;
        this.record2 = record2;
        this.record3 = record3;
        this.record4 = record4;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIngame() {
        return ingame;
    }

    public int getRecord1() {
        return record1;
    }

    public void setRecord1(int record1) {
        this.record1 = record1;
    }

    public int getRecord2() {
        return record2;
    }

    public void setRecord2(int record2) {
        this.record2 = record2;
    }

    public int getRecord3() {
        return record3;
    }

    public void setRecord3(int record3) {
        this.record3 = record3;
    }

    public int getRecord4() {
        return record4;
    }

    public void setRecord4(int record4) {
        this.record4 = record4;
    }

    public void setIngame(String ingame) {
        this.ingame = ingame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
