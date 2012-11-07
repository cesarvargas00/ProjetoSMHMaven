package br.edu.mackenzie.projetoSMHMaven.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
   public static String MD5( String str ) {
       MessageDigest md = null;
       
       try {
           md = MessageDigest.getInstance( "MD5" ) ;
       }
       catch ( NoSuchAlgorithmException e ) {
           e.printStackTrace();
       }

       BigInteger hash = new BigInteger( 1 , md.digest( str.getBytes() ) ) ;

       return hash.toString(16);
   }

}
