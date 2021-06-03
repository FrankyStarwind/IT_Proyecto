/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Laura
 */
public class email extends ActionSupport {
   
    private String correoMio;
    private String correo = "actividadescontacto@gmail.com";
    private String clave="actividades1234";
    private String to = "actividadescontacto@gmail.com";
    private String asunto;
    private String comentario;

    static Properties properties = new Properties();

    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    

    public String getCorreoMio() {
        return correoMio;
    }

    public void setCorreoMio(String correoMio) {
        this.correoMio = correoMio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        email.properties = properties;
    }
    public String execute() {
        String ret = SUCCESS;
        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication
                        getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, clave);
                        }
                    }
            );

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(asunto);
            message.setText(comentario +"Correo de contacto: "+ correoMio);
            Transport.send(message);
        } catch (Exception e) {
            ret = ERROR;
            e.printStackTrace();
        }
        return ret;
    }
    
}
