package br.edu.mackenzie.projetoSMHMaven.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

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

   public static String formmatCallendar( Calendar cal ) {
		if ( cal == null ) {
			return "" ;
		}

		String datetime = "" ;

		datetime += cal.get(Calendar.DAY_OF_MONTH) ;
		datetime += "/" ;
		datetime += ( cal.get(Calendar.MONTH) + 1 ) ;
		datetime += "/" ;
		datetime += cal.get(Calendar.YEAR) ;
		datetime += " às " ;
		datetime += cal.get(Calendar.AM) ;
		datetime += "h" ;
		datetime += cal.get(Calendar.MINUTE) ;

		return datetime ;
   }

}
