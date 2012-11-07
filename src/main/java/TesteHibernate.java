import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteHibernate {
	
	public static void main( String[] args ) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoSMH" ) ;		
		factory.close() ;
	}

}
