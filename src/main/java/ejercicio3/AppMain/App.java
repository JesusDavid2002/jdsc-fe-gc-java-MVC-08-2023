package ejercicio3.AppMain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ejercicio3.controllers.Controlador;
import ejercicio3.views.VistaCientificos;
import ejercicio3.views.VistaGlobalEj3;
import ejercicio3.views.VistaProyecto;
import ejercicio3.views.VistaVinculos;
import models.ModeloEj3;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(UnsupportedLookAndFeelException e) {
        	
        } catch(ClassNotFoundException e) {
        	
        } catch(InstantiationException e) {
        	
        } catch(IllegalAccessException e) {
        	
        }
        
        ModeloEj3 modelo = new ModeloEj3();
        VistaGlobalEj3 vista = new VistaGlobalEj3();
        VistaCientificos vistaC = new VistaCientificos();
        VistaProyecto vistaP = new VistaProyecto();
        VistaVinculos vistaV = new VistaVinculos();
        Controlador controlador = new Controlador(modelo, vista, vistaC, vistaP, vistaV);
        controlador.iniciarVista();
	}

}
