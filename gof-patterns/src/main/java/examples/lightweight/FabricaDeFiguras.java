package examples.lightweight;

import java.util.HashMap;

public class FabricaDeFiguras {
	HashMap<String, IPresentable> figuras = new HashMap<String, IPresentable>();

	IPresentable getFigura(String clave) {
		IPresentable figura = null;

		if (figuras.containsKey(clave)) {
			figura = figuras.get(clave);
		} else if(clave.equalsIgnoreCase("pathNota")){
			figura = new Nota("smartArt");
			figuras.put(clave, figura);
		} else {
			figura = new Figura(clave);
			figuras.put(clave, figura);
		}
		return figura;
	}
}
