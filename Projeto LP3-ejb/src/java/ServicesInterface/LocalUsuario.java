package ServicesInterface;
import javax.ejb.Local;

@Local
public interface LocalUsuario {
    public Usuario selectLogin(String email,String senha);
}
