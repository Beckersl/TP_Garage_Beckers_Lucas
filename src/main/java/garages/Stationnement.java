package garages;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Stationnement {

	private final Voiture myCar;
	private final Garage myGarage;

	private final Date entree = new Date(); // Aujourd'hui
	private Date fin;

	public Stationnement(Voiture v, Garage g) {
		myCar = v;
		myGarage = g;
	}

	public Voiture getCar() {
		return myCar;
	}

	public Garage getGarage() {
		return myGarage;
	}

	public Date getEntree() {
		return entree;
	}

	public Date getFin() {
		return fin;
	}

	public void terminer() {
		fin = new Date();
	}

	public boolean estEnCours() {
		return (fin == null);
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		return String.format("Stationnement{ entree=%s, %s }",
			dateFormat.format(entree),
			estEnCours() ? "en cours" : "sortie=" + dateFormat.format(fin)
		);
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.myGarage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stationnement other = (Stationnement) obj;
        if (!Objects.equals(this.myGarage, other.myGarage)) {
            return false;
        }
        return true;
    }
        public static Comparator<Stationnement> ComparatorNom = new Comparator<Stationnement>() {
      
        @Override
        public int compare(Stationnement e1, Stationnement e2) {
            return e1.getGarage().compareTo(e2.getGarage());
        }
    };

}
