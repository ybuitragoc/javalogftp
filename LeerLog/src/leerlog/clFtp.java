
package leerlog;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
 
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream; 
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class clFtp 
{
public static void main(String[] args)
{
FTPClient client = new FTPClient();
try
{
client.connect("host");

boolean login = client.login("user", "clave");
if (login)
{
System.out.println("Entro FTP");
int replay = client.getReplyCode();
if (FTPReply.isPositiveCompletion(replay))
{
File file = new File("././registros.log");
FileInputStream input = new FileInputStream(file);
client.setFileType(FTP.BINARY_FILE_TYPE);

client.enterLocalPassiveMode();
System.out.println("archivo arriba");

if (!client.storeFile(file.getName(),input))
{
System.out.println("Intente de nuevo, fallo!");
}
input.close();
}
boolean logout = client.logout();
if (logout)
{
System.out.println("Salida segura");
}
}
else
{
System.out.println("Falló inciar sesión");
}
}
catch (Exception e)
{
e.printStackTrace();
}
finally
{
try
{
client.disconnect();
}
catch (IOException e)
{
e.printStackTrace();
}
}
}
}