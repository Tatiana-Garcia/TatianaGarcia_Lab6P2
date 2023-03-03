
package tatianagarcia_lab6p2;


public class Usuarios {
    protected String user;
    protected String password;
    protected int edad;

    public Usuarios() {
    }

    public Usuarios(String user, String password, int edad) {
        this.user = user;
        this.password = password;
        this.edad = edad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "user=" + user + ", password=" + password + ", edad=" + edad + '}';
    }
    
    
}
