package com.alberto.plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

@ActionID(
        category = "File",
        id = "com.alberto.plugin.CrearRepo"
)
@ActionRegistration(
        iconBase = "com/alberto/plugin/github.png",
        displayName = "#CTL_CrearRepo"
)
@ActionReference(path = "Menu/Versioning", position = 0)
@Messages("CTL_CrearRepo= Crear Repositorio")

public final class CrearRepo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        //Primero pedimos un nombre para el repositorio que despues vamos a usar.
        String user = JOptionPane.showInputDialog("Nombre del usuario:");
        String pass = JOptionPane.showInputDialog("Contraseña:");
        String nombre = JOptionPane.showInputDialog("Inserta el nombre del repositorio:");
        try {
            //Conectamos con github atraves .connect e introducimos usuario y contraseña
            GitHub github = GitHub.connectUsingPassword(user, pass);            
            //Creamos el repositorio
            GHCreateRepositoryBuilder builder;
            //Insertamos el nombre que deseamos
            builder = github.createRepository(nombre);
            //Fin de la creacion.
            builder.create();
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
    }
}
