package exercises.ocp;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class Ldap
{
    public static void main(String[]args)
    {
        Hashtable<String, String> environment = new Hashtable<String, String>();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "LDAP://cu-env-ldap-1.eastus.cloudapp.azure.com:389/OU=QATEAM,DC=BIZAGIAZ,DC=COM");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, "bizagiaz\\cu-env");
        environment.put(Context.SECURITY_CREDENTIALS, "CUENVLDAP1psw");

        try
        {
            LdapContext context = new InitialLdapContext(environment, null);
            System.out.println("Connected..");
            System.out.println(context.getEnvironment());
            context.close();
        }
        catch (AuthenticationNotSupportedException exception)
        {
            System.out.println("The authentication is not supported by the server");
        }

        catch (AuthenticationException exception)
        {
            System.out.println("Incorrect password or username");
            exception.printStackTrace();
        }

        catch (NamingException exception)
        {
            System.out.println("Error when trying to create the context");
        }
    }
}