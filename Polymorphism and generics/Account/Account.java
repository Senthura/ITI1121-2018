public class Account {
    
    private int id;
    private String name;

    public Account( int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        if( !(o instanceof Account)) {
            return false;
        }

        Account other = (Account) o;

        if(id != other.id) {
            return false;
        } else if((name == null) && (other.name != null)) {
            return false;
        } else {
            return (name == null || name.equals(other.name));

        }
    }
}


