import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public interface IQuery {

    public String construirQuery(String tipo);
    public void insert() throws RegistroDuplicadoException;
}
