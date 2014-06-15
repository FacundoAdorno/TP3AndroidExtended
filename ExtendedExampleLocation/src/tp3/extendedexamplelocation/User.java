package tp3.extendedexamplelocation;

import java.util.Vector;

public class User {

	private Vector<ContextFeature> contextFeatures = new Vector<ContextFeature>();
	
	public User() {
		super();
		ContextFeature positionContext = new ContextFeature("position", null);
		contextFeatures.add(positionContext);
	}

	public Vector<ContextFeature> getContextFeatures() {
		return contextFeatures;
	}

	public void setContextFeatures(Vector<ContextFeature> contexto) {
		this.contextFeatures = contexto;
	}
	
	public ContextFeature getContextFeature(String nombre) {
		for (int i = 0; i < contextFeatures.size(); i++) {
			if (this.getContextFeatures().elementAt(i).getNombre() == nombre) {
				return this.getContextFeatures().elementAt(i);
			}
		}
		return null;
	}
	
	
	public void setContextFeature(String nombre, Object valor) {
		// Si ya existe lo tengo que actualizar, si no existe lo tengo que crear y agregar a la colección
		// Existe en la colección
		boolean encontre = false;
		for (int i = 0; i < contextFeatures.size(); i++) {
			if (this.getContextFeatures().elementAt(i).getNombre() == nombre) {
				 this.getContextFeatures().elementAt(i).setValor(valor);
				 encontre = true;
				 break;
			}
		}
		// No existía en la colección
		if (!encontre) {
			this.getContextFeatures().add(new ContextFeature(nombre, valor));
		}
		return;
	}
	
}
