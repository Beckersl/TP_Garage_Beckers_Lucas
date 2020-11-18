package garages;

import java.io.PrintStream;
import java.util.*;


public class Voiture {

	private final String immatriculation;
	private final LinkedList<Stationnement> myStationnements = new LinkedList<>();
        private boolean estAuGarage = false; 

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?
                if (estAuGarage == true) {
			throw new IllegalArgumentException("La voiture est déja au Garage");
		}
		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);
                estAuGarage = true;
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
                if (estAuGarage == false){
                    throw new IllegalArgumentException("La voiture est déja au Garage");
                }
            
		// TODO: Implémenter cette méthode
                estAuGarage = false;
                // Trouver le dernier stationnement de la voiture
                myStationnements.getLast().terminer();
		// Terminer ce stationnement
	
            
        }
	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
                Set<Garage> garagesVisites = new HashSet();
                
                for(Stationnement n : myStationnements){
                    garagesVisites.add(n.getGarage());
                }
                return garagesVisites;
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		
		return estAuGarage;
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
                Collections.sort(myStationnements, Stationnement.ComparatorNom);
                Garage garage = new Garage("o");
                for(Stationnement n : myStationnements){
                    
                    if (garage == n.getGarage()) {
                        System.out.println(n);
                    }
                    else {
                       System.out.println("Garage " + n.getGarage().getName() + ":\n" + n); 
                    }
                    garage = n.getGarage();
                }

	}

}
